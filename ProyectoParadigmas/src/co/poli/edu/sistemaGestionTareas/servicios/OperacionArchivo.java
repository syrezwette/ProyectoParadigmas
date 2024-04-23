package co.poli.edu.sistemaGestionTareas.servicios;

import java.io.FileInputStream;
import java.io.	FileOutputStream;
import java.io.	ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.*;

import co.poli.edu.sistemaGestionTareas.modelo.Usuario;

/**
 * 
 */
public interface OperacionArchivo {

	

	    
		/**
	     * @param Transaccion  
	     * @param path 
	     * @param name
	     */
	    public void serializar(Usuario[] Usuario , String path, String name) ;
	        // TODO implement OperacionArchivo.serializar() h

	    /**
	     * @param path 
	     * @param name 
	     * @return
	     */
	    public  Usuario [ ] Deserializar(String path, String name);
}