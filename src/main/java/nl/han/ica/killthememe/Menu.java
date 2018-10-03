package nl.han.ica.killthememe;


import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;


@SuppressWarnings("serial")
public class Menu extends GameObject{
   private int currentLevel;
    private int worldWidth;
    private int worldHeight;
    private String text;
    private String naamText;
    private int menuKnopX = 80;
    private int menuKnopY= 30;
    private MainGame mainGame;
    private int maxNaamLengte = 15;
    
	
    
    
    
	/**
	 * menu constructor
	 * 
	 * @param text
	 * @param currentLevel huidige level
	 * @param worldWidth scherm breedte
	 * @param worldHeight scherm hoogte
	 */
    public Menu(MainGame mainGame, String text, int currentLevel, int  worldWidth, int worldHeight) {
    	this.mainGame=mainGame;
        this.text=text;
        this.currentLevel=currentLevel;
        this.worldWidth=worldWidth;
        this.worldHeight=worldHeight;
    }
    
    /**
     * Functie om de text te wijzigen
     * 
     * @param text menu text en dergelijke
     */
    public void setText(String text) {
        this.text=text;
    }
    
    /**
     * Functie om de naam te wijzigen
     * 
     * @param naamText String die de naam bevat
     */
    public void setNaamText(String naamText) {
        this.naamText=naamText;
    }
    
    /**
     * Functie die kijkt of er een knop is ingedrukt en om de naam in te voeren/retry knop te gebruiken op een andere manier dan muis. 
     * Checkt ook op max naam lengte
     */
    @Override
    public void keyPressed(int keyCode, char key) {
    	if(currentLevel == 0) {
    		if(keyCode == BACKSPACE) {
        		if(naamText.length() > 0) {
        			 naamText = naamText.substring(0, naamText.length()-1);
        		}
        		System.out.println("back");
        	} else if (keyCode == DELETE) {
        	    naamText = "";
        	}
        	if(!(keyCode == DELETE) && !(keyCode == BACKSPACE) && naamText.length() < maxNaamLengte) {
        		naamText+=key;
    			System.out.println(naamText);
    			  if (keyCode == ENTER) {
    				  mainGame.setCurrentName(naamText);
    				  mainGame.setCurrentLevel(-10);
    			      mainGame.setupGame();
    			  }
        	}
        }
    	if (keyCode == ENTER && !(currentLevel == 0)) {
			  mainGame.setCurrentLevel(1);
		      mainGame.setupGame();
		  }
    }
    
    /** 
     * Draw methode van processing om de menu te tekenen.
     */
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
            g.rect(worldWidth/3,(worldHeight/4)*2 ,menuKnopX*3 ,menuKnopY, 8); 
            g.rect(worldWidth/2,(worldHeight/3)*2 ,menuKnopX ,menuKnopY, 8); 
            g.rect(worldWidth/3,(worldHeight/3)*2 ,menuKnopX ,menuKnopY, 8); 
            g.fill(0);
            g.textAlign(g.LEFT,g.TOP);
            g.text(naamText,worldWidth/2-menuKnopY*4,((worldHeight/40)*18)+menuKnopY);
            g.textSize(20);
            g.text("Quit ", worldWidth/2+(menuKnopY/2) , worldWidth/2);
            g.text("Start ", worldWidth/3+(menuKnopY/2) , worldWidth/2);
    	} else if(currentLevel == -1 || currentLevel == 6) {
    		g.setSize(worldWidth, worldHeight);
    		g.background(0);
    		g.textAlign(g.CENTER,g.TOP);
            g.textSize(50);
            g.text(text,worldWidth/2,worldHeight/4);
            g.fill(255);
            g.rect(worldWidth/2,(worldHeight/3)*2 ,menuKnopX ,menuKnopY, 8); 
            g.rect(worldWidth/3,(worldHeight/3)*2 ,menuKnopX ,menuKnopY, 8); 
            g.fill(0);
            g.textAlign(g.LEFT,g.TOP);
            g.textSize(20);
            g.text("Retry ", worldWidth/3+(menuKnopY/2), worldWidth/2);
            g.text("Quit ", worldWidth/2+(menuKnopY/2) , worldWidth/2);
    	} else if(currentLevel == -10) {
    		g.textAlign(g.CENTER,g.TOP);
            g.textSize(50);
            g.text(text,worldWidth/2,worldHeight/8);
            g.fill(255);
            g.rect(worldWidth/2,(worldHeight/3)*2 ,menuKnopX ,menuKnopY, 8); 
            g.rect(worldWidth/3,(worldHeight/3)*2 ,menuKnopX ,menuKnopY, 8); 
            g.fill(0);
            g.textAlign(g.LEFT,g.TOP);
            g.textSize(20);
            g.text("Back ", worldWidth/3+(menuKnopY/2), worldWidth/2);
            g.text("Next ", worldWidth/2+(menuKnopY/2) , worldWidth/2);
            g.fill(255);
            g.text("Powerup ", worldWidth/8, worldWidth/4);
            g.text(" Spatie", worldWidth/8, worldWidth/3+menuKnopX);

            g.text("Beweging", worldWidth/3, worldWidth/4);
            g.text("Pijltjestoetsen", worldWidth/3, worldWidth/3+menuKnopX);
            
            g.text("Vijand", worldWidth/2+worldWidth/4+menuKnopY, worldWidth/4);
            g.text("Schiet projectielen", worldWidth/2+worldWidth/4, worldWidth/3+menuKnopX);
    	}
    }



	@Override
	public void update() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Functie om de naam op te halen.
	 * @return naamText de naam van de speler.
	 */
	public String getNaam() {
		return naamText;
	}
	

}
