package com.app.cheptel


import com.app.cheptel.SaisiePartielle
import com.app.connexe.OrganeAnimaux
import com.app.connexe.EspeceAnimaux
import com.app.BaseController


class SaisiePartielleController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = SaisiePartielle
    
    def fields = ["departement", "commune", "annee", "espece", "organe", "valeur"]

    def create(){
        [
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         oganes: OrganeAnimaux.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: className.get(params.id),
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         oganes: OrganeAnimaux.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }
  
}
