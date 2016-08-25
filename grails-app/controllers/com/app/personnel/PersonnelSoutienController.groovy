package com.app.personnel


import com.app.personnel.PersonnelSoutien
import com.app.connexe.InformationPersonnelSoutien
import com.app.BaseController


class PersonnelSoutienController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = PersonnelSoutien
    
    def fields = ["departement", "commune", "annee", "sexe", "information", "effectif"]

    def create(){
        [informations: InformationPersonnelSoutien.list(sort:'lastUpdated', order:'desc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: PersonnelSoutien.get(params.id),
      informations: InformationPersonnelSoutien.list(sort:'lastUpdated', order:'desc'),
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }    
  
}
