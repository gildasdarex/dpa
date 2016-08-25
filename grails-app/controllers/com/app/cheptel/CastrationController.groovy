package com.app.cheptel


import com.app.cheptel.Castration
import com.app.connexe.EspeceAnimaux
import com.app.BaseController
import com.app.annuaire.AnnuaireCastration


class CastrationController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = Castration
    
    def fields = ["departement", "commune", "annee", "espece", "effectif"]

    def create(){
        [especes: EspeceAnimaux.list(sort:'lastUpdated', order:'desc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: Abattage.get(params.id),
      especes: EspeceAnimaux.list(sort:'lastUpdated', order:'desc'),
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }
    
    def annuaire_statistique(){
      def file_path = new AnnuaireCastration(params.annee).get_annuaire()
      flash.success =  "L'annuaire enregistre : ${file_path}"   
      redirect(action: 'list')
    }
  
}
