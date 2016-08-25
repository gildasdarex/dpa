package com.app.cheptel


import com.app.cheptel.MaladieAbattoir
import com.app.connexe.EspeceAnimaux
import com.app.connexe.InformationMaladieAbattoir
import com.app.connexe.MaladieAbattoirList
import com.app.BaseController


class MaladieAbattoirController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'

    def dataService
    def filterPaneService
    def exportService
    def excelService

    def className = MaladieAbattoir

    def fields = ["departement", "commune", "annee", "espece", "maladie", "information", "effectif"]

    def create(){
        [
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         informations: InformationMaladieAbattoir.list(sort:'libelle', order:'asc'),
         maladies: MaladieAbattoirList.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
        especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
        informations: InformationMaladieAbattoir.list(sort:'libelle', order:'asc'),
        maladies: MaladieAbattoirList.list(sort:'libelle', order:'asc'),
        departements: dataService.get_departements(),
        communes: dataService.get_communes()
      ]
    }

}
