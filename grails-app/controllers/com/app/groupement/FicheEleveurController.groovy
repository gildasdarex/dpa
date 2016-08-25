package com.app.groupement


import com.app.groupement.FicheEleveur
import com.app.connexe.EspeceAnimaux
import com.app.connexe.TypeEleveur
import com.app.connexe.TypeHabitatEleveur
import com.app.BaseController


class FicheEleveurController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = FicheEleveur
    
    def fields = ["departement", "commune", "annee", "sexe" ,"espece", "typeEleveur", "typeHabitatEleveur", "effectif"]

    def create(){
        [
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         typeEleveurs: TypeEleveur.list(sort:'libelle', order:'asc'),
         typeHabitatEleveurs: TypeHabitatEleveur.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
         especes: EspeceAnimaux.list(sort:'libelle', order:'asc'),
         typeEleveurs: TypeEleveur.list(sort:'libelle', order:'asc'),
         typeHabitatEleveurs: TypeHabitatEleveur.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
      ]
    }
  
}
