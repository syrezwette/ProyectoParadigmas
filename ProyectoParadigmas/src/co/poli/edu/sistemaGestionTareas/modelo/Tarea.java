package co.poli.edu.sistemaGestionTareas.modelo;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Tarea implements Serializable {

    private int idTarea;

    /**
     * 
     */
    private String titulo;

    /**
     * Enum para representar el estado de la tarea
     */
    public enum Estado {
        Pendiente, EnProgreso, Completada, Cancelada
    }

    /**
     * 
     */
    private Estado estado;

    /**
     * 
     */
    private String fechaCreacion;

    /**
     * 
     */
    private String fechaFin;

    /**
     * 
     */
    private Profesor materiaTarea;

    /**
     * 
     */
    public void marcarComoCompletada() {
        // TODO implementar aquí
    }

    /**
     * @param usuario
     */
    public void asignarTarea(Usuario usuario) {
        // TODO implementar aquí
    }

}
