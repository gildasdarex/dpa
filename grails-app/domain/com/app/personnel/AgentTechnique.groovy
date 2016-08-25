package com.app.personnel

import com.app.connexe.InformationAgentTechnique
import com.app.connexe.InformationTypePersonnel

class AgentTechnique {
    
    String departement
    
    String commune
    
    String annee
    
    String sexe
        
    int effectif
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [information:InformationAgentTechnique, statut: InformationTypePersonnel]
    
    static constraints = {
        departement(unique: ['commune', 'annee', 'annee','sexe','information','statut'])
    }
}
