package com.app.cheptel

import com.app.connexe.EspeceAnimaux
import com.app.connexe.Lieu

class MouvementCommerciaux {

    String departement
    
    String commune
    
    String annee
    
    String sexe
    
    int effectif
    
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [espece: EspeceAnimaux, provenance: Lieu, destination: Lieu ]
    
    static constraints = {
        departement(unique: ['commune', 'annee', 'annee','sexe','espece'])
    }
}
