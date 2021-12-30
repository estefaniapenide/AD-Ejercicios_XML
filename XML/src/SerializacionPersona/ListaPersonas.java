/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerializacionPersona;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a20estefaniapc
 */
public class ListaPersonas {
    
    private List <Person> lista = new ArrayList<Person> ();
	
    public ListaPersonas() {
	super();
    }

    public void add(Person persona) {
    	lista.add(persona);
    }

    public List<Person> getListaPersona() {
    	return lista;
    }
    
}
