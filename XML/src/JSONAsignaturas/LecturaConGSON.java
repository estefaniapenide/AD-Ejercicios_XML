/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONAsignaturas;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author mrnov
 */
public class LecturaConGSON {
     public static void main (String args []) throws IOException{
        
        Reader reader = Files.newBufferedReader(Paths.get("Persona.json"));
         
        //Ahora vamos a usar GSON. Creamos un objeto GSON:
        Gson gson = new Gson();
        //Para parsear un objeto con GSON:
        Persona p = gson.fromJson(reader, Persona.class);
        //Mostramos el objeto:
        System.out.println(p);
    }
}
