package com.app.connexe

import com.app.personnel.PersonnelSoutien

class InformationPersonnelSoutien {

    String libelle
    Date dateCreated
    Date lastUpdated

    static hasMany = [objects: PersonnelSoutien]

    static constraints = {
        libelle blank: false, unique: true
    }

    String toString() {
      return libelle
    }
}
