package com.app.cheptel

import com.app.connexe.InformationTranshumanceFrontaliere
import com.app.connexe.Lieu

class TranshumanceFrontaliere {

    String annee

    String valeur

    Date dateCreated

    Date lastUpdated

    static belongsTo = [information: InformationTranshumanceFrontaliere, provenance: Lieu, destination: Lieu, acceuil: Lieu ]

    static constraints = {
    }
}
