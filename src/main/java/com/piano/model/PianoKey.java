package com.piano.model;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PianoKey {
    private final Note note;
    private final Rectangle rectangle;
    private final StackPane pane;
    private final Color defaultColor;
    private final Color pressedColor;

    public PianoKey(Note note, double x, int width, int height){
        this.note = note;

        this.defaultColor = this.note.isBlack() ? Color.BLACK : Color.WHITE;

        this.rectangle = new Rectangle(width,height);
        this.rectangle.setFill(defaultColor);
        this.rectangle.setStroke(Color.BLACK);
        this.rectangle.setStrokeWidth(2);

        Text text = new Text(this.note.getKeyCode().getName());
        text.setFill(note.isBlack() ? Color.WHITE : Color.BLACK);

        this.pane = new StackPane(rectangle,text);
        this.pane.setLayoutX(x);

        this.pressedColor = this.note.isBlack() ? Color.DARKGRAY : Color.LIGHTBLUE;
    }
    public void press(){
        this.rectangle.setFill(pressedColor);
    }
    public void release(){
        this.rectangle.setFill(defaultColor);
    }

    public Note getNote() {
        return note;
    }

    public StackPane getPane() {
        return pane;
    }
}
