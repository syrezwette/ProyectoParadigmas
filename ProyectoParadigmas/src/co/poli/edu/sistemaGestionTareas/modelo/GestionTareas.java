package co.poli.edu.sistemaGestionTareas.modelo;

import java.util.*;

/**
 * 
 */
public abstract class GestionTareas {

    private String usuarios;
    private String tareas;

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    public GestionTareas(String usuarios, String tareas) {
        super();
        this.usuarios = usuarios;
        this.tareas = tareas;
    }

    public void agregarUsuario(String usuario) {
        // TODO implement here
    }

    @Override
    public String toString() {
        return "GestionTareas [usuarios=" + usuarios + ", tareas=" + tareas + ", getUsuarios()=" + getUsuarios()
                + ", getTareas()=" + getTareas() + "]";
    }

    public void eliminarUsuario(String usuario) {
        // TODO implement here
    }

    public void agregarTarea(String tarea) {
        // TODO implement here
    }

    public void eliminarTarea(String tarea) {
        // TODO implement here
    }
}
