package co.edu.poli.sistemaGestionTareas.modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Estudiante extends Usuario implements Serializable{

    private String materiasTomadas;

	public Estudiante(int idUsuario, String nombreUsuario, String email, String contraseña, String materiasTomadas) {
		super(idUsuario, nombreUsuario, email, contraseña);
		this.materiasTomadas = materiasTomadas;
	}

	public String getMateriasTomadas() {
		return materiasTomadas;
	}

	public void setMateriasTomadas(String materiasTomadas) {
		this.materiasTomadas = materiasTomadas;
	}

	@Override
	public String toString() {
		return "Estudiante [materiasTomadas=" + materiasTomadas + "]";
	}

  

}