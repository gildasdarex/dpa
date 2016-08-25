package com.app.cheptel


import com.app.cheptel.Abattage
import com.app.connexe.EspeceAnimaux
import com.app.BaseController


class AbattageController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = Abattage
    
    def fields = ["departement", "commune", "annee", "espece", "sexe", "effectif"]

    def create(){
        [especes: EspeceAnimaux.list(sort:'lastUpdated', order:'desc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: className.get(params.id),
      especes: EspeceAnimaux.list(sort:'lastUpdated', order:'desc'),
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }
  
}
