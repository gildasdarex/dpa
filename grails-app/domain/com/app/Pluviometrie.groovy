package com.app

import com.app.connexe.InformationPluviometrie

class Pluviometrie {

    String departement
    
    String commune
    
    String annee
    
    String mois
    
    String unite = "cm3"
                
    double valeur
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [information:InformationPluviometrie]
    
    static constraints = {
    }
}


