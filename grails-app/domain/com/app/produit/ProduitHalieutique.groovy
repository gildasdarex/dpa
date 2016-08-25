package com.app.produit


import com.app.connexe.NatureProduitHalieutique
import com.app.connexe.InformationProduitHalieutique
import com.app.connexe.Lieu

class ProduitHalieutique {

    String departement
    
    String commune
    
    String annee
    
    String motif
        
    String valeur
    
    Date dateCreated
    
    Date lastUpdated
    
    static belongsTo = [nature: NatureProduitHalieutique,
                        information: InformationProduitHalieutique, 
                        origine: Lieu, 
                        destination: Lieu 
                       ]
    
    static constraints = {
    }
}
