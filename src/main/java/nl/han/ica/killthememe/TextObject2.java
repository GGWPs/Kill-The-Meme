package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

/**
 * @author Ralph Niels
 * Wordt gebruikt om een tekst te kunnen afbeelden
 */
public class TextObject2 extends GameObject {

    private String text;

    public TextObject2(String text) {
        this.text=text;
    }

    public void setText(String text) {
        this.text=text;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {
        g.textAlign(g.LEFT,g.TOP);
        g.textSize(20);
        g.text(text,getX(),getY());
    }
}
