module ProyectoParadigmas1 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
    opens co.edu.poli.sistemaGestionTareas.vista to javafx.graphics, javafx.fxml;
    opens co.edu.poli.sistemaGestionTareas.controlador to javafx.graphics, javafx.fxml;
}
