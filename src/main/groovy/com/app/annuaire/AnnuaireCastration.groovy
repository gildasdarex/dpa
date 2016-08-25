package com.app.annuaire

import com.app.cheptel.Castration
import org.apache.poi.hssf.util.CellRangeAddress
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream


class AnnuaireCastration {
    
    def headers
    def data
    def sheet
    def en_tete
    def workbook
    
    AnnuaireCastration(annee){
        
        headers = Castration.executeQuery("select distinct  espece.libelle from Castration where annee = :a   order by espece.libelle asc", [a: annee])
        
        data = Castration.executeQuery("select departement, commune, espece.libelle, sum(effectif) from Castration where annee = :a  group by departement, commune, espece.libelle order by departement asc", [a: annee])
        
        en_tete = ["Departement","Commune"] + ["Especes(Nombre de têtes)"]*headers.size()
        
        workbook = new XSSFWorkbook();
        //Create a blank sheet
        sheet = workbook.createSheet("Annuaire Statistique Castration")  
    }

    
    def get_annuaire() {
       initHeaders()
       initData()
        
       def file_separator = System.getProperty("file.separator")
       def file_path = System.getProperty("user.home")+file_separator+"logi_dpa"+file_separator+"annuaire"+file_separator+"annuaire.xls"
       //def file_path = System.getProperty("user.home")+"/logi_dap/annuaire/annuaire.xls"   
       FileOutputStream out = new FileOutputStream(new File(file_path))
       workbook.write(out)
       out.close()
        
       file_path   
    }
    
    
    private void  initHeaders() {
        def row = sheet.createRow(0)
        def cellnum = 0
        
        en_tete.each{
          def cell = row.createCell(cellnum++) 
          if (it instanceof String)  cell.setCellValue((String) it)
          if (it instanceof Integer)  cell.setCellValue((Integer) it)
        }
        
        row = sheet.createRow(1)
        cellnum = 2
        def cell_departement = row.createCell(0)
        cell_departement.setCellValue("Departement")
        def cell_commune = row.createCell(1)
        cell_commune.setCellValue("Commune")
        
        headers.each{
          def cell = row.createCell(cellnum++) 
          cell.setCellValue((String) it)
        }
        
        sheet.addMergedRegion(new CellRangeAddress(0,1,0,0))
        sheet.addMergedRegion(new CellRangeAddress(0,1,1,1))
        sheet.addMergedRegion(new CellRangeAddress(0,0,2,headers.size()+1))
          
    }
    
    
    private void  initData() {
      def rowCount = 2
        
      data.each{
          def str = []
          def departement = it[0]
          def commune = it[1]
          def row = sheet.createRow(rowCount)
          def cell_departement = row.createCell(0)
          cell_departement.setCellValue(departement)
          def cell_commune = row.createCell(1)
          cell_commune.setCellValue(commune)
          def cellnum = 2
          headers.each{
           def cell = row.createCell(cellnum++) 
           def result = dataItem(departement, commune, it)
           def value = (result == null) ? 0 : result[3]
           cell.setCellValue(value)
          }
          rowCount = rowCount + 1
        }    
          
    }
    
    def dataItem(departement, commune, espece){
        def result = data.find{
            it[0].equals(departement) && it[1].equals(commune) && it[2].equals(espece)
           }
        result
    }
    
    
}
