package com.app.connexe

import com.app.groupement.GroupementEleveur
import com.app.groupement.GroupementFemme

class ActiviteGroupement {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [
                      groupementEleveurs: GroupementEleveur,
                      groupementFemmes: GroupementFemme 
               
                     ]

    static constraints = {
        libelle blank: false, unique: true
        groupementEleveurs nullable: true
        groupementFemmes nullable: true
    }
    
    String toString() {
      return libelle
    }
}
