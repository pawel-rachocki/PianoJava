package com.piano.controller;

import com.piano.model.Note;
import com.piano.model.PianoKey;
import com.piano.service.AudioService;
import com.piano.view.PianoView;
import javafx.scene.Scene;

public class PianoController {
    private final PianoView pianoView;
    private final AudioService audioService;

    public PianoController(PianoView view, AudioService audioService){
        this.pianoView = view;
        this.audioService = audioService;
    }

    public void setupKeyboardHandlers(Scene scene){
        scene.setOnKeyPressed(keyEvent -> {
            Note note = Note.fromKeyCode(keyEvent.getCode());
            if(note != null){
                playNote(note);
            }
        });
        scene.setOnKeyReleased(keyEvent -> {
            Note note = Note.fromKeyCode(keyEvent.getCode());
            if(note != null){
                release(note);
            }
        });
    }

    private void playNote(Note note){
        PianoKey key = this.pianoView.getKey(note);
        if(key != null){
            key.press();
            audioService.playNote(note);
        }
    }
    private void release(Note note){
        PianoKey key = this.pianoView.getKey(note);
        if (key != null){
            key.release();
        }
    }
}
