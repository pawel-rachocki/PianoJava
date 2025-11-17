package com.piano.service;

import com.piano.model.Note;
import javafx.scene.media.AudioClip;

import java.util.HashMap;
import java.util.Map;

public class AudioService {
    private final Map<Note, AudioClip> nuty;

    public AudioService() {
        this.nuty = new HashMap<>();
    }

    public void loadSounds(){
        for(Note note : Note.values()){
            String path = "/sounds/" + note.getSoundFile() + ".wav";
            try {
                AudioClip audioClip = new AudioClip(getClass().getResource(path).toExternalForm());
                this.nuty.put(note,audioClip);
            } catch (Exception e) {
                System.err.println("Nie mozna zaladowac dzwieku: " + path);
                e.printStackTrace();
            }
        }
    }

    public void playNote(Note note){
        AudioClip audioClip = this.nuty.get(note);
        if(audioClip != null) audioClip.play();
    }
}
