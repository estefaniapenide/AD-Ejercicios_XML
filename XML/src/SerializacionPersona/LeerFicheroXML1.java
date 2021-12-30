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
* Lectura de un fichero XML a objetos
*/

import Serializacion.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.thoughtworks.xstream.XStream;

public class LeerFicheroXML1 {
    public static void main(final String[] args) throws FileNotFoundException {
        
        //crear una instancia de la clase XStream
        XStream xstream = new XStream();
        
        //Para que no de Errores de acceso de Tipos
        xstream.allowTypes(new Class[] {Person.class,ListaPersonas.class});
        
        //cambiar de nombre a las etiquetas XML
        xstream.alias("ListadoPersonas", ListaPersonas.class);
        xstream.alias("DatosPersona", Person.class);
        
        //quitar etiqueta lista (atributo de la clase ListaAlumnos
        xstream.addImplicitCollection(ListaPersonas.class, "lista");
        ListaPersonas listadoTodas = (ListaPersonas) xstream.fromXML(new FileInputStream("Persons_new.xml"));
        System.out.println("Número de personas: "+listadoTodas.getListaPersona().size());
        
        List<Person> listaAlumnos = new ArrayList<Person>();
        listaAlumnos = (List<Person>) listadoTodas.getListaPersona();
        
        Iterator iterator = listaAlumnos.listIterator(); //recorrer los elementos
        while(iterator.hasNext()){
            Person per = (Person) iterator.next(); //obtenemos el elemento
            System.out.println("Nombre: "+per.getFirstname() +"\tApellido: "+per.getLastname() +"\tTeléfono: "+per.getPhone().toString()+"\tFax: "+per.getFax().toString());
        }// fin del while
        System.out.println("\n\nFin del listado... ");
    }// fin main
}//fin clase
