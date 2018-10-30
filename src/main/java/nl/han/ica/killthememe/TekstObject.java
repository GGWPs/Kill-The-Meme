package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.objects.GameObject;
import processing.core.PGraphics;


public class TekstObject extends GameObject {

    private String tekst;
    private int currentLevel;
    private int leven;
    
    /*
     * @param tekst tekst 
     * @param currentLevel huidige level
     */
    public TekstObject(String text, int currentLevel) {
        this.tekst=text;
        this.currentLevel=currentLevel;
    }
    
    
    
    /*
     * Setter voor de tekst op het scherm.
     * 
     */
    public void setText(String text) {
        this.tekst=text;
    }
    
    
    /*
     * Setter zodat de juiste speler leven wordt weergeven
     */
    public void setLeven(int leven) {
        this.leven=leven;
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
    	g.fill(255, 255, 255);
        g.textAlign(g.LEFT,g.TOP);
        g.textSize(20);
        g.text(tekst,getX(),getY());
        g.text("Leven:" + leven, getX(), getY()+25);
        if(currentLevel == 1) {
        	 g.text("Finish ->", 700, 100);
        } else if(currentLevel == 2) {
        	//g.text("Finish", 725, 100);
        } else if(currentLevel == 3) {
        	g.text("Finish ->", 700, 75);
        } else if(currentLevel == 4) {
        	g.text("Finish ->", 700, 300);
        }
    	}
    }
}
