package com.app.connexe


class ConnexeBaseController {

    static defaultAction = 'list'

    static layout = 'main'

    def exportService

    def excelService

    def create(){
      render(view: "/connexe/create")
    }



    def edit(){
      render(view: "/connexe/edit", model: [edit_object: className.get(params.id)])
    }



    def list(){
      def format = "excel"
      if(!params.max) params.max = 100
      if(params?.extension && params.extension != "html")
        {
         if (!params.extension.equals("xls")) format = params.extension
         def fields = ["libelle"]
         exportService.export(format, response ,"data",params.extension, className.list(params),fields, null, [:], [:])
        }
      else {
        render(view: "/connexe/list", model: [list_object: className.list(sort:'lastUpdated', order:'desc')])
      }
    }



    def delete(){
      className.get(params.id).delete(flush: true)
      render(view: "/connexe/list", model: [list_object: className.list(sort:'lastUpdated', order:'desc')])
    }


    def upload(){
      def file = request.getFile('upload_file')
      def list_object =  excelService.parseExcel(file.getInputStream(), className.getSimpleName())
      list_object.each{ map ->
        def new_object = className.newInstance()
        new_object.properties = map
        new_object.save(flush: true)
      }
      render(view: "/connexe/list", model: [list_object: className.list(sort:'lastUpdated', order:'desc')])
    }


    def save() {
      //create quartier
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
      render(view: "/connexe/list", model: [list_object: className.list(sort:'lastUpdated', order:'desc')])
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
      render(view: "/connexe/list", model: [list_object: className.list(sort:'lastUpdated', order:'desc')])
    }



}
