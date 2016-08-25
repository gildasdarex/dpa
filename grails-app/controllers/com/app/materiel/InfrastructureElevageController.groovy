package com.app.materiel



import com.app.materiel.InfrastructureElevage
import com.app.connexe.InformationInfrastructureElevage
import com.app.connexe.TypeInfrastructureElevage
import com.app.BaseController


class InfrastructureElevageController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = InfrastructureElevage
    
    def fields = ["departement", "commune", "annee",  "materiel", "quantite"]

    def create(){
        [
         informations: InformationInfrastructureElevage.list(sort:'libelle', order:'asc'),
         types: TypeInfrastructureElevage.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: className.get(params.id),
      informations: InformationInfrastructureElevage.list(sort:'libelle', order:'asc'),
         types: TypeInfrastructureElevage.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
      ]
    }

}
