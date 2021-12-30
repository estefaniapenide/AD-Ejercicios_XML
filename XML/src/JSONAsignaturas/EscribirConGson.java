/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONAsignaturas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author a20estefaniapc
 */
public class EscribirConGson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       Gson gson = new Gson();
        
        //create GSON instance with pretty-print
        Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        
        Persona persona = new Persona("María",120);
        persona.getListaAsignaturas().add(new Asignatura(1,"AADD"));
        persona.getListaAsignaturas().add(new Asignatura(2,"CD"));
        
        try{
            
//            //Generación de la cadena con formato fichero.json para ver sin pretty-printing
//            String json=gson.toJson(persona);
//            System.out.println(json);
//            
//            //Volcado de la cadena con formato .json en forma de Fichero.Texto
//            GuardarJSON(json);
            
            //Volcado directo del objeto con formatedao de linea
            //create a writer
            Writer writer = Files.newBufferedWriter(Paths.get("Persona.json"));
            
            //convert person object to JSON file
            gson2.toJson(persona,writer);
            
            //close writer
            writer.close();
        
        }catch(Exception e){
        e.printStackTrace();
        }
        
    }
    
    public static void GuardarJSON(String json){
    
    
    }
    
}
