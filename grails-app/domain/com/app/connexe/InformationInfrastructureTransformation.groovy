package com.app.connexe

import com.app.materiel.InfrastructureTransformation

class InformationInfrastructureTransformation {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [
                      objects: InfrastructureTransformation
                     ]

    static constraints = {
        libelle blank: false, unique: true
    }
    
    String toString() {
      return libelle
    }
}
