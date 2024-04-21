package co.poli.edu.sistemaGestionTareas.modelo;

import java.util.*;

/**
 * 
 */
public abstract class GestionTareas {

  
    private List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	/**
     * 
     */
    private List<Tarea> tareas;

    public GestionTareas(List<Usuario> usuarios, List<Tarea> tareas) {
		super();
		this.usuarios = usuarios;
		this.tareas = tareas;
	}

	/**
     * @param usuario
     */
    public void agregarUsuario(Usuario usuario) {
        // TODO implement here
    }

    @Override
	public String toString() {
		return "GestionTareas [usuarios=" + usuarios + ", tareas=" + tareas + ", getUsuarios()=" + getUsuarios()
				+ ", getTareas()=" + getTareas() + "]";
	}

	/**
     * @param usuario
     */
    public void eliminarUsuario(Usuario usuario) {
        // TODO implement here
    }

    /**
     * @param tarea
     */
    public void agregarTarea(Tarea tarea) {
        // TODO implement here
    }

    /**
     * @param tarea
     */
    public void eliminarTarea(Tarea tarea) {
        // TODO implement here
    }

}