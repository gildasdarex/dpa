package com.app.culture


import com.app.culture.SuperficieEmblave
import com.app.connexe.InformationSuperficieEmblave
import com.app.BaseController


class SuperficieEmblaveController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = SuperficieEmblave
    
    def fields = ["departement", "commune", "annee", "information", "valeur"]

    def create(){
        [informations: InformationSuperficieEmblave.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: className.get(params.id),
      informations: InformationSuperficieEmblave.list(sort:'libelle', order:'asc'),
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }
  
}
