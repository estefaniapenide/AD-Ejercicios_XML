/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAXB.Empresas;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a20estefaniapc
 */

@XmlRootElement(name="empresa")

@XmlAccessorType(XmlAccessType.FIELD)

public class Empresa {
    
    
    private String cif;
    private String nombre;
    
    @XmlElementWrapper(name ="listaempleados")
    @XmlElement(name="empleado")
    private ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
    
    public Empresa(){}
    
    public Empresa(String cif, String nombre){
        this.cif=cif;
        this.nombre=nombre;
    }

    /**
     * @return the listaEmpleados
     */
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    /**
     * @param listaEmpleados the listaEmpleados to set
     */
    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    /**
     * @return the cif
     */
    public String getCif() {
        return cif;
    }

    /**
     * @param cif the cif to set
     */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
