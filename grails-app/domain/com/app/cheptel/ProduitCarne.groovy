package com.app.cheptel

import com.app.connexe.ProduitCarneList

class ProduitCarne {

    String origine

    String destination

    String annee

    String nature

    int valeur

    String unite

    Date dateCreated

    Date lastUpdated

    static belongsTo = [produit: ProduitCarneList]

    static constraints = {
    }
}
