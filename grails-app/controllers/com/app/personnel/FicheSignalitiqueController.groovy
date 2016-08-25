package com.app.personnel


import com.app.personnel.FicheSignalitique
import com.app.BaseController


class FicheSignalitiqueController  extends BaseController {

    static defaultAction = 'list'

    static layout = 'main'
    
    def dataService
    def filterPaneService
    def exportService
    def excelService
    
    def className = FicheSignalitique
    

    def create(){
       
    }

    def edit(){
      [edit_object: className.get(params.id)]
    }

 
    
    
    
  
}
