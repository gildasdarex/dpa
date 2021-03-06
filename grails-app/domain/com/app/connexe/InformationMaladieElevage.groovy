package com.app.connexe

import com.app.cheptel.MaladieElevage

class InformationMaladieElevage {

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
