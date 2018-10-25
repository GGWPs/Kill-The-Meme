package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.objects.GameObject;
import processing.core.PGraphics;

/**
 * @author Ralph Niels
 * Wordt gebruikt om een tekst te kunnen afbeelden
 */
public class TextObject extends GameObject {

    private String text;
    private int currentLevel;
    
    /*
     * @param text tekst 
     * @param currentLevel huidige level
     */
    public TextObject(String text, int currentLevel) {
        this.text=text;
        this.currentLevel=currentLevel;
    }

    public void setText(String text) {
        this.text=text;
    }
    /*
     * (non-Javadoc)
     * @see nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject#update()
     */
    @Override
    public void update() {

    }
    /*
     * (non-Javadoc)
     * @see nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject#draw(processing.core.PGraphics)
     */
    @Override
    public void draw(PGraphics g) {
    	if(currentLevel >= 1) {
        g.textAlign(g.LEFT,g.TOP);
        g.textSize(20);
        g.text(text,getX(),getY());
        
    	}
    }
}
