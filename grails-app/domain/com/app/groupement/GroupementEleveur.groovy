package com.app.groupement

import com.app.connexe.FonctionnementGroupement
import com.app.connexe.ActiviteGroupement

class GroupementEleveur {

    String departement

    String commune

    String annee

    String denommination

    String sexe

    int effectif

    Date dateCreated

    Date lastUpdated

    static belongsTo = [
        fonctionnement: FonctionnementGroupement,
                        activite: ActiviteGroupement
                       ]

    static constraints = {
        departement(unique: ['commune', 'fonctionnement', 'sexe' ,'annee','activite'])
        denommination nullable: true
    }
}
