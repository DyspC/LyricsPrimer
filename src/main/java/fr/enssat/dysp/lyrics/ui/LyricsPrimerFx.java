package fr.enssat.dysp.lyrics.ui;

import fr.enssat.dysp.lyrics.logic.Traitement;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;

public class LyricsPrimerFx extends Application {

	public static void main(String[] args) {
		Traitement.init();
		launch();
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		final Label label = new Label(String.format("Hello from Java %s JavaFX %s.",
				System.getProperty("java.version"),
				System.getProperty("javafx.version")));
		final Scene scene = new Scene(new StackPane(label), 640, 480);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
