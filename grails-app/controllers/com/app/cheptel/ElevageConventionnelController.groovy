package com.app.cheptel


import com.app.cheptel.ElevageConventionnel
import com.app.connexe.EspeceAnimaux
import com.app.connexe.RaceAnimaux
import com.app.BaseController
import com.app.SuperBaseController
import com.app.annuaire.AnnuaireElevageConventionnel


class ElevageConventionnelController extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    
    def className = ElevageConventionnel
    
    def fields = ["departement", "commune", "annee", "espece", "sexe", "race","effectif"]

    def create(){
        /*def closure = { map ->
            map.remove('departements')
            println map 
        }*/
        /*def closure = {Object... args ->
            args[0].remove('departements')
            println args[0] 
        }
        super.create(closure)*/
        
        [
         especes: EspeceAnimaux.where{is_conventionnel == true}.list(sort:'libelle', order:'asc'),
         races: RaceAnimaux.where{espece.is_conventionnel == true}.list(sort:'libelle', order:'asc'),    
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
      especes: EspeceAnimaux.where{is_conventionnel == true}.list(sort:'libelle', order:'asc'),
      races: RaceAnimaux.where{espece.is_conventionnel == true}.list(sort:'libelle', order:'asc'), 
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }
    
    def annuaire_statistique(){
      def file_path = new AnnuaireElevageConventionnel(params.annee).get_annuaire()
      flash.success =  "L'annuaire enregistre : ${file_path}"   
      redirect(action: 'list')
    }
  
}
