package com.app.connexe

import com.app.produit.ProduitHalieutique

class InformationProduitHalieutique {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [
                      produitHalieutiques: ProduitHalieutique               
                     ]

    static constraints = {
        libelle blank: false, unique: true
        produitHalieutiques nullable: true
    }
    
    String toString() {
      return libelle
    }
}
