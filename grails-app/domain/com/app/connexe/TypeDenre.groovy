package com.app.connexe

class TypeDenre {

    String libelle
    Date dateCreated
    Date lastUpdated

    static constraints = {
        libelle blank: false, unique: true
    }
}
