package com.app.connexe

import com.app.Pluviometrie

class InformationPluviometrie {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [
                      pluviometries: Pluviometrie 
                     ]

    static constraints = {
        libelle blank: false, unique: true
        pluviometries nullable: true
    }
    
    String toString() {
      return libelle
    }
}
