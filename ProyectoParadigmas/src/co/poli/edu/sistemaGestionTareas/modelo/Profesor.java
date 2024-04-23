package co.poli.edu.sistemaGestionTareas.modelo;

import java.io.Serializable;
import java.util.*;

public class Profesor extends   Usuario implements Serializable {

    private String materias;

    public Profesor(int idUsuario, String nombreUsuario, String email, String contraseña, String materias) {
        super(idUsuario, nombreUsuario, email, contraseña); // No se pasan listas de usuarios y tareas
        this.materias = materias;
    }

    public String getMaterias() {
        return materias;
    }

    public void setMaterias(String materias) {
        this.materias = materias;
    }

    public void agregarMateria(String materia) {
        // TODO implementar aquí
    }

    public void eliminarMateria(String materia) {
        // TODO implementar aquí
    }

    @Override
    public String toString() {
        return "Profesor [materias=" + materias + ", idUsuario=" + getIdUsuario() + ", nombreUsuario=" + getNombreUsuario() +
                ", email=" + getEmail() + ", contraseña=" + getContraseña() + "]";
    }
}
