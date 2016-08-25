package com.app.cheptel

import com.app.cheptel.ElevageNonConventionnel
import com.app.connexe.EspeceAnimaux
import com.app.connexe.RaceAnimaux
import com.app.BaseController
import com.app.annuaire.AnnuaireElevageNonConventionnel


class ElevageNonConventionnelController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = ElevageNonConventionnel
    
    def fields = ["departement", "commune", "annee", "espece", "sexe", "race", "effectif"]

    def create(){
        [
         especes: EspeceAnimaux.where{is_conventionnel == false}.list(sort:'libelle', order:'asc'),
         races: RaceAnimaux.where{espece.is_conventionnel == false}.list(sort:'libelle', order:'asc'),    
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
      especes: EspeceAnimaux.where{is_conventionnel == false}.list(sort:'libelle', order:'asc'),
      races: RaceAnimaux.where{espece.is_conventionnel == false}.list(sort:'libelle', order:'asc'), 
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }
    
    def annuaire_statistique(){
      def file_path = new AnnuaireElevageNonConventionnel(params.annee).get_annuaire()
      flash.success =  "L'annuaire enregistre : ${file_path}"   
      redirect(action: 'list')
    }
  
}
