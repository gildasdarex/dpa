package com.app.connexe

class MaladieProphylaxieList {

    String libelle
    Date dateCreated
    Date lastUpdated

    static constraints = {
        libelle blank: false, unique: true
    }
}
