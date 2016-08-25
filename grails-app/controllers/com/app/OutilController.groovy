package com.app

import grails.converters.JSON
import groovy.json.JsonBuilder

class OutilController {
    
    def upload() {
        try {
            def file_separator = System.getProperty("file.separator")
            def location = System.getProperty("user.home")+file_separator+"logi_dpa"+file_separator+"rapports"
            def file = request.getFile('upload_file')
            def full_path = "${location}/${file.originalFilename}"
            file.transferTo(new File(full_path))
            flash.success =  "Fichier enregistre sous :${full_path}"
            redirect(controller:'outil', action: 'upload')
        } catch (any) {
            flash.success =  "Le fichier n'a pas pu etre enregistre"
            redirect(controller:'outil', action: 'upload')
        }
        
    }
    
    
}
