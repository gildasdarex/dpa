package com.app.cheptel


import com.app.cheptel.ProduitCarne
import com.app.connexe.ProduitCarneList
import com.app.connexe.Lieu
import com.app.BaseController


class ProduitCarneController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'

    def dataService
    def filterPaneService
    def exportService
    def excelService

    def className = ProduitCarne

    def fields = ["origine", "destination", "annee", "produit", "valeur"]

    def create(){
        [produits: ProduitCarneList.list(sort:'lastUpdated', order:'desc'),
         lieux: Lieu.list()
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
      produits: ProduitCarneList.list(sort:'lastUpdated', order:'desc'),
      lieux: Lieu.list()]
    }

}
