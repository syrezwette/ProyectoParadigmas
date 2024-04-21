package co.poli.edu.sistemaGestionTareas.servicios;

import java.util.*;

import co.poli.edu.sistemaGestionTareas.modelo.GestionTareas;

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
    public String update(String tipo, GestionTareas gtu);

    /**
     * @param tipo 
     * @return
     */
    public GestionTareas delete(String tipo);

}