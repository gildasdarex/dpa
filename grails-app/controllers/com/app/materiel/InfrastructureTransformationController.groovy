package com.app.materiel


import com.app.materiel.InfrastructureTransformation
import com.app.connexe.InformationInfrastructureTransformation
import com.app.connexe.TypeInfrastructureTransformation
import com.app.BaseController


class InfrastructureTransformationController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = InfrastructureTransformation
    
    def fields = ["departement", "commune", "annee",  "materiel", "quantite"]

    def create(){
        [
         informations: InformationInfrastructureTransformation.list(sort:'libelle', order:'asc'),
         types: TypeInfrastructureTransformation.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: className.get(params.id),
      informations: InformationInfrastructureElevageController.list(sort:'libelle', order:'asc'),
         types: TypeInfrastructureElevageController.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
      ]
    }

}
