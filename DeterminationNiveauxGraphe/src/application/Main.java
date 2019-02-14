package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Graphe.fxml"));
			Scene scene = new Scene(root,1050,900);

			// Titre de la fenêtre
			primaryStage.setTitle("Niveaux d'un graphe");

			// Logo 3iL
			primaryStage.getIcons().setAll(new Image(getClass().getResource("3ilogo.png").toExternalForm()));

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}