package co.edu.poli.sistemaGestionTareas.servicios;

import co.edu.poli.sistemaGestionTareas.modelo.Usuario;

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