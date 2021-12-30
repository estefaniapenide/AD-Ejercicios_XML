/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONAsignaturas;

import java.util.ArrayList;

/**
 *
 * @author mrnov
 */
public class Persona {
    private String nombre;
    private int edad;

    
    private ArrayList<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
 
    public Persona() {
    }
 
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public int getEdad() {
        return edad;
    }

 
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
      /**
     * @return the listaAsignaturas
     */
    public ArrayList<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    /**
     * @param listaAsignaturas the listaAsignaturas to set
     */
    public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }
 
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + "\n" + listaAsignaturas + '}';
    }
}
