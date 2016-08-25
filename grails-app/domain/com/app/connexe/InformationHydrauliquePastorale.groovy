package com.app.connexe


import com.app.culture.HydrauliquePastorale

class InformationHydrauliquePastorale {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [
                      hydrauliquePastorales: HydrauliquePastorale
                     ]

    static constraints = {
        libelle blank: false, unique: true
        hydrauliquePastorales nullable: true
    }
    
    String toString() {
      return libelle
    }
}
