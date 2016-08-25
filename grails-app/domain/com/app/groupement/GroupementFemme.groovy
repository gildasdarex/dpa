package com.app.groupement


import com.app.connexe.FonctionnementGroupement
import com.app.connexe.ActiviteGroupement

class GroupementFemme {

    String departement
    
    String commune
    
    String annee
    
    String denommination
                
    int effectif
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [fonctionnement: FonctionnementGroupement,
                        activite: ActiviteGroupement
                       ]
    
    static constraints = {
        departement(unique: ['commune', 'fonctionnement', 'annee','activite'])
    }
}
