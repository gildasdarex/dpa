package com.app.connexe

import com.app.cheptel.TranshumanceFrontaliere

class InformationTranshumanceFrontaliere {

  String libelle
  Date dateCreated
  Date lastUpdated

  static hasMany = [transhumanceFrontalieres: TranshumanceFrontaliere]

  static constraints = {
      libelle blank: false, unique: true
  }

  String toString() {
    return libelle
  }
}
