package co.edu.poli.sistemaGestionTareas.vista;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {			
			// Cargar el archivo FXML
            Parent root = FXMLLoader.load(getClass().getResource("/co/edu/poli/sistemaGestionTareas/vista/Test.fxml"));
			
            // Configurar la escena
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Configurar la escena en la etapa principal
			primaryStage.setScene(scene);
            primaryStage.setTitle("Sistema Gestion de Tareas");
			
			// Mostrar la etapa principal
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
