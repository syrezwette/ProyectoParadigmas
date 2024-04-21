package co.poli.edu.sistemaGestionTareas.modelo;

import java.util.*;

/**
 * 
 */
public class Usuario extends GestionTareas {

  
    @Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", email=" + email
				+ ", contraseña=" + contraseña + ", getIdUsuario()=" + getIdUsuario() + ", getNombreUsuario()="
				+ getNombreUsuario() + ", getEmail()=" + getEmail() + ", getContraseña()=" + getContraseña()
				+ ", getUsuarios()=" + getUsuarios() + ", getTareas()=" + getTareas() + ", hashCode()=" + hashCode()
				+ "]";
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Usuario(List<Usuario> usuarios, List<Tarea> tareas, int idUsuario, String nombreUsuario, String email,
			String contraseña) {
		super(usuarios, tareas);
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contraseña = contraseña;
	}

	private int idUsuario;

    /**
     * 
     */
    private String nombreUsuario;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String contraseña;

    /**
     * 
     */
    public void iniciarSesion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void cerrarSesion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void cambiarContraseña() {
        // TODO implement here
    }

}