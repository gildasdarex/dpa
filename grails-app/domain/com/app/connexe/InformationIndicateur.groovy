package com.app.connexe

import com.app.Indicateur

class InformationIndicateur {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [
                      indicateurs: Indicateur 
                     ]

    static constraints = {
        libelle blank: false, unique: true
        indicateurs nullable: true
    }
    
    String toString() {
      return libelle
    }
}
