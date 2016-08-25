package com.app


import com.app.Indicateur
import com.app.connexe.InformationIndicateur
import com.app.BaseController


class IndicateurController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = Indicateur
    
    def fields = ["departement", "commune", "annee", "information" ,"valeur", "unite"]

    def create(){
        [
         informations: InformationIndicateur.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
         informations: InformationIndicateur.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
      ]
    }
  
}