package com.app.materiel


import com.app.materiel.ParcAutomobile
import com.app.connexe.TypeAutomobile
import com.app.connexe.InformationParcAutomobile
import com.app.BaseController
import com.app.annuaire.AnnuaireCultureAttele


class ParcAutomobileController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'

    def dataService
    def filterPaneService
    def exportService
    def excelService

    def className = ParcAutomobile

    def fields = ["departement", "commune", "annee",  "type", "information", "quantite"]

    def create(){
        [types: TypeAutomobile.list(sort:'libelle', order:'asc'),
         informations: InformationParcAutomobile.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: className.get(params.id),
       types: TypeAutomobile.list(sort:'libelle', order:'asc'),
       informations: InformationParcAutomobile.list(sort:'libelle', order:'asc'),
       departements: dataService.get_departements(),
       communes: dataService.get_communes()]
    }

    def annuaire_statistique(){
      def file_path = new AnnuaireCultureAttele(params.annee).get_annuaire()
      flash.success =  "L'annuaire enregistre : ${file_path}"
      redirect(action: 'list')
    }

}
