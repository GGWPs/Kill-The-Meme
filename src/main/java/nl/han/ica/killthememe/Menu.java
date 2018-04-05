package nl.han.ica.killthememe;


import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import processing.core.PGraphics;
import processing.event.KeyEvent;


@SuppressWarnings("serial")
public class Menu extends GameObject{
<<<<<<< HEAD
	//yeet

=======
>>>>>>> branch 'master' of https://github.com/GGWPs/killthememev2.git
    private int currentLevel;
    private int worldWidth;
    private int worldHeight;
    private String text;
    private String naamText;
    private int menuKnopX = 80;
    private int menuKnopY= 30;
    private MainGame mainGame;
    
	
    
    
    
	/**
	 * 
	 * @param text
	 * @param currentLevel huidige level
	 * @param worldWidth scherm breedte
	 * @param worldHeight scherm hoogte
	 */
    public Menu(MainGame mainGame, String text, int currentLevel, int  worldWidth, int worldHeight) {
        this.text=text;
        this.currentLevel=currentLevel;
        this.worldWidth=worldWidth;
        this.worldHeight=worldHeight;
        this.mainGame=mainGame;
    }

    public void setText(String text) {
        this.text=text;
    }
    
    public void setNaamText(String naamText) {
        this.naamText=naamText;
    }
    
    @Override
    public void keyPressed(int keyCode, char key) {
    	if(keyCode == BACKSPACE) {
    		if(naamText.length() > 0) {
    			 naamText = naamText.substring(0, naamText.length()-1);
    		}
    		System.out.println("back");
    	} else if (keyCode == DELETE) {
    	    naamText = "";
    	}
    	if(!(keyCode == DELETE) && !(keyCode == BACKSPACE) ) {
    		naamText+=key;
			System.out.println(naamText);
			  if (keyCode == ENTER) {
				  mainGame.setCurrentName(naamText);
				  mainGame.setCurrentLevel(2);
			      mainGame.setupGame();
			  }
    	}
			
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
            g.textSize(25);
            g.text("Naam: ",worldWidth/2-menuKnopX,(worldHeight/40)*18);
            g.fill(255);
//            g.rectMode(CORNERS);
            g.rect(worldWidth/3,(worldHeight/4)*2 ,menuKnopX*3 ,menuKnopY, 8); 
            g.rect(worldWidth/2,(worldHeight/3)*2 ,menuKnopX ,menuKnopY, 8); 
            g.fill(0);
            g.textAlign(g.LEFT,g.TOP);
            g.text(naamText,worldWidth/2-menuKnopY*4,((worldHeight/40)*18)+menuKnopY);
            g.textSize(20);
            g.text("Start ", worldWidth/2+(menuKnopY/2), worldWidth/2);
    	}
    	
    	
    	
    	if(currentLevel == -1) {
    		g.setSize(worldWidth, worldHeight);
    		g.background(0);
    		g.textAlign(g.CENTER,g.TOP);
            g.textSize(50);
            g.text(text,worldWidth/2,worldHeight/4);
            g.fill(255);
            g.rect(worldWidth/2,(worldHeight/3)*2 ,menuKnopX ,menuKnopY, 8); 
            g.fill(0);
            g.textAlign(g.LEFT,g.TOP);
            g.textSize(20);
            g.text("Retry ", worldWidth/2+(menuKnopY/2), worldWidth/2);
    	}
    	
    	if(currentLevel == 4) {
    		g.setSize(worldWidth, worldHeight);
    		g.background(0);
    		g.textAlign(g.CENTER,g.TOP);
            g.textSize(50);
            g.text(text,worldWidth/2,worldHeight/4);
            g.fill(255);
            g.rect(worldWidth/2,(worldHeight/3)*2 ,menuKnopX ,menuKnopY, 8); 
            g.fill(0);
            g.textAlign(g.LEFT,g.TOP);
            g.textSize(20);
            g.text("Retry ", worldWidth/2+(menuKnopY/2), worldWidth/2);
    	}
    }



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public String getNaam() {
		return naamText;
	}
	

}
