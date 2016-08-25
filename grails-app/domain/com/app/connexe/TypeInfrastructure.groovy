package com.app.connexe

class TypeInfrastructure {

    String libelle
    Date dateCreated
    Date lastUpdated

    static constraints = {
        libelle blank: false, unique: true
    }
}
