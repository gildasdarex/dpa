package com.app.cheptel


import com.app.cheptel.Prophylaxie
import com.app.connexe.EspeceAnimaux
import com.app.connexe.InformationProphylaxie
import com.app.connexe.MaladieProphylaxieList
import com.app.BaseController


class ProphylaxieController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'

    def dataService
    def filterPaneService
    def exportService
    def excelService

    def className = Prophylaxie

    def fields = ["departement", "commune", "annee", "espece", "maladie", "information", "effectif"]

    def create(){
        [
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         informations: InformationProphylaxie.list(sort:'libelle', order:'asc'),
         maladies: MaladieProphylaxieList.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
        especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
        iinformations: InformationProphylaxie.list(sort:'libelle', order:'asc'),
         maladies: MaladieProphylaxieList.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
      ]
    }

}

