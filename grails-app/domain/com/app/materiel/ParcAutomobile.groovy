package com.app.materiel


import com.app.connexe.TypeAutomobile
import com.app.connexe.InformationParcAutomobile

class ParcAutomobile {

    String departement

    String commune

    String annee

    String valeur

    Date dateCreated

    Date lastUpdated

    static belongsTo = [
               typeAutomobile: TypeAutomobile,
               information: InformationParcAutomobile
               ]

    static constraints = {
    }
}
