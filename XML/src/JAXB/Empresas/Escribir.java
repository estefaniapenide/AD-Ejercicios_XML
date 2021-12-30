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
/*Es momento de generar el fichero XML .*/
import JAXB.ejemplo.*;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public class Escribir {

    public static void main(String[] args) {

       escribir(datosEmpresa());
       
    }

    public static Empresa datosEmpresa() {

        Scanner input = new Scanner(System.in);

        Empresa empresa = null;

        System.out.println("Escribe el cif de la empresa:");
        String cif = input.nextLine();

        System.out.println("Escribe el nombre de la empresa:");
        String nombre = input.nextLine();

        empresa = new Empresa(cif, nombre);

        byte op = 0;
        do {
            System.out.println("EMPLEADOS");
            System.out.println("1.-Empleado nuevo.");
            System.out.println("0.-No añadir más empleados.");
            op = input.nextByte();
            String aa=input.nextLine();

            switch (op) {
                case 1:
                    System.out.println("EMPLEADO NUEVO");
                    System.out.println("DNI:");
                    String dni = input.nextLine();
                    System.out.println("Nombre:");
                    String nombreEmpleado = input.nextLine();
                    System.out.println("Cargo:");
                    String cargo = input.nextLine();

                    Empleado empleado = new Empleado(dni, nombreEmpleado, cargo);
                    empresa.getListaEmpleados().add(empleado);
                    break;
                case 0:
                    System.out.println("No se añadirán más personas");
                    break;
                default:
                    System.out.println("No has introducido ninguna de las opciones.");
                    break;
            }

        } while (op != 0);

        return empresa;

    }

    public static void escribir(Empresa empresa) {

        try {

            // Creamos el contexto indicando la clase raíz
            JAXBContext contexto = JAXBContext.newInstance(empresa.getClass());

            //Creamos el Marshaller, convierte el java bean en una cadena XML
            Marshaller marshaller = contexto.createMarshaller();

            //Formateamos el xml para que quede bien
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Lo visualizamos con system out
            marshaller.marshal(empresa, System.out);

            // Escribimos en el archivo
            marshaller.marshal(empresa, new File("Empresas.xml"));

        } catch (PropertyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
