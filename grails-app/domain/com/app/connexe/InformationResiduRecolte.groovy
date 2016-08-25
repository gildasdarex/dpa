package com.app.connexe

import com.app.culture.ResiduRecolte

class InformationResiduRecolte {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [
                      residuRecoltes: ResiduRecolte
                     ]

    static constraints = {
        libelle blank: false, unique: true
        residuRecoltes nullable: true
    }
    
    String toString() {
      return libelle
    }
}
