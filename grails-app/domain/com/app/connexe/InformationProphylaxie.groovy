package com.app.connexe

import com.app.cheptel.Prophylaxie

class InformationProphylaxie {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [objects: Prophylaxie]

    static constraints = {
        libelle blank: false, unique: true
    }
    
    String toString() {
      return libelle
    }
}
