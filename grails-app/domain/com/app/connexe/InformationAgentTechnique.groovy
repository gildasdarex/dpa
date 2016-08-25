package com.app.connexe

import com.app.personnel.AgentTechnique

class InformationAgentTechnique {

    String libelle
    Date dateCreated
    Date lastUpdated

    static hasMany = [objects: AgentTechnique]

    static constraints = {
        libelle blank: false, unique: true
    }

    String toString() {
      return libelle
    }
}
