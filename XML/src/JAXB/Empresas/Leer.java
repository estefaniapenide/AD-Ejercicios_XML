/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAXB.Empresas;

/**
 *
 * @author mrnov
 */
import JAXB.ejemplo.*;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/*
La misma operación se puede realizar al contrario , 
leer un fichero XML y rellenar un objeto Java.
 */
public class Leer {

    public static void main(String[] args) {

        try {
            JAXBContext context = JAXBContext.newInstance(Empresa.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Empresa empresa = (Empresa) unmarshaller.unmarshal(
                    //new File("src/Libro.xml") );
                    new File("Empresas.xml"));

            System.out.println("Empresa:");
            System.out.println("\t" + empresa.getCif());
            System.out.println("\t" + empresa.getNombre());
            System.out.println("\tEmpleados:");
            for (Empleado empleado : empresa.getListaEmpleados()) {
                System.out.print("\t\t" + empleado.getDni());
                System.out.print(" " + empleado.getNombre());
                System.out.print(" " + empleado.getCargo()+"\n");
            }

        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
