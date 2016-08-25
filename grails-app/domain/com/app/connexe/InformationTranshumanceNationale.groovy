package com.app.connexe

import com.app.cheptel.TranshumanceNationale

class InformationTranshumanceNationale {

  String libelle
  Date dateCreated
  Date lastUpdated

  static hasMany = [transhumanceNationales: TranshumanceNationale]

  static constraints = {
      libelle blank: false, unique: true
  }

  String toString() {
    return libelle
  }
}
