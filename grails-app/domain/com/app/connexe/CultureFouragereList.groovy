package com.app.connexe

import com.app.culture.CultureFouragere

class CultureFouragereList {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [
                      cultureFourageres: CultureFouragere
                     ]

    static constraints = {
        libelle blank: false, unique: true
    }
    
    String toString() {
      return libelle
    }
}
