package com.app.personnel

import com.app.personnel.AgentTechnique
import com.app.connexe.InformationAgentTechnique
import com.app.connexe.InformationTypePersonnel
import grails.util.Holders
import com.app.BaseController


class AgentTechniqueController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = AgentTechnique
    
    def fields = ["departement", "commune", "annee", "sexe", "information", "statut", "effectif"]

    def create(){
        [informations: InformationAgentTechnique.list(sort:'lastUpdated', order:'desc'),
         list_statut: InformationTypePersonnel.list(sort:'lastUpdated', order:'desc'),
         departements: dataService.get_departements(),
         communes: dataService.get_communes()]
    }

    def edit(){
      [edit_object: AgentTechnique.get(params.id),
      informations: InformationAgentTechnique.list(sort:'lastUpdated', order:'desc'),
      list_statut: InformationTypePersonnel.list(sort:'lastUpdated', order:'desc'),
      departements: dataService.get_departements(),
      communes: dataService.get_communes()]
    }

 
    
    
    
  
}
