package co.poli.edu.sistemaGestionTareas.servicios;

import java.util.*;

import co.poli.edu.sistemaGestionTareas.modelo.Usuario;

/**
 * 
 */
public interface OperacionArchivo {

    /**
     * @param Usuario 
     * @param path 
     * @param name
     */
    public void Serializar(void Usuario, String path, String name);

    /**
     * @param path 
     * @param name 
     * @return
     */
    public Usuario Deserializar(String path, String name);

}