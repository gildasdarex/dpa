package com.app.connexe

import com.app.materiel.CultureAttele

class MaterielCulture {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [objects: CultureAttele]

    static constraints = {
        libelle blank: false, unique: true
    }
    
    String toString() {
      return libelle
    }
}
