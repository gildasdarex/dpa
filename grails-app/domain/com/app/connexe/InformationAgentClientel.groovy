package com.app.connexe

import com.app.personnel.AgentClientel

class InformationAgentClientel {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [objects: AgentClientel]

    static constraints = {
        libelle blank: false, unique: true
    }
}
