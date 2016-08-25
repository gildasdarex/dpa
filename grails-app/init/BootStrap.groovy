
import grails.converters.JSON

class BootStrap {
    
    def grailsApplication
    
    def init = { servletContext ->
        initDirectory()
        initJsonMarshalle()
        
    }
    
    def destroy = {
    }
    
    
    def initDirectory(){
        def file_separator = System.getProperty("file.separator")
        def folders = [
            System.getProperty("user.home")+file_separator+"logi_dpa"+file_separator+"annuaire",
            System.getProperty("user.home")+file_separator+"logi_dpa"+file_separator+"data",
            System.getProperty("user.home")+file_separator+"logi_dpa"+file_separator+"rapports"
        ]
        folders.each {
	       def folder = new File( it )
           if( !folder.exists() ) folder.mkdirs()
        }
    }
    
    
    
    def initJsonMarshalle(){
        
        def domainClasses = grailsApplication.domainClasses.collect { it.clazz}
        
        domainClasses.each
        {
            JSON.registerObjectMarshaller( it ) { object ->
                def map = [:]
               
                def str_class = object
                
                def domainClassProperties = grailsApplication.domainClasses.find 
                { 
                    it.getFullName() == str_class.getClass().getCanonicalName()
                }.persistentProperties
                
                
                domainClassProperties.each {
                    
                    if(["lastUpdated", "dateCreated"].contains(it.name) == false)
                    {
                       if(it.association == false) 
                        {
                           if(object.hasProperty(it.name))  map[it.name] = object."${it.name}"
                        }
                        else map[it.name] = object."${it.name}".libelle 
                    } 
                    
                } 
                return map
            }
            
        }
        
    }
}
