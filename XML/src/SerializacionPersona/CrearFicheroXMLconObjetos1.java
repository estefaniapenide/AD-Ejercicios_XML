/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerializacionPersona;

/**
 *
 * @author mrnov
 */
/*
* Ejemplo que recorre el fichero Alumnos.Dat para crear una lista de
alumnos
* que después se insertarán en el fichero Alumnos.xml
*/



import DOM.Fichero;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.thoughtworks.xstream.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CrearFicheroXMLconObjetos1 {
    
    public static void main(final String[] args) throws IOException, ClassNotFoundException {
        File fichero = new File("Persons_new.dat");
        
        fichero.createNewFile();
        
        AltasObj1.altas(fichero);
        
        FileInputStream lectura = new FileInputStream(fichero); //flujo de entrada
        // conecta el flujo de bytes al flujo de datos
        ObjectInputStream datos = new ObjectInputStream(lectura);
        System.out.println("Comienza el proceso de creación del fichero XML....");
        // Creamos un objeto Lista de alumnos

        ListaPersonas listaper = new ListaPersonas();
        try{
            while(true){ // lectura del fichero
                Person persona = (Person)datos.readObject(); // leer la persona
                listaper.add(persona); //añadir un alumno a la lista
            }// fin while
        }catch(EOFException eo){}
        datos.close();
        try{
            XStream xstream = new XStream();
            //cambiar de nombre a las etiquetas XML
            xstream.alias("ListadoPersonas", ListaPersonas.class);
            xstream.alias("DatosPersona", Person.class);
            //quitar etiqueta lista (atributo de la clase ListaAlumno
            xstream.addImplicitCollection(ListaPersonas.class,
            "lista");
            //Insertar los objetos en el XML
            xstream.toXML(listaper, new
            FileOutputStream("Persons_new.xml"));
            System.out.println("Creado el fichero xml");
        }catch(Exception e){
            e.printStackTrace();
        }
    }// fin main
}// fin clase
