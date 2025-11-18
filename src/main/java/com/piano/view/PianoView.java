package com.piano.view;

import com.piano.model.Note;
import com.piano.model.PianoKey;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;

public class PianoView {
    private final Pane root;
    private final Map<Note, PianoKey> keys;

    public PianoView(){
        this.root = new Pane();
        root.setStyle("-fx-background-color: #2c3e50;");
        this.keys = new HashMap<>();
        createPiano();
    }

    public Pane getRoot() {
        return root;
    }

    public PianoKey getKey(Note note) {
        return this.keys.get(note);
    }

    private void createPiano(){
        int whiteKeyWidth = 60;
        int whiteKeyHeight = 300;
        int blackKeyWidth = 40;
        int blackKeyHeight = 180;

        int x = 20;
        for(Note note : Note.values()){
            if(!note.isBlack()){
                PianoKey whitePianoKey = new PianoKey(note,x,whiteKeyWidth,whiteKeyHeight);
                this.keys.put(note,whitePianoKey);
                this.root.getChildren().add(whitePianoKey.getPane());
                x += whiteKeyWidth;
            }
        }
        x = 20;
        Note[] notes = Note.values();
        for (int i = 0; i< notes.length - 1; i++){
            if(!notes[i].isBlack()){
                if(notes[i+1].isBlack()) {
                    PianoKey blackPianoKey = new PianoKey(notes[i + 1], x + whiteKeyWidth - blackKeyWidth / 2, blackKeyWidth, blackKeyHeight);
                    this.keys.put((notes[i + 1]), blackPianoKey);
                    this.root.getChildren().add(blackPianoKey.getPane());
                }
                x += whiteKeyWidth;
            }
        }


    }
}
