package com.app.culture

import com.app.connexe.InformationCultureFouragere
import com.app.connexe.CultureFouragereList

class CultureFouragere {

    String departement
    
    String commune
    
    String annee
                
    String valeur
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [
               culture: CultureFouragereList,
               information: InformationCultureFouragere]
    
    static constraints = {
    }
}
