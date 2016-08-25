package com.app.personnel


import com.app.personnel.AgentClientel
import com.app.connexe.InformationAgentClientel
import com.app.BaseController


class AgentClientelController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = AgentClientel
    
    def fields = ["departement", "commune", "annee", "sexe", "information", "effectif"]

    def create(){
        [informations: InformationAgentClientel.list(sort:'lastUpdated', order:'desc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: className.get(params.id),
      informations: InformationAgentClientel.list(sort:'lastUpdated', order:'desc'),
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }

 
    
    
    
  
}

