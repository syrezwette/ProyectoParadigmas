package co.poli.edu.sistemaGestionTareas.modelo;

import java.util.*;

public class Usuario extends GestionTareas {

    private int idUsuario;
    private String nombreUsuario;
    private String email;
    private String contraseña;

    public Usuario(int idUsuario, String nombreUsuario, String email, String contraseña) {
        super(null, null); // No se pasan listas de usuarios y tareas
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contraseña = contraseña;
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

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", email=" + email
                + ", contraseña=" + contraseña + "]";
    }
}
