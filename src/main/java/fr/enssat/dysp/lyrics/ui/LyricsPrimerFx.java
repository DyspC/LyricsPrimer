package fr.enssat.dysp.lyrics.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class LyricsPrimerFx extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final URL fxmlTemplate = getClass().getResource("/templates/main.fxml");
		final URL css = getClass().getResource("/templates/main.css");

		assert fxmlTemplate != null : "Could not load FXML application template";
		assert css != null : "Could not load application stylesheet";

		final Parent window = FXMLLoader.load(fxmlTemplate);
		final Scene scene = new Scene(window);
		scene.getStylesheets().add(css.toExternalForm());

		primaryStage.setTitle("LyricsPrimer v2.15");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
