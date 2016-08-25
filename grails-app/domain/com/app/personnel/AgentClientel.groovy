package com.app.personnel

import com.app.connexe.InformationAgentClientel

class AgentClientel {
    
    String departement
    
    String commune
    
    String annee
    
    String sexe
        
    int effectif
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [information:InformationAgentClientel]
    
    static constraints = {
        departement(unique: ['commune', 'annee', 'annee','sexe'])
    }
}
