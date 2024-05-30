package co.edu.poli.sistemaGestionTareas.controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import co.edu.poli.sistemaGestionTareas.servicios.ImpleOperacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;

public class Formulario implements Initializable {

	@FXML
	private Button create, actualizar, leer, eliminar, serializar, deserializar, search;

	@FXML
	private RadioButton baja, media, alta;

	@FXML
	private DatePicker fecha;

	@FXML
	private TextField id, nombre, txtFieldSearch;

	@FXML
	private ComboBox<String> materias;

	@FXML
	private TextArea detallesTarea, textAreaSerializacion;

	@FXML
	private ToggleGroup prioridadGroup;

	@FXML
	private List<String[]> datosGuardados = new ArrayList<>();

	@FXML
	void crearusuario(ActionEvent event) {
		// Obtener valores de los campos
		String idUsuario = id.getText();
		String nombreUsuario = nombre.getText();
		String materiaTarea = materias.getValue();
		String detallesDeTarea = detallesTarea.getText();
		LocalDate fechaDeTarea = fecha.getValue();
		String prioridadTarea = "";

		if (alta.isSelected()) {
			prioridadTarea = "Alta";
		} else if (media.isSelected()) {
			prioridadTarea = "Media";
		} else if (baja.isSelected()) {
			prioridadTarea = "Baja";
		}

		// Validar campos
		if (nombreUsuario.isEmpty() || materiaTarea == null || detallesDeTarea.isEmpty() || prioridadTarea.isEmpty()) {
			mostrarEnTextArea("Por favor complete todos los campos.\n");
			return;
		}

		// Guardar los datos en un arreglo y agregarlo a la lista
		String[] datos = { String.valueOf(id), idUsuario, nombreUsuario, materiaTarea, detallesDeTarea,
				prioridadTarea };
		datosGuardados.add(datos);

		// Mostrar los datos en el TextArea
		mostrarEnTextArea("↓↓↓↓↓↓ DETALLES USUARIO CREADO ↓↓↓↓↓↓\n");
		mostrarEnTextArea("ID de usuario: " + idUsuario + "\n");
		mostrarEnTextArea("Nombre de usuario: " + nombreUsuario + "\n");
		mostrarEnTextArea("Materia de la tarea: " + materiaTarea + "\n");
		mostrarEnTextArea("Detalles de la tarea: " + detallesDeTarea + "\n");
		mostrarEnTextArea("Prioridad de la tarea: " + prioridadTarea + "\n");
		mostrarEnTextArea("Fecha de la tarea: " + fechaDeTarea + "\n");

		// Limpiar campos después de la creación
		limpiarCampos();

		// Mostrar ventana emergente
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Creación Exitosa");
		alerta.setHeaderText(null);
		alerta.setContentText("El usuario ha sido creado correctamente.");
		alerta.showAndWait();
	}

	@FXML
	void leerusuario(ActionEvent event) {
		// Mostrar los datos guardados en el TextArea
		mostrarEnTextArea("=======================\n");
		mostrarEnTextArea("====== BASE DE DATOS ======\n");
		mostrarEnTextArea("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓\n");
		for (String[] datos : datosGuardados) {
			// Obtener el texto de los campos
			String idUsuario = datos[1];
			String nombreUsuario = datos[2];
			String materiaTarea = datos[3];
			String detallesDeTarea = datos[4];
			String prioridadTarea = datos[5];
			String fechaTarea = ""; // Variable para almacenar la fecha de la tarea
			// Verificar si hay al menos 6 elementos en el array antes de acceder al índice
			// 5 (fecha)
			if (datos.length > 6) {
				fechaTarea = datos[6]; // Acceder al elemento solo si existe
			}
			// Mostrar los datos en el TextArea
			mostrarEnTextArea("ID de usuario: " + idUsuario + "\n");
			mostrarEnTextArea("Nombre de usuario: " + nombreUsuario + "\n");
			mostrarEnTextArea("Materia de la tarea: " + materiaTarea + "\n");
			mostrarEnTextArea("Detalles de la tarea: " + detallesDeTarea + "\n");
			mostrarEnTextArea("Prioridad de la tarea: " + prioridadTarea + "\n");
			mostrarEnTextArea("Fecha de la tarea: " + fechaTarea + "\n");
		}
	}

	@FXML
	void actualizarusuario(ActionEvent event) {
		String idBuscado = id.getText(); // Obtener el ID del campo de texto id

		// Verificar si el texto ingresado es un número
		if (idBuscado.matches("\\d+")) {
			int id = Integer.parseInt(idBuscado);

			// Verificar si el ID está dentro del rango válido
			if (id >= 1 && id <= datosGuardados.size()) {
				// Obtener los nuevos datos ingresados por el usuario
				String nombreUsuario = nombre.getText();
				LocalDate fechaSeleccionada = fecha.getValue();
				String materiaSeleccionada = materias.getValue();
				String detallesDeTarea = detallesTarea.getText();
				String prioridadTarea = "";

				if (alta.isSelected()) {
					prioridadTarea = "Alta";
				} else if (media.isSelected()) {
					prioridadTarea = "Media";
				} else if (baja.isSelected()) {
					prioridadTarea = "Baja";
				}

				// Validar campos
				if (nombreUsuario.isEmpty() || materiaSeleccionada == null || detallesDeTarea.isEmpty()
						|| prioridadTarea.isEmpty() || fechaSeleccionada == null) {
					mostrarEnTextArea("Por favor complete todos los campos.\n");
					return;
				}

				// Actualizar los datos del registro con el ID correspondiente en la lista
				// datosGuardados
				String[] datosActualizados = { String.valueOf(id), nombreUsuario, materiaSeleccionada, detallesDeTarea,
						prioridadTarea, fechaSeleccionada.toString() };
				datosGuardados.set(id - 1, datosActualizados);

				// Mostrar mensaje de actualización exitosa
				Alert alerta = new Alert(Alert.AlertType.INFORMATION);
				alerta.setTitle("Actualización Exitosa");
				alerta.setHeaderText(null);
				alerta.setContentText("El registro ha sido actualizado correctamente.");
				alerta.showAndWait();

				// Limpiar campos después de la actualización
				limpiarCampos();

				// Actualizar TextArea con la información actualizada
				mostrarDatosActualizados();
			} else {
				// Mostrar mensaje de ID no válido
				Alert alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setTitle("Error");
				alerta.setHeaderText(null);
				alerta.setContentText("ID no válido. Por favor, ingrese un ID válido.");
				alerta.showAndWait();
			}
		} else {
			// Mostrar mensaje de formato de ID incorrecto
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setTitle("Error");
			alerta.setHeaderText(null);
			alerta.setContentText("Formato de ID incorrecto. Por favor, intente de nuevo.");
			alerta.showAndWait();
		}
	}
	@FXML
	void eliminarusuario(ActionEvent event) {
		// Crear una ventana emergente para ingresar el ID o nombre del usuario a
		// eliminar
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Eliminar Usuario");
		dialog.setHeaderText("Eliminar Usuario");
		dialog.setContentText("Por favor, ingrese el ID o nombre del usuario:");

		// Mostrar la ventana y esperar a que el usuario ingrese el dato
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			String input = result.get();
			boolean usuarioEliminado = eliminarUsuarioPorIdONombre(input);

			if (usuarioEliminado) {
				mostrarAlerta("Usuario Eliminado", "El usuario ha sido eliminado correctamente.");
			} else {
				mostrarAlerta("Usuario no encontrado",
						"No se encontró ningún usuario con el ID o nombre proporcionado.");
			}
		}
	}

	private boolean eliminarUsuarioPorIdONombre(String input) {
		for (Iterator<String[]> iterator = datosGuardados.iterator(); iterator.hasNext();) {
			String[] datos = iterator.next();
			if (datos[1].equals(input) || datos[2].equals(input)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	private void mostrarDatosActualizados() {
		textAreaSerializacion.clear();
		for (String[] datos : datosGuardados) {
			textAreaSerializacion.appendText("ID de usuario: " + datos[0] + "\n");
			textAreaSerializacion.appendText("Nombre de usuario: " + datos[1] + "\n");
			textAreaSerializacion.appendText("Materia de la tarea: " + datos[2] + "\n");
			textAreaSerializacion.appendText("Detalles de la tarea: " + datos[3] + "\n");
			textAreaSerializacion.appendText("Prioridad de la tarea: " + datos[4] + "\n");
			textAreaSerializacion.appendText("Fecha de la tarea: " + datos[5] + "\n");
			textAreaSerializacion.appendText("--------------------------------------\n");
		}
	}

	@FXML
	void serializarusuario(ActionEvent event) {
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("UsuariosSerializados.txt"))) {
			// Escribir los datos guardados en el archivo
			salida.writeObject(datosGuardados);

			// Mostrar mensaje de éxito en el TextArea
			textAreaSerializacion.setText("Datos serializados correctamente.");
		} catch (IOException e) {
			textAreaSerializacion.setText("Error al serializar los datos: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@FXML
	void deserializarusuario(ActionEvent event) {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("UsuariosSerializados.txt"))) {
			// Leer los datos serializados desde el archivo
			datosGuardados = (List<String[]>) entrada.readObject();

			// Limpiar y actualizar el TextArea
			textAreaSerializacion.clear();
			textAreaSerializacion.setText("Datos deserializados correctamente.\n");
			mostrarDatosDeserializados();

		} catch (IOException e) {
			textAreaSerializacion.setText("Error al deserializar los datos: " + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			textAreaSerializacion.setText("Error: Clase no encontrada. " + e.getMessage());
			e.printStackTrace();
		}
	}

	void mostrarDatosDeserializados() {
		mostrarEnTextArea("===================================\n");
		mostrarEnTextArea("========== DATOS DESERIALIZADOS ==========\n");
		mostrarEnTextArea("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓\n");
		for (String[] datos : datosGuardados) {
			StringBuilder entryData = new StringBuilder();
			entryData.append("ID de usuario: ").append(datos[1]).append("\n");
			entryData.append("Nombre de usuario: ").append(datos[2]).append("\n");
			entryData.append("Materia de la tarea: ").append(datos[3]).append("\n");
			entryData.append("Detalles de la tarea: ").append(datos[4]).append("\n");
			entryData.append("Prioridad de la tarea: ").append(datos[5]).append("\n");
			entryData.append("--------------------------------------\n");
			mostrarEnTextArea(entryData.toString());
		}
	}

	@FXML
	void buscarPorID(ActionEvent event) {
		String busqueda = txtFieldSearch.getText();
		String[] informacionUsuario = buscarInformacion(busqueda);
		if (informacionUsuario != null) {
			mostrarVentanaEmergente(informacionUsuario);
		} else {
			mostrarAlerta("Usuario no encontrado", "No se encontró ningún usuario con el ID o nombre proporcionado.");
		}
	}

	private String[] buscarInformacion(String busqueda) {
		for (String[] datos : datosGuardados) {
			if (datos[1].equals(busqueda) || datos[2].equalsIgnoreCase(busqueda)) {
				return datos;
			}
		}
		return null;
	}

	private void mostrarVentanaEmergente(String[] informacionUsuario) {
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("ID de usuario: ").append(informacionUsuario[1]).append("\n");
		mensaje.append("Nombre de usuario: ").append(informacionUsuario[2]).append("\n");
		mensaje.append("Materia de la tarea: ").append(informacionUsuario[3]).append("\n");
		mensaje.append("Detalles de la tarea: ").append(informacionUsuario[4]).append("\n");
		mensaje.append("Prioridad de la tarea: ").append(informacionUsuario[5]).append("\n");

		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("Información del Usuario");
		alerta.setHeaderText(null);
		alerta.setContentText(mensaje.toString());
		alerta.showAndWait();

	}

	private void mostrarAlerta(String titulo, String mensaje) {
		Alert alerta = new Alert(Alert.AlertType.WARNING);
		alerta.setTitle(titulo);
		alerta.setHeaderText(null);
		alerta.setContentText(mensaje);
		alerta.showAndWait();
	}

	@FXML
	void limpiarCampos() {
		id.clear();
		nombre.clear();
		detallesTarea.clear();
		materias.setValue(null);
		baja.setSelected(false);
		media.setSelected(false);
		alta.setSelected(false);
		fecha.setValue(null);
	}

	void mostrarEnTextArea(String texto) {
		textAreaSerializacion.appendText(texto);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// Restringir txtField1 a números
		id.setTextFormatter(new TextFormatter<>(this::soloNumeros));

		// Restringir txtField2 a letras
		nombre.setTextFormatter(new TextFormatter<>(this::soloLetras));

		ObservableList<String> items = FXCollections.observableArrayList("PROGRAMACIÓN", "CÁLCULO", "FÍSICA",
				"PROBABILIDAD");
		materias.setItems(items);

		// Inicializar el ToggleGroup y asociar los RadioButton
		prioridadGroup = new ToggleGroup();
		alta.setToggleGroup(prioridadGroup);
		media.setToggleGroup(prioridadGroup);
		baja.setToggleGroup(prioridadGroup);

	}

	// Método para permitir solo números
	private Change soloNumeros(Change change) {
		String input = change.getText();
		if (input.matches("[0-9]*")) {
			return change;
		}
		return null;
	}

	// Método para permitir solo letras
	private Change soloLetras(Change change) {
		String input = change.getText();
		if (Pattern.matches("[a-zA-Z]*", input)) {
			return change;
		}
		return null;
	}

	public List<String[]> getDatosGuardados() {
		return datosGuardados;
	}

	public void setDatosGuardados(List<String[]> datosGuardados) {
		this.datosGuardados = datosGuardados;
	}

}
