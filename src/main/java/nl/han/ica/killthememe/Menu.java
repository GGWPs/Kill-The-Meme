package nl.han.ica.killthememe;


import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import processing.core.PApplet;
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
        	if(!(keyCode == DELETE) && !(keyCode == BACKSPACE) && !(keyCode == SHIFT) && naamText.length() < maxNaamLengte) {
        		naamText+=key;
    			System.out.println(naamText);
    			  if (keyCode == ENTER) {
    				  mainGame.setCurrentName(naamText);
    				  mainGame.setCurrentLevel(3);
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
            g.fill(0);
            g.textAlign(g.LEFT,g.TOP);
            g.text(naamText,worldWidth/2-menuKnopY*4,((worldHeight/40)*18)+menuKnopY);
            tekenKnoppen(g, worldWidth/3, worldWidth/2, (worldHeight/3)*2, "Next ", "Quit ");
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
            tekenKnoppen(g, worldWidth/3, worldWidth/2, (worldHeight/3)*2, "Retry ", "Quit ");
    	} else if(currentLevel == -10) {
    		g.textAlign(g.CENTER,g.TOP);
            g.textSize(50);
            g.text(text,worldWidth/2,worldHeight/12);
            g.textSize(20);
            tekenKnoppen(g, worldWidth/3, worldWidth/2, (worldHeight/3)*2, "Terug ", "Start ");
            
            g.text("In ieder level is een doel te behalen om naar het volgende level te gaan.", worldWidth/12, worldHeight/5);
            g.text("Dit zijn objecten binnen het spel waar je mee te maken hebt.", worldWidth/12, worldHeight/5+menuKnopY);
            
            g.text("Interactie:", 0+menuKnopX/2, worldWidth/3+menuKnopX);
            g.text("Powerup ", worldHeight/4, worldHeight/4+menuKnopX);
            g.text("Speler", worldHeight/2, worldHeight/4+menuKnopX);
            g.text("Vijand", worldWidth-(menuKnopX*2), worldHeight/4+menuKnopX);
            
            
            g.text("Spatie", worldHeight/4, worldWidth/3+menuKnopX);

            g.text("Pijltjestoetsen", worldWidth/3, worldHeight/2+menuKnopY);
            g.text("W,A,S,D", worldWidth/3, worldHeight/2+menuKnopY*2);
            
            g.text("Schiet projectielen", worldWidth/2+worldWidth/4, worldHeight/2+menuKnopY);
            g.text("(ontwijkt ze!)", worldWidth/2+worldWidth/4, worldHeight/2+menuKnopY*2);
    	}
    }
    /*
     * @param
     * 	g processing PGraphics
     *  aX, eerste X coordinaat eerste knop
     *  bX tweede X coordinaat tweede knop
     *  cY allebei Y coordinaat van beide knoppen en tekst want ze zullen allebei dezelfde Y coordinaat hebben
     *  tekstA de tekst die de linker eerste knop heeft
     *  tekstB de tekst die de rechter tweede knop heeft
     */
    public void tekenKnoppen(PGraphics g, int aX, int bX, int cY, String tekstA, String tekstB) {
    	g.textSize(20);
        g.fill(255);
        g.rect(aX,cY ,menuKnopX ,menuKnopY, 8);
        g.rect(bX,cY ,menuKnopX ,menuKnopY, 8); 
        g.fill(0);
        g.textAlign(g.LEFT,g.TOP);
        g.text(tekstA, aX+(menuKnopY/2), cY);
        g.text(tekstB, bX+(menuKnopY/2), cY);
        g.fill(255);
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
