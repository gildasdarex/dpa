package com.app.groupement



import com.app.connexe.TypeEleveur
import com.app.connexe.TypeHabitatEleveur
import com.app.connexe.EspeceAnimaux

class FicheEleveur {

    String departement
    
    String commune
    
    String village
    
    String nom
    
    String prenom
    
    String sexe
            
    int effectif
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [
                        espece: EspeceAnimaux,
                        typeEleveur: TypeEleveur,
                        typeHabitatEleveur: TypeHabitatEleveur
                       ]
    
    static constraints = {
        departement(unique: ['commune', 'sexe','typeEleveur','typeHabitatEleveur','espece'])
    }
}
