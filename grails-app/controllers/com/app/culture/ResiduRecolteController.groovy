package com.app.culture



import com.app.culture.ResiduRecolte
import com.app.connexe.InformationResiduRecolte
import com.app.connexe.ResiduRecolteList
import com.app.BaseController


class ResiduRecolteController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = ResiduRecolte
    
    def fields = ["departement", "commune", "annee", "information", "residu","valeur"]

    def create(){
        [
         informations: InformationResiduRecolte.list(sort:'libelle', order:'asc'),
         residus: ResiduRecolteList.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: className.get(params.id),
      informations: InformationResiduRecolte.list(sort:'libelle', order:'asc'),
      residus: ResiduRecolteList.list(sort:'libelle', order:'asc'),  
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }
  
}
