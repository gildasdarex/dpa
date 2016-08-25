package com.app


import grails.util.Holders

import grails.converters.JSON
import org.grails.plugins.filterpane.FilterPaneUtils


class BaseController {



    /*def create(){
        def map = [:]
        map["departements"] = dataService.get_departements()
        map["communes"] = dataService.get_communes()

        def domainClassProperties = grailsApplication.domainClasses.find {
            it.clazz.simpleName == className.simpleName
        }.persistentProperties
        def association_properties = domainClassProperties.findAll { it.association == true }
        def properties = domainClassProperties.collect { it.name }
        //println association_properties
        //println properties
        association_properties.each{map["${it.name}s"] = it.type.list()}

        //println association_properties.type.list()
        //redirect(action: 'list')
        println map
        map
    }*/

    def filter(){
      if(!params.max) params.max = 100
        render( view:'list',
            model:[ list_object: filterPaneService.filter( params, className ),
            domainClassCount: filterPaneService.count( params, className ),
            objectCount: filterPaneService.count( params, className),
            //filterParams: FilterPaneUtils.extractFilterParams(params),
            params:params ] )
    }


    def delete(){
      className.get(params.id).delete(flush: true)
      flash.success =  "Information supprime avec success"
      redirect(action: 'list')
    }

    def list(){
     def format = "excel"
     if(!params.max) params.max = 100
     if(params?.extension && params.extension != "html")
        {
         if (!params.extension.equals("xls")) format = params.extension
         exportService.export(format, response ,"data",params.extension, className.list(params),fields, null, [:], [:])
        }
      else {
        [list_object: className.list(sort:'lastUpdated', order:'desc'),
         objectCount: filterPaneService.count( params, className )
        ]
      }
    }



    def upload(){
      def file = request.getFile('upload_file')
      def list_object =  excelService.parseExcel(file.getInputStream(), className.getSimpleName())
      list_object.each{ map ->
        def new_object = className.newInstance()
        new_object.properties = map
        new_object.save(flush: true)
      }
      redirect(action: 'list')
    }


    def save() {
      def new_object = className.newInstance()
      new_object.properties = params
      new_object.save(flush: true)
      if(new_object.hasErrors()) {
        new_object.errors.allErrors.each {flash.error =  it.defaultMessage}
      }
      else {
        flash.success =  "Information enregistré avec success"
      }
      // you must return quartier to acceuil page
      redirect(action: 'list')
    }


    def update(){
      def edit_object = className.get(params.id)
      edit_object.properties = params
      edit_object.save(flush: true)
      if(edit_object.hasErrors()) {
        edit_object.errors.allErrors.each {flash.error =  it.defaultMessage}
      }
      else {
        flash.success =  "Information modifié avec success"
      }
      // you must return quartier to acceuil page
      redirect(action: 'list')
    }


    def list_croise(){
     def map = [
                data: className.list() as JSON,
                fields: fields as JSON
               ]

      render(layout: 'croise', view: '/templates/list_croise', model: map)
    }


    def graphe(){
     def map = [
                data: className.list() as JSON,
                fields: fields as JSON
               ]

      render(layout: 'graph', view: '/templates/graphe', model: map)
    }

    def findCommuneForDepartement() {
        render(template: 'citySelection',
               model:  [communes: dataService.get_communes(params.departement)]
              )
    }
}
