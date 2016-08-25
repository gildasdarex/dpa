package com.app.connexe


import com.app.culture.SuperficieEmblave

class InformationSuperficieEmblave {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [
                      superficieEmblaves: SuperficieEmblave
                     ]

    static constraints = {
        libelle blank: false, unique: true
        superficieEmblaves nullable: true
    }
    
    String toString() {
      return libelle
    }
}
