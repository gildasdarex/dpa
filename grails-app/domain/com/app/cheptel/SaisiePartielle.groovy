package com.app.cheptel

import com.app.connexe.EspeceAnimaux
import com.app.connexe.OrganeAnimaux

class SaisiePartielle {

    String departement
    
    String commune
    
    String annee
        
    int valeur
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [espece: EspeceAnimaux, organe: OrganeAnimaux]
    
    static constraints = {
        departement(unique: ['commune', 'annee','espece','organe'])
    }
}
