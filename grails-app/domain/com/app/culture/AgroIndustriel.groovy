package com.app.culture

import com.app.connexe.InformationAgroIndustriel

class AgroIndustriel {

    String departement
    
    String commune
    
    String annee
                
    String valeur
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [information: InformationAgroIndustriel]
    
    static constraints = {
        departement(unique: ['commune', 'annee', 'information'])
    }
}
