package com.app.materiel


import com.app.connexe.MaterielCulture

class CultureAttele {

    String departement
    
    String commune
    
    String annee
                
    int quantite
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [
               materiel: MaterielCulture
               ]
    
    static constraints = {
    }
}
