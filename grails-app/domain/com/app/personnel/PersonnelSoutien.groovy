package com.app.personnel

import com.app.connexe.InformationPersonnelSoutien

class PersonnelSoutien {

    String departement
    
    String commune
    
    String annee
    
    String sexe
        
    int effectif
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [information:InformationPersonnelSoutien]
    
    static constraints = {
        departement(unique: ['commune', 'annee', 'annee','sexe','information'])
    }
}
