package com.app.materiel


import com.app.connexe.InformationInfrastructureTransformation
import com.app.connexe.TypeInfrastructureTransformation

class InfrastructureTransformation {

    String departement
    
    String commune
    
    String annee
                
    String valeur
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [
               information: InformationInfrastructureTransformation,
               typeInfrastructureElevage: TypeInfrastructureTransformation
               ]
    
    static constraints = {
    }
}
