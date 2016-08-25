package com.app.connexe


import com.app.groupement.FicheEleveur

class TypeEleveur {

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

