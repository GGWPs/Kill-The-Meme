package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

/**
 * @author Ralph Niels
 * Wordt gebruikt om een tekst te kunnen afbeelden
 */
public class TextObject extends GameObject {

    private String text;
    private int currentLevel;

    public TextObject(String text, int currentLevel) {
        this.text=text;
        this.currentLevel=currentLevel;
    }

    public void setText(String text) {
        this.text=text;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {
    	if(currentLevel == 0) {
    		g.textAlign(g.CENTER,g.TOP);
            g.textSize(50);
            g.text(text,getX()+400,getY()+50);
    	}
    	if(currentLevel >= 1) {
        g.textAlign(g.LEFT,g.TOP);
        g.textSize(20);
        g.text(text,getX(),getY());
    	}
    }
}
