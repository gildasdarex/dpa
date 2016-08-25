package com.app.materiel

import com.app.connexe.InformationInfrastructureElevage
import com.app.connexe.TypeInfrastructureElevage

class InfrastructureElevage {

    String departement
    
    String commune
    
    String annee
                
    String valeur
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [
               information: InformationInfrastructureElevage,
               typeInfrastructureElevage: TypeInfrastructureElevage
               ]
    
    static constraints = {
    }
}
