package co.poli.edu.sistemaGestionTareas.modelo;

import java.util.*;

/**
 * 
 */
public class Estudiante extends Usuario {



    @Override
	public String toString() {
		return "Estudiante [materiasTomadas=" + materiasTomadas + ", getMateriasTomadas()=" + getMateriasTomadas()
				+ ", getIdUsuario()=" + getIdUsuario() + ", getNombreUsuario()=" + getNombreUsuario() + ", getEmail()="
				+ getEmail() + ", getContraseña()=" + getContraseña() + ", getUsuarios()=" + getUsuarios()
				+ ", getTareas()=" + getTareas() + "]";
	}

	public String getMateriasTomadas() {
		return materiasTomadas;
	}

	public void setMateriasTomadas(String materiasTomadas) {
		this.materiasTomadas = materiasTomadas;
	}

	public Estudiante(List<Usuario> usuarios, List<Tarea> tareas, int idUsuario, String nombreUsuario, String email,
			String contraseña, String materiasTomadas) {
		super(usuarios, tareas, idUsuario, nombreUsuario, email, contraseña);
		this.materiasTomadas = materiasTomadas;
	}

	/**
     * 
     */
    private String materiasTomadas;

    /**
     * @param materia
     */
    public void agregarMateriaTomada(String materia) {
        // TODO implement here
    }

    /**
     * @param materia
     */
    public void eliminarMateriaTomada(String materia) {
        // TODO implement here
    }

}