package com.app.groupement


import com.app.groupement.GroupementFemme
import com.app.connexe.ActiviteGroupement
import com.app.connexe.FonctionnementGroupement
import com.app.BaseController


class GroupementFemmeController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = GroupementFemme
    
    def fields = ["departement", "commune", "annee", "activite", "fonctionnement", "effectif"]

    def create(){
        [
         activites: ActiviteGroupement.list(sort:'libelle', order:'asc'),
         fonctionnements: FonctionnementGroupement.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
         activites: ActiviteGroupement.list(sort:'libelle', order:'asc'),
         fonctionnements: FonctionnementGroupement.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
      ]
    }
  
}