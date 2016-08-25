package com.app.connexe

import com.app.culture.AgroIndustriel

class InformationAgroIndustriel {

    String libelle
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [
                      agroIndustriels: AgroIndustriel               
                     ]

    static constraints = {
        libelle blank: false, unique: true
        agroIndustriels nullable: true
    }
    
    String toString() {
      return libelle
    }
}
