module LyricsPrimer.main {
    // Require JavaFX
    requires javafx.controls;
    requires javafx.fxml;

    opens fr.enssat.dysp.lyrics.ui;

    exports fr.enssat.dysp.lyrics.ui.components;
}