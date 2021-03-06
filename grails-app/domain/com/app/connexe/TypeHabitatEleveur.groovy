package com.app.connexe

import com.app.groupement.FicheEleveur

class TypeHabitatEleveur {

    String libelle
    Date dateCreated
    Date lastUpdated
    
   static hasMany = [eleveurs: FicheEleveur]

    static constraints = {
        libelle blank: false, unique: true
    }
    
    String toString() {
      return libelle
    }
}
