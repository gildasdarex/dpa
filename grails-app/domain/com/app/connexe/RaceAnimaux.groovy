package com.app.connexe

class RaceAnimaux {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static belongsTo = [espece:EspeceAnimaux]

    static constraints = {
        libelle blank: false, unique: true
        espece nullable: true
    }
    
    
}
