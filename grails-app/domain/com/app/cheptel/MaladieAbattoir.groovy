package com.app.cheptel

import com.app.connexe.MaladieAbattoirList
import com.app.connexe.InformationMaladieAbattoir
import com.app.connexe.EspeceAnimaux

class MaladieAbattoir {

    String departement

    String commune

    String annee

    int effectif

    Date dateCreated
    
    Date lastUpdated

    static belongsTo = [espece: EspeceAnimaux,
                       maladie: MaladieAbattoirList,
                       information: InformationMaladieAbattoir
                       ]

    static constraints = {
    }
}
