package com.app.connexe


import com.app.materiel.ParcAutomobile

class InformationParcAutomobile {

    String libelle
    Date dateCreated
    Date lastUpdated

    static hasMany = [
                      objects: ParcAutomobile
                     ]

    static constraints = {
        libelle blank: false, unique: true
    }

    String toString() {
      return libelle
    }
}
