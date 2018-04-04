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
    		g.setSize(800, 600);
    		g.background(0);
    		g.textAlign(g.CENTER,g.TOP);
            g.textSize(50);
            g.text(text,800/2,height/2);
            g.fill(255);
//            g.rectMode(CORNERS);
            g.rect(350,400 ,80 ,40, 8); 
            g.fill(0);
            g.textAlign(g.LEFT,g.TOP);
            g.textSize(20);
            g.text("Start ", 370, 400);
    	}
    	if(currentLevel >= 1) {
        g.textAlign(g.LEFT,g.TOP);
        g.textSize(20);
        g.text(text,getX(),getY());
        
    	}
    }
}
