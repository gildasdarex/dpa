package com.app.connexe

import com.app.cheptel.MouvementCommerciaux
import com.app.cheptel.TranshumanceFrontaliere
import com.app.cheptel.TranshumanceNationale

class Lieu {

    String libelle
    Date dateCreated
    Date lastUpdated

   static hasMany = [destinations: MouvementCommerciaux, provenances: MouvementCommerciaux,
                     destinations_tranf_front: TranshumanceFrontaliere, provenances_tranf_front: TranshumanceFrontaliere, acceuils_tranf_front: TranshumanceFrontaliere,
                     destinations_tranf_nat: TranshumanceNationale, provenances_tranf_nat: TranshumanceNationale, acceuils_tranf_nat: TranshumanceNationale]
   static mappedBy = [destinations:'destination', provenances:'provenance',
                      destinations_tranf_front:'destination', provenances_tranf_front:'provenance',acceuils_tranf_front: 'acceuil',
                      destinations_tranf_nat:'destination', provenances_tranf_nat:'provenance',acceuils_tranf_nat: 'acceuil']

    static constraints = {
        libelle blank: false, unique: true
    }

    String toString() {
      return libelle
    }
}
