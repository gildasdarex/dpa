package com.app.cheptel

import com.app.cheptel.TranshumanceFrontaliere
import com.app.connexe.Lieu
import com.app.connexe.InformationTranshumanceFrontaliere
import com.app.BaseController


class TranshumanceFrontaliereController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'

    def dataService
    def filterPaneService
    def exportService
    def excelService

    def className = TranshumanceFrontaliere

    def fields = ["annee", "acceuil", "destination", "provenance", "information", "valeur"]

    def create(){
        [
         informations: InformationTranshumanceFrontaliere.list(sort:'libelle', order:'asc'),
         lieux: Lieu.list(sort:'libelle', order:'asc')
        ]
    }

    def edit(){
      [edit_object: className.get(params.id),
         informations: InformationTranshumanceFrontaliere.list(sort:'libelle', order:'asc'),
         lieux: Lieu.list(sort:'libelle', order:'asc')
      ]
    }

}
