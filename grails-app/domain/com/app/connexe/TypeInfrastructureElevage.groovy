package com.app.connexe


import com.app.materiel.InfrastructureElevage

class TypeInfrastructureElevage {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [
                      objects: InfrastructureElevage
                     ]

    static constraints = {
        libelle blank: false, unique: true
    }
    
    String toString() {
      return libelle
    }
}
