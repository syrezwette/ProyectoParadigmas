package co.edu.poli.sistemaGestionTareas.servicios;

import co.edu.poli.sistemaGestionTareas.modelo.GestionTareas;
import co.edu.poli.sistemaGestionTareas.modelo.Usuario;

/**
 * 
 */
public interface Operacion {

    /**
     * @param gtu 
     * @return
     */
    public String create(GestionTareas gtu);

    /**
     * @param tipo 
     * @return
     */
    public GestionTareas read(String tipo);

    /**
     * @param tipo 
     * @param gtu 
     * @return
     */
    public String update(int idUsuario, Usuario nuevoUsuario);

    /**
     * @param tipo 
     * @return
     */
    public GestionTareas delete(String tipo);

}