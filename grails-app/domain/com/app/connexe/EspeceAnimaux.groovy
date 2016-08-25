package com.app.connexe

import com.app.cheptel.Abattage
import com.app.cheptel.Castration
import com.app.cheptel.ElevageConventionnel
import com.app.cheptel.ElevageNonConventionnel
import com.app.cheptel.MaladieAbattoir
import com.app.cheptel.MaladieElevage
import com.app.cheptel.MercurialAnimaux
import com.app.cheptel.MercurialDenre
import com.app.groupement.FicheEleveur

class EspeceAnimaux {

    String libelle
    boolean is_conventionnel = true
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [races: RaceAnimaux, 
                      castrations: Castration,
                      ficheEleveurs: FicheEleveur,
                      conventionnels: ElevageConventionnel, 
                      non_conventionnels: ElevageNonConventionnel,
                      abattages: Abattage,
                      maladieAbattoirs: MaladieAbattoir,
                      maladieElevages: MaladieElevage,
                      maladieElevages: MercurialAnimaux,
                      mercurialDenres: MercurialDenre
                      
                     ]
    

    static constraints = {
        libelle blank: false, unique: true
        races nullable: true
        castrations nullable: true
        conventionnels nullable: true
        non_conventionnels nullable: true
        abattages nullable: true
        maladieAbattoirs nullable: true
        maladieElevages nullable: true
        maladieElevages nullable: true
        mercurialDenres nullable: true
    }
    
    def get_races(){
        def races_as_array = races.collect{it.libelle as String}
        races_as_array
    }
    
    
    def get_effectif_conventionnel(departement, commune, annee){
        def result = conventionnels.find{
            it.departement == departement && it.commune == commune && it.annee== annee && it.espece.id == this.id
        }
        
        result == null ? 0 : result.effectif
    }
    
    def get_effectif_non_conventionnel(departement, commune, annee){
        def result = non_conventionnels.find{
                it.departement == departement && it.commune == commune && it.annee== annee && it.espece.id == this.id
        }
        result == null ? 0 : result.effectif
    }
    
    String toString() {
      return libelle
    }
}
