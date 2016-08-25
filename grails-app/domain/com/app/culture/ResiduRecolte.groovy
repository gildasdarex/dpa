package com.app.culture


import com.app.connexe.InformationResiduRecolte
import com.app.connexe.ResiduRecolteList

class ResiduRecolte {

    String departement
    
    String commune
    
    String annee
                
    String valeur
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [
               residu: ResiduRecolteList,
               information: InformationResiduRecolte]
    
    static constraints = {
    }
}

