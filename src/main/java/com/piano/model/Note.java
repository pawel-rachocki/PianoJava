package com.piano.model;

import javafx.scene.input.KeyCode;
public enum Note {
    C4("C4", KeyCode.A, false),
    CS4("C#4", KeyCode.W, true),
    D4("D4", KeyCode.S, false),
    DS4("D#4", KeyCode.E, true),
    E4("E4", KeyCode.D, false),
    F4("F4", KeyCode.F, false),
    FS4("F#4", KeyCode.T, true),
    G4("G4", KeyCode.G, false),
    GS4("G#4", KeyCode.Y, true),
    A4("A4", KeyCode.H, false),
    AS4("A#4", KeyCode.U, true),
    B4("B4", KeyCode.J, false),
    C5("C5", KeyCode.K, false);
    private final String soundFile;
    private final KeyCode keyCode;

    private final boolean isBlack;

    Note(String soundFile, KeyCode keyCode, boolean isBlack){
        this.soundFile = soundFile;
        this.keyCode = keyCode;
        this.isBlack = isBlack;
    }

    public String getSoundFile(){
        return this.soundFile;
    }

    public KeyCode getKeyCode(){
        return this.keyCode;
    }

    public boolean isBlack(){
        return this.isBlack;
    }

    public static Note fromKeyCode(KeyCode code){
        for(Note note : Note.values()){
            if (note.keyCode == code){
                return note;
            }
        }
        return null;
    }
}

