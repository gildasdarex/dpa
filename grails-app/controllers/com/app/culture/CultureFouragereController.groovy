package com.app.culture


import com.app.culture.CultureFouragere
import com.app.connexe.InformationCultureFouragere
import com.app.connexe.CultureFouragereList
import com.app.BaseController


class CultureFouragereController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = AgroIndustriel
    
    def fields = ["departement", "commune", "annee", "information", "culture", "valeur"]

    def create(){
        [
         informations: InformationCultureFouragere.list(sort:'libelle', order:'asc'),
         cultures: CultureFouragereList.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: className.get(params.id),
      informations: InformationCultureFouragere.list(sort:'libelle', order:'asc'),
      cultures: CultureFouragereList.list(sort:'libelle', order:'asc'),   
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }
  
}