package com.app.cheptel


import com.app.cheptel.Exportation
import com.app.connexe.EspeceAnimaux
import com.app.connexe.Lieu
import com.app.BaseController


class ExportationController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = Exportation
    
    def fields = ["departement", "commune", "annee", "espece", "destination", "provenance", "sexe", "effectif"]

    def create(){
        [
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         lieux: Lieu.list(sort:'libelle', order:'asc'),    
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         lieux: Lieu.list(sort:'libelle', order:'asc'),    
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
      ]
    }
  
}