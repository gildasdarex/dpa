package com.app.materiel


import com.app.materiel.CultureAttele
import com.app.connexe.MaterielCulture
import com.app.BaseController
import com.app.annuaire.AnnuaireCultureAttele


class CultureAtteleController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = CultureAttele
    
    def fields = ["departement", "commune", "annee",  "materiel", "quantite"]

    def create(){
        [materiels: MaterielCulture.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: className.get(params.id),
      materiels: MaterielCulture.list(sort:'libelle', order:'asc'),
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }
    
    def annuaire_statistique(){
      def file_path = new AnnuaireCultureAttele(params.annee).get_annuaire()
      flash.success =  "L'annuaire enregistre : ${file_path}"   
      redirect(action: 'list')
    }

}