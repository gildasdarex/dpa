package com.app.cheptel

import grails.converters.JSON
import com.app.cheptel.MercurialDenre
import com.app.connexe.EspeceAnimaux
import com.app.BaseController


class MercurialDenreController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = MercurialDenre
    
    def fields = ["departement", "commune", "annee", "espece", "prix", "unite"]

    def create(){
        def unites = className.createCriteria().list {
            projections {
                distinct('unite')
            }
        }
        unites = unites as JSON
        [
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes(),
         unites: unites 
        ]
    }

    
    def edit(){
     def unites = className.createCriteria().list {
            projections {
                distinct('unite')
            }
      }    
      [edit_object: className.get(params.id),
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes(),
         unites: unites as JSON
      ]
    }
  
}

