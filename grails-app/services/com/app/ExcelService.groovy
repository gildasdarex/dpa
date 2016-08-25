package com.app

import org.apache.poi.xssf.usermodel.*
import org.apache.poi.hssf.usermodel.*

class ExcelService {
    
    def grailsApplication

    def parseExcel(file, domainClass){
        def className = getClass(domainClass)
        def domainClassProperties = []
        def properties_name = []
        def list_objects = []
        HSSFWorkbook book = new HSSFWorkbook(file);
        HSSFSheet[] sheets = book.sheets;
        def properties_names = []
        for (HSSFSheet sheet : sheets)
        {
            sheet.eachWithIndex { row, index ->
                if (index == 0 ) {
                  domainClassProperties = getClassProperties(domainClass)
                  properties_name = getClassPropertiesName(row)    
                }
                else list_objects << createObject(className, properties_name, domainClassProperties, row)
                
            }
        }
        return list_objects
      }
    
    
    private getClass(domainClass){
      grailsApplication.domainClasses.find { it.clazz.simpleName == domainClass }
    }
    
    private getClassProperties(domainClass){
     grailsApplication.domainClasses.find { it.clazz.simpleName == domainClass }.persistentProperties    
    }
    
    private getClassPropertiesName(row){
        def properties_name = []
        Iterator cellIterator = row.cellIterator()
         while(cellIterator.hasNext())
          {
            HSSFCell cell = cellIterator.next()
            properties_name << cell.getStringCellValue()  
          }
        properties_name
    }
    
    private createObject(className, properties_name, domainClassProperties, row){
     def map = [:]     
     Iterator cellIterator = row.cellIterator()    
     properties_name.eachWithIndex{ property, index ->
        
        HSSFCell cell = cellIterator.next()
        def class_property = domainClassProperties.find { it.name.equals(property) }
        if(class_property.association == false ) {
            
            switch (class_property.type) {
                 case java.lang.String : 
                   try{
                      map[property] = cell.getStringCellValue()
                    }
                    catch(any){
                    } 
                   break;
                
                 case int : 
                   try{
                      map[property] = cell.getNumericCellValue()
                    }
                    catch(any){
                      def str = (cell.getStringCellValue().equals("")) ? "0" : cell.getStringCellValue()   
                      map[property] = str as int
                    } 
                    break;
                
                 case long : 
                   try{
                      map[property] = cell.getNumericCellValue()
                    }
                    catch(any){
                      map[property] = cell.getStringCellValue() as long
                    } 
                    break;
                
                case double : 
                   try{
                      map[property] = cell.getNumericCellValue()
                    }
                    catch(any){
                      map[property] = cell.getStringCellValue() as double
                    } 
                    break;
                
                 default: println "Something else";
              }
            /*if(class_property.type == java.lang.String ) {
                
                try{
                  map[property] = cell.getStringCellValue()
                }
                catch(any){
                    
                  println property
                }
                
            }
            if(class_property.type == int) {
                try{
                  map[property] = cell.getNumericCellValue()
                }
                catch(any){
                  map[property] = cell.getStringCellValue() as int
                }
            }
            if(class_property.type == long) {
                try{
                  map[property] = cell.getNumericCellValue()
                }
                catch(any){
                  map[property] = cell.getStringCellValue() as double
                }
                
            }*/
         }
         else{
             def association_attribute = class_property.type.findByLibelle(cell.getStringCellValue())
             map[property] = association_attribute
         }
       
     }    
      map
    }
    
}
