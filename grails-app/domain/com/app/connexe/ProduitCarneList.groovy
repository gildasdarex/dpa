package com.app.connexe

import com.app.cheptel.ProduitCarne

class ProduitCarneList {

    String libelle
    Date dateCreated
    Date lastUpdated

    static hasMany = [
                      produitCarnes: ProduitCarne
                     ]


    String toString() {
      return libelle
    }
}
