package co.edu.poli.sistemaGestionTareas.modelo;

import java.io.Serializable;

/**
 * 
 */
@SuppressWarnings("serial")
public class Tarea implements Serializable {

    @SuppressWarnings("unused")
	private int idTarea;

    /**
     * 
     */
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
	private Estado estado;

    /**
     * 
     */
    @SuppressWarnings("unused")
	private String fechaCreacion;

    /**
     * 
     */
    @SuppressWarnings("unused")
	private String fechaFin;

    /**
     * 
     */
    @SuppressWarnings("unused")
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
