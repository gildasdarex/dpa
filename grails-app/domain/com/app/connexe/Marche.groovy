package com.app.connexe

class Marche {

    String libelle
    Date dateCreated
    Date lastUpdated

    static constraints = {
        libelle blank: false, unique: true
    }
}
