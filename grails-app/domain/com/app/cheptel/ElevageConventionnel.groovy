package com.app.cheptel

import com.app.connexe.EspeceAnimaux

class ElevageConventionnel {

    String departement

    String commune

    String annee

    String sexe

    String race

    int effectif

    int age

    String unite_age

    Date dateCreated

    Date lastUpdated

    static belongsTo = [espece: EspeceAnimaux]

    static constraints = {
        departement(unique: ['commune', 'annee', 'annee','sexe','espece', 'race'])
        race nullable: true
        age nullable: true
        sexe nullable: true
        unite_age inList: ["Jours", "Semaines", "Mois","Annees"], nullable: true
        age nullable: true
        unite_age nullable: true
    }
}
