package com.app.culture

import com.app.connexe.InformationSuperficieEmblave

class HydrauliquePastorale {

    String departement
    
    String commune
    
    String annee
                
    String valeur
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [
               information: InformationSuperficieEmblave
    ]
    
    static constraints = {
    }
}
