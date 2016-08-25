package com.app.cheptel

import com.app.connexe.EspeceAnimaux

class MercurialAnimaux {

    String departement
    
    String commune
    
    String annee
                
    int prix
        
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [espece: EspeceAnimaux]
    
    static constraints = {
        departement(unique: ['commune', 'annee','espece'])
    }
}
