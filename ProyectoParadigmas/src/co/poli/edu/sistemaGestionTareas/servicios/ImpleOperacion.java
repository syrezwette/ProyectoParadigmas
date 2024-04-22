package co.poli.edu.sistemaGestionTareas.servicios;

import java.util.Arrays;

import co.poli.edu.sistemaGestionTareas.modelo.GestionTareas;
import co.poli.edu.sistemaGestionTareas.modelo.Usuario;

public class ImpleOperacion implements Operacion {

    private Usuario[] arreglo;
    private int numUsuarios;

    public ImpleOperacion(int capacidadInicial) {
        arreglo = new Usuario[capacidadInicial];
        numUsuarios = 0;
    }

    public ImpleOperacion() {
        this.arreglo = new Usuario[100];
        this.numUsuarios = 0;
    }

    @Override
    public String create(GestionTareas goku) {
        if (numUsuarios >= arreglo.length) {
            Usuario[] nuevoArreglo = Arrays.copyOf(arreglo, arreglo.length * 2);
            arreglo = nuevoArreglo;
        }

        arreglo[numUsuarios] = (Usuario) goku;
        numUsuarios++;
        return "Usuario creado";
    }

    @Override
    public GestionTareas read(String idUsuario) {
        for (int i = 0; i < numUsuarios; i++) {
            if (arreglo[i].getIdUsuario() == Integer.parseInt(idUsuario)) {
                return arreglo[i];
            }
        }
        return null;
    }

    public String update(int idUsuario, Usuario nuevoUsuario) {
        for (int i = 0; i < numUsuarios; i++) {
            if (arreglo[i] != null && arreglo[i].getIdUsuario() == idUsuario) {
                arreglo[i] = nuevoUsuario;
                return "Usuario actualizado";
            }
        }
        return "El usuario no existe.";
    }


    @Override
    public GestionTareas delete(String nombreUsuario) {
        for (int i = 0; i < numUsuarios; i++) {
            if (arreglo[i].getNombreUsuario().equals(nombreUsuario)) {
                Usuario usuarioEliminado = arreglo[i];
                for (int j = i; j < numUsuarios - 1; j++) {
                    arreglo[j] = arreglo[j + 1];
                }
                arreglo[numUsuarios - 1] = null;
                numUsuarios--;
                return usuarioEliminado;
            }
        }
        return null;
    }
}
