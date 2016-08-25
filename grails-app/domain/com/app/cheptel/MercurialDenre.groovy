package com.app.cheptel

import com.app.connexe.EspeceAnimaux

class MercurialDenre {

    String departement
    
    String commune
    
    String annee
                
    int prix
    
    String unite
        
    Date dateCreated
    
    Date lastUpdated
    
    
    static belongsTo = [espece: EspeceAnimaux]
    
    static constraints = {
        departement(unique: ['commune', 'annee','espece'])
    }
}
