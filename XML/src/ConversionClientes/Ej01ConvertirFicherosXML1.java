/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConversionClientes;

/**
 *
 * @author mrnov
 */
import Conversion.*;
import org.w3c.dom.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Ej01ConvertirFicherosXML1 {
    
    public static void main(String[] args) {
    
        String fXML = "clientes.xml";
        
        String fXSLHTML = "clientes_HTML.xsl";
        String fXSLCSV = "clientes_CSV.xsl";
        
        File fHTML = new File("clientes_new.html");
        File fCSV = new File("clientes_new.csv");
        
        FileOutputStream foi = null;
        // fuentes XSL "librosPlantilla.xsl";
        Source estilos = null;
        // fuente XML "Libros.xml";
        Source datos = null;
        //resultado de la transformacion
        Result resultado = null;
        // hacer la transformacion
        Transformer transformer = null;
        try {
            //crea el fichero HTML "mipagina.html"
            foi = new FileOutputStream(fHTML);
            // fuentes XSL "librosPlantilla.xsl";
            estilos = new StreamSource(fXSLHTML);
            // fuente XML "Libros.xml";
            datos = new StreamSource(fXML);
            //resultado de la transformacion
            resultado = new StreamResult(foi);
            //Transformamos el resultado
            transformer =
            TransformerFactory.newInstance().newTransformer(estilos);
            //obtiene el HTML
            transformer.transform(datos, resultado);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            foi.close();
        } catch (IOException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
        try {
            //crea el fichero HTML "mipagina.html"
            foi = new FileOutputStream(fCSV);
            // fuentes XSL "librosPlantilla.xsl";
            estilos = new StreamSource(fXSLCSV);
            // fuente XML "Libros.xml";
            datos = new StreamSource(fXML);
            //resultado de la transformacion
            resultado = new StreamResult(foi);
            //Transformamos el resultado
            transformer =
            TransformerFactory.newInstance().newTransformer(estilos);
            //obtiene el HTML
            transformer.transform(datos, resultado);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            foi.close();
        } catch (IOException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}