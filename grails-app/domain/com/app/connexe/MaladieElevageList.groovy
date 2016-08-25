package com.app.connexe

import com.app.cheptel.MaladieElevage

class MaladieElevageList {

  String libelle
  Date dateCreated
  Date lastUpdated

  static hasMany = [objects: MaladieElevage]

  static constraints = {
      libelle blank: false, unique: true
  }

  String toString() {
    return libelle
  }
}
