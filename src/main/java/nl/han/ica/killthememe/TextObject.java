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
    private int worldWidth;
    private int worldHeight;
    

    public TextObject(String text, int currentLevel, int  worldWidth, int worldHeight) {
        this.text=text;
        this.currentLevel=currentLevel;
        this.worldWidth=worldWidth;
        this.worldHeight=worldHeight;
    }

    public void setText(String text) {
        this.text=text;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {
    	if(currentLevel >= 1) {
        g.textAlign(g.LEFT,g.TOP);
        g.textSize(20);
        g.text(text,getX(),getY());
        
    	}
    }
}
