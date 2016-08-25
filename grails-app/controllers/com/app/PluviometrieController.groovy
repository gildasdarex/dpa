package com.app


import com.app.Pluviometrie
import com.app.connexe.InformationPluviometrie
import com.app.BaseController


class PluviometrieController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = Pluviometrie
    
    def fields = ["departement", "commune", "annee", "information" ,"valeur", "unite"]

    def create(){
        [
         informations: InformationPluviometrie.list(sort:'libelle', order:'asc'),
         mois: dataService.get_mois(),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
         informations: InformationPluviometrie.list(sort:'libelle', order:'asc'),
         mois: dataService.get_mois(),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
      ]
    }
  
}
