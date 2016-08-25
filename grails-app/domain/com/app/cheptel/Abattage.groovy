package com.app.cheptel

import com.app.connexe.EspeceAnimaux

class Abattage {

    String departement

    String commune

    String annee

    String sexe

    int effectif

    Date dateCreated

    Date lastUpdated

    static belongsTo = [espece:EspeceAnimaux]

    static constraints = {
        departement(unique: ['commune', 'annee', 'annee','sexe','espece'])
        sexe nullable: true
    }
}
