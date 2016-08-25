package com.app.cheptel



import com.app.connexe.MaladieProphylaxieList
import com.app.connexe.InformationProphylaxie
import com.app.connexe.EspeceAnimaux

class Prophylaxie {

    String departement

    String commune

    String annee

    int effectif

    Date dateCreated
    
    Date lastUpdated

    static belongsTo = [espece: EspeceAnimaux,
                       maladie: MaladieProphylaxieList,
                       information: InformationProphylaxie
                       ]

    static constraints = {
    }
}