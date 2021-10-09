package fr.enssat.dysp.lyrics.ui;

import fr.enssat.dysp.lyrics.logic.Traitement;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class FxLyricsPrimerController {

    public FxLyricsPrimerController() {
        Traitement.init();
    }

    @FXML
    TextArea inputText;
    @FXML
    TextArea outputText;

    public void doSplit() {
        final String splitText = Traitement.traiter(inputText.getText());
        outputText.setText(splitText);
    }
    public void doOptimize() {
        final String splitText = Traitement.optimize(outputText.getText());
        outputText.setText(splitText);
    }
    public void doExtractChorus() {
        final String splitText = Traitement.splitThatShit(outputText.getText());
        outputText.setText(splitText);
    }

}
