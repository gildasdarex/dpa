package com.app.cheptel

import grails.converters.JSON
import com.app.cheptel.MercurialAnimaux
import com.app.connexe.EspeceAnimaux
import com.app.BaseController


class MercurialAnimauxController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = MercurialAnimaux
    
    def fields = ["departement", "commune", "annee", "espece", "prix"]

    def create(){
        [
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
      ]
    }
  
}
