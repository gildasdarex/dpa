package com.app.cheptel


import com.app.cheptel.TranshumanceNationale
import com.app.connexe.Lieu
import com.app.connexe.InformationTranshumanceNationale
import com.app.BaseController


class TranshumanceNationaleController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'

    def dataService
    def filterPaneService
    def exportService
    def excelService

    def className = TranshumanceNationale

    def fields = ["annee", "acceuil", "destination", "provenance", "information", "valeur"]

    def create(){
        [
         informations: InformationTranshumanceNationale.list(sort:'libelle', order:'asc'),
         lieux: Lieu.list(sort:'libelle', order:'asc')
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
         informations: InformationTranshumanceNationale.list(sort:'libelle', order:'asc'),
         lieux: Lieu.list(sort:'libelle', order:'asc')
      ]
    }

}
