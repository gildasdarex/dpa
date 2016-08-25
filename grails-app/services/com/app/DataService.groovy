package com.app

import grails.transaction.Transactional

class DataService {

    def get_departements() {
     ["Alibori", "Atlantique", "Borgou", "Collines","Couffo", "Donga", "Atacora","Littoral", "Mono","Ouémé", "Plateau", "Borgou", "Zou"] as String[]
    }
    
    
    def get_communes() {
     [
         "Banikoara", "Gogounou", "Kandi", "Karimama","Malanville", "Segbena",
         "Allada", "Abomey-Calavi", "Kpomassé", "Ouidah","Toffo", "Sô-Ava", "Toro-Bossito", "Zè",
         "Boukoumbé", "Cobly", "Kérou", "Kouandé","Matéri", "Natitingou", "Pehonco", "Tanguiéta","Toucountouna",
         "Boukoumbé", "Kalalé", "N'Dali", "Nikki","Parakou", "Pèrèrè", "Sinendé", "Tchaourou",
         "Banté", "Dassa-Zoumè", "Glazoué", "Ouèssè","Savalou", "Savé",
         "Aplahoué", "Djakotomé", "Dogbo-Tota", "Klouékanmé","Lalo", "Toviklin",
         "Abomey", "Bohicon", "Agbangnizoun", "Djidja","Ouinhi", "Zogbodomey","Cové","Zogbodomey","Za-Kpota",
         "Athiémé", "Bopa", "Comè", "Grand-Popo","Lokossa", "Houéyogbé",
         "Adjara", "Akpo-Missérété", "Adjohoun", "Aguégués","Avrankou", "Bonou","Dangbo","Sèmè-Podji","Porto-Novo",
         "Copargo", "Bassila", "Ouaké", "Djougou",
         "Adja-Oure","Ifangni","Ketou","Pobé","Sakété",
         "Cotonou"
     ] as String[]
    }
    
    def get_mois() {
     ["Janvier", "Février", "Mars", "Avril","mai", "Juin", "Juillet","Août", "Septembre","Octobre", "Nonembre","Décembre"]  as String[]
    }
    
    def get_human_sexe() {
     ["Masculin", "Feminin"]  as String[]
    }
    
    def get_animal_sexe() {
     ["Male", "Femelle"]  as String[]
    }
    
    def get_communes(departement) {
     switch(departement){
            case "Alibori" :
                return ["Banikoara", "Gogounou", "Kandi", "Karimama","Malanville", "Segbena"] as String[]
         
            case "Atlantique" :
                return ["Allada", "Abomey-Calavi", "Kpomassé", "Ouidah","Toffo", "Sô-Ava", "Toro-Bossito", "Zè"] as String[]
         
            case "Atacora" :
                return ["Boukoumbé", "Cobly", "Kérou", "Kouandé","Matéri", "Natitingou", "Pehonco", "Tanguiéta","Toucountouna"] as String[]
         
            case "Borgou" :
                return ["Boukoumbé", "Kalalé", "N'Dali", "Nikki","Parakou", "Pèrèrè", "Sinendé", "Tchaourou"] as String[]
         
            case "Collines" :
               return ["Banté", "Dassa-Zoumè", "Glazoué", "Ouèssè","Savalou", "Savé"] as String[]
                    
            case "Couffo" :
                return ["Aplahoué", "Djakotomé", "Dogbo-Tota", "Klouékanmé","Lalo", "Toviklin"] as String[]
                    
            case "Zou" :
               return ["Abomey", "Bohicon", "Agbangnizoun", "Djidja","Ouinhi", "Zogbodomey","Cové","Zogbodomey","Za-Kpota"] as String[]
                    
            case "Mono" :
               return ["Athiémé", "Bopa", "Comè", "Grand-Popo","Lokossa", "Houéyogbé"] as String[]
                    
            case "Ouémé" :
                return ["Adjara", "Akpo-Missérété", "Adjohoun", "Aguégués","Avrankou", "Bonou","Dangbo","Sèmè-Podji","Porto-Novo"] as String[]
                    
            case "Donga" :
               return ["Copargo", "Bassila", "Ouaké", "Djougou"] as String[]
                    
            case "Littoral" :
               return ["Cotonou"] as String[]
                    
            case "Plateau" :
                return ["Adja-Oure","Ifangni","Ketou","Pobé","Sakété"] as String[]
                    
            default :
                return [] as String[]
                
        }
    }
}
