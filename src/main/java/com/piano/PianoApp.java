package com.piano;

import com.piano.controller.PianoController;
import com.piano.service.AudioService;
import com.piano.view.PianoView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PianoApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AudioService audioService = new AudioService();
        audioService.loadSounds();

        PianoView pianoView = new PianoView();

        PianoController pianoController = new PianoController(pianoView,audioService);

        Scene scene = new Scene(pianoView.getRoot(),520,320);

        pianoController.setupKeyboardHandlers(scene);

        stage.setTitle("Java Piano - PR");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
