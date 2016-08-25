package com.app.culture


import com.app.culture.AgroIndustriel
import com.app.connexe.InformationAgroIndustriel
import com.app.BaseController


class AgroIndustrielController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = AgroIndustriel
    
    def fields = ["departement", "commune", "annee", "information", "valeur"]

    def create(){
        [informations: InformationAgroIndustriel.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: className.get(params.id),
      informations: InformationAgroIndustriel.list(sort:'libelle', order:'asc'),
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }
  
}
