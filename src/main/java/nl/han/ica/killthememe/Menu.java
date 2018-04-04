package nl.han.ica.killthememe;


import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import processing.core.PGraphics;


@SuppressWarnings("serial")
public class Menu extends GameObject{
	//yeet
    private TextObject dashboardText;
    private IPersistence persistence;
    private int bubblesPopped;
    private int currentLevel;
    private int worldWidth;
    private int worldHeight;
    private String text;
    private int menuKnopX = 80;
    private int menuKnopY= 30;
    
	
    
    
    
	/**
	 * 
	 * @param text
	 * @param currentLevel huidige level
	 * @param worldWidth
	 * @param worldHeight
	 */
    public Menu(String text, int currentLevel, int  worldWidth, int worldHeight) {
        this.text=text;
        this.currentLevel=currentLevel;
        this.worldWidth=worldWidth;
        this.worldHeight=worldHeight;
    }

    public void setText(String text) {
        this.text=text;
    }
	
    @Override
    public void draw(PGraphics g) {
    	if(currentLevel == 0) {
    		g.setSize(worldWidth, worldHeight);
    		g.background(0);
    		g.textAlign(g.CENTER,g.TOP);
            g.textSize(50);
            g.text(text,worldWidth/2,worldHeight/4);
            g.fill(255);
//            g.rectMode(CORNERS);
            g.rect(worldWidth/2,(worldHeight/3)*2 ,menuKnopX ,menuKnopY, 8); 
            g.fill(0);
            g.textAlign(g.LEFT,g.TOP);
            g.textSize(20);
            g.text("Start ", worldWidth/2+15, worldWidth/2);
    	}
    	
    	if(currentLevel == 99) {
    		g.setSize(worldWidth, worldHeight);
    		g.background(0);
    		g.textAlign(g.CENTER,g.TOP);
            g.textSize(50);
            g.text(text,worldWidth/2,worldHeight/4);
            g.fill(255);
//            g.rectMode(CORNERS);
            g.rect(worldWidth/2,(worldHeight/3)*2 ,menuKnopX ,menuKnopY, 8); 
            g.fill(0);
            g.textAlign(g.LEFT,g.TOP);
            g.textSize(20);
            g.text("Retry ", worldWidth/2+15, worldWidth/2);
    	}
    }



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	

}
