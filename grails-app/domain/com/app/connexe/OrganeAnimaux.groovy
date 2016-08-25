package com.app.connexe

import com.app.cheptel.SaisiePartielle

class OrganeAnimaux {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [
                      saisies: SaisiePartielle
                     ]

    static constraints = {
        libelle blank: false, unique: true
    }
    
    String toString() {
      return libelle
    }
}
