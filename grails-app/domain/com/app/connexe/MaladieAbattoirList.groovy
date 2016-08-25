package com.app.connexe

import com.app.cheptel.MaladieAbattoir

class MaladieAbattoirList {

    String libelle
    Date dateCreated
    Date lastUpdated

    static hasMany = [objects: MaladieAbattoir]

    static constraints = {
        libelle blank: false, unique: true
    }

    String toString() {
      return libelle
    }
}
