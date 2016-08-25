package com.app.cheptel

import com.app.connexe.MaladieElevageList
import com.app.connexe.InformationMaladieElevage
import com.app.connexe.EspeceAnimaux

class MaladieElevage {

  String departement

  String commune

  String annee

  int effectif

  Date dateCreated
    
  Date lastUpdated

  static belongsTo = [espece: EspeceAnimaux,
                     maladie: MaladieElevageList,
                     information: InformationMaladieElevage
                     ]

  static constraints = {
  }
}
