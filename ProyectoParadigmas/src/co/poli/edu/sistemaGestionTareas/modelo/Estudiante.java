package co.poli.edu.sistemaGestionTareas.modelo;

import java.util.*;

public class Estudiante extends Usuario {

    private String materiasTomadas;

    public Estudiante(int idUsuario, String nombreUsuario, String email, String contraseña, String materiasTomadas) {
        super(idUsuario, nombreUsuario, email, contraseña); // No se pasan listas de usuarios y tareas
        this.materiasTomadas = materiasTomadas;
    }

    public String getMateriasTomadas() {
        return materiasTomadas;
    }

    public void setMateriasTomadas(String materiasTomadas) {
        this.materiasTomadas = materiasTomadas;
    }

    public void agregarMateriaTomada(String materia) {
        // TODO implementar aquí
    }

    public void eliminarMateriaTomada(String materia) {
        // TODO implementar aquí
    }

    @Override
    public String toString() {
        return "Estudiante [materiasTomadas=" + materiasTomadas + ", idUsuario=" + getIdUsuario() + ", nombreUsuario=" + getNombreUsuario() +
                ", email=" + getEmail() + ", contraseña=" + getContraseña() + "]";
    }
}
