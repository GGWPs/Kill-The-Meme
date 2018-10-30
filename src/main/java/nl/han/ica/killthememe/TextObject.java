package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.objects.GameObject;
import processing.core.PGraphics;


public class TextObject extends GameObject {

    private String text;
    private int currentLevel;
    private int leven;
    
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
        g.text(text,getX(),getY());
        g.text("Leven:" + leven, getX(), getY()+25);
        if(currentLevel == 1) {
        	 g.text("Finish ->", 725, 100);
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
