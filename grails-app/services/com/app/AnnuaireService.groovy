package com.app

import com.app.cheptel.ElevageConventionnel
import org.apache.poi.hssf.util.CellRangeAddress
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook


class AnnuaireService {
    
    def headers

    def get_elevage_conventionnel(annee) {
        
        /*def criteria = ElevageConventionnel.createCriteria()
        def results = criteria.list {
            eq "annee", "2013"
            projections {
                sqlGroupProjection 'departement, commune, espece_id , sum(effectif) as effectif', 'departement, commune, espece_id', ['departement', 'commune', 'espece_id','effectif'], [STRING, STRING,INTEGER, INTEGER]
            }
        }*/
       
    }
    
    
    
}
