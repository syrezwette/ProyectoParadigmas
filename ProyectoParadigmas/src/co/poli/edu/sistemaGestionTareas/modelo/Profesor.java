package co.poli.edu.sistemaGestionTareas.modelo;

import java.util.*;

/**
 * 
 */
public class Profesor extends Usuario {

    @Override
	public String toString() {
		return "Profesor [materias=" + materias + ", getMaterias()=" + getMaterias() + ", getIdUsuario()="
				+ getIdUsuario() + ", getNombreUsuario()=" + getNombreUsuario() + ", getEmail()=" + getEmail()
				+ ", getContraseña()=" + getContraseña() + ", getUsuarios()=" + getUsuarios() + ", getTareas()="
				+ getTareas() + "]";
	}

	public String getMaterias() {
		return materias;
	}

	public void setMaterias(String materias) {
		this.materias = materias;
	}

	public Profesor(List<Usuario> usuarios, List<Tarea> tareas, int idUsuario, String nombreUsuario, String email,
			String contraseña, String materias) {
		super(usuarios, tareas, idUsuario, nombreUsuario, email, contraseña);
		this.materias = materias;
	}

	private String materias;

    /**
     * @param materia
     */
    public void agregarMateria(String materia) {
        // TODO implement here
    }

    /**
     * @param materia
     */
    public void eliminarMateria(String materia) {
        // TODO implement here
    }

}