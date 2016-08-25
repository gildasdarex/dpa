package com.app.cheptel

import com.app.connexe.InformationTranshumanceNationale
import com.app.connexe.Lieu

class TranshumanceNationale {

    String annee

    String valeur

    Date dateCreated

    Date lastUpdated

    static belongsTo = [information: InformationTranshumanceNationale, provenance: Lieu, destination: Lieu, acceuil: Lieu ]

    static constraints = {
    }
}
