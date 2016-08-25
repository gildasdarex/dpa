package com.app.produit


import com.app.produit.ProduitHalieutique
import com.app.connexe.NatureProduitHalieutique
import com.app.connexe.InformationProduitHalieutique
import com.app.connexe.Lieu
import com.app.BaseController


class ProduitHalieutiqueController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'

    def dataService
    def filterPaneService
    def exportService
    def excelService

    def className = ProduitHalieutique

    def fields = ["departement", "commune", "annee", "nature", "information", "destination", "origine", "valeur"]

    def create(){
        [
         natures: NatureProduitHalieutique.list(sort:'libelle', order:'asc'),
         informations: InformationProduitHalieutique.list(sort:'libelle', order:'asc'),
         lieux: Lieu.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
         natures: NatureProduitHalieutique.list(sort:'libelle', order:'asc'),
         informations: InformationProduitHalieutique.list(sort:'libelle', order:'asc'),
         lieux: Lieu.list(sort:'libelle', order:'asc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()
      ]
    }

}
