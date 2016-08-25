package com.app.culture


import com.app.culture.HydrauliquePastorale
import com.app.connexe.InformationHydrauliquePastorale
import com.app.BaseController


class HydrauliquePastoraleController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = HydrauliquePastorale
    
    def fields = ["departement", "commune", "annee", "information", "valeur"]

    def create(){
        [informations: InformationHydrauliquePastorale.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: className.get(params.id),
      informations: InformationHydrauliquePastorale.list(sort:'libelle', order:'asc'),
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }
  
}
