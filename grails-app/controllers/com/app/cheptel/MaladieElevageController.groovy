package com.app.cheptel


import com.app.cheptel.MaladieElevage
import com.app.connexe.EspeceAnimaux
import com.app.connexe.InformationMaladieElevage
import com.app.connexe.MaladieElevageList
import com.app.BaseController


class MaladieElevageController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'

    def dataService
    def filterPaneService
    def exportService
    def excelService

    def className = MaladieElevage

    def fields = ["departement", "commune", "annee", "espece", "maladie", "information", "effectif"]

    def create(){
        [
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         informations: InformationMaladieElevage.list(sort:'libelle', order:'asc'),
         maladies: MaladieElevageList.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
        especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
        informations: InformationMaladieElevage.list(sort:'libelle', order:'asc'),
        maladies: MaladieElevageList.list(sort:'libelle', order:'asc'),
        departements: dataService.get_departements(),
        communes: dataService.get_communes()
      ]
    }

}
