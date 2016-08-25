package com.app.connexe

import com.app.connexe.RaceAnimaux
import com.app.connexe.EspeceAnimaux

class RaceAnimauxController {

    static defaultAction = 'list'
    
    static layout = 'main'

    def create(){
        [list_object_connexe: EspeceAnimaux.list(sort:'lastUpdated', order:'desc')]
    }
    
    def edit(){
      [edit_object: RaceAnimaux.get(params.id), 
       list_object_connexe: EspeceAnimaux.list(sort:'lastUpdated', order:'desc')]
    }
    
    
    def delete(){
      RaceAnimaux.get(params.id).delete(flush: true)
      redirect(action: 'list')  
    }
    
    def list(){
      [list_object: RaceAnimaux.list(sort:'lastUpdated', order:'desc')]
    }
    
    
    def save() {
      //create quartier
      def new_object = new RaceAnimaux(libelle: params.libelle, espece: EspeceAnimaux.get(params.espece)).save()
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
      def edit_object = RaceAnimaux.get(params.id)
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
