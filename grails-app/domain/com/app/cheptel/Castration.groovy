package com.app.cheptel

import com.app.connexe.EspeceAnimaux

class Castration {

    String departement
    
    String commune
    
    String annee
                
    int effectif
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [espece:EspeceAnimaux]
    
    static constraints = {
        departement(unique: ['commune', 'annee', 'annee','espece'])
    }
}
