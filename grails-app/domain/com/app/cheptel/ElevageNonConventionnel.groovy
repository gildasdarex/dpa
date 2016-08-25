package com.app.cheptel

import com.app.connexe.EspeceAnimaux

class ElevageNonConventionnel {

    String departement
    
    String commune
    
    String annee
    
    String sexe = " "
    
    String race
            
    int effectif
    
    int age
    
    String unite_age
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [espece: EspeceAnimaux]
    
    static constraints = {
        race nullable: true
        age nullable: true
        sexe nullable: true
        unite_age inList: ["Jours", "Semaines", "Mois","Annees"], nullable: true
    }
}
