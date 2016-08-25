package com.app

import com.app.connexe.InformationIndicateur

class Indicateur {

    String departement
    
    String commune
    
    String annee
    
    String unite = ""
                
    String valeur
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [information:InformationIndicateur]
    
    static constraints = {
        unite nullable: true
    }
}
