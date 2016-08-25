package com.app.connexe

import com.app.connexe.MaladieProphylaxieList

class MaladieProphylaxieListController {

    static defaultAction = 'list'
    
    static layout = 'main'

    def create(){
    }
    
    def edit(){
      [edit_object: MaladieProphylaxieList.get(params.id)]
    }
    
    
    def delete(){
      MaladieProphylaxieList.get(params.id).delete(flush: true)
      redirect(action: 'list')  
    }
    
    def list(){
      [list_object: MaladieProphylaxieList.list(sort:'lastUpdated', order:'desc')]
    }
    
    
    def save() {
      //create quartier
      def new_object = new MaladieProphylaxieList(libelle: params.libelle).save()
      if(new_object.hasErrors()) {
        // send errors to flash message  
        new_object.errors.allErrors.each {flash.error =  it.defaultMessage}
      }
      else {
        
        flash.success =  "Information enregistré avec success"
      }
        
      // you must return quartier to acceuil page
      redirect(action: 'list')   
    }
    
    
    def update(){
      def edit_object = MaladieProphylaxieList.get(params.id)
      edit_object.properties = params
      edit_object.save(flush: true)
      if(edit_object.hasErrors()) {
        // send errors to flash message  
        edit_object.errors.allErrors.each {flash.error =  it.defaultMessage}
      }
      else {
        flash.success =  "Information modifié avec success"
      }
        
      // you must return quartier to acceuil page
      redirect(action: 'list')       
    }
}
