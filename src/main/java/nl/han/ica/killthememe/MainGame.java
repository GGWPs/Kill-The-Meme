package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.killthememe.TextObject;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PApplet;

//yeete

@SuppressWarnings("serial")
public class MainGame extends GameEngine{
	private Speler speler;
	private Vijand vijand;
	private BaasEen baaseen;
	private Vogel vogel;
	private Sound backgroundSound;
	private TextObject dashboardText;
	private IPersistence persistence;
	private int currentLevel = 0;
	Level level = new Level(getCurrentLevel());
	private int worldWidth;
	private String naamText = " ";
	private boolean bossVerslagen;
	private Menu menu;
	private int worldHeight;
	private boolean isNext;

	public static void main(String[] args) {
		PApplet.main(new String[] { "nl.han.ica.killthememe.MainGame" });

	}

	
	//Dit is om alles van de level/spel voor te bereiden.
	@Override
	public void setupGame() {

		 worldWidth=800;
	     worldHeight=600;
	     
	 	deleteAllGameOBjects();
	 	if(currentLevel == 0) {
	     initializeSound();
	 	}
	     createDashboard(worldWidth, 100, getCurrentLevel());
	     initializeTileMap(getCurrentLevel());

	     refreshDasboardText();
	     createObjects(getCurrentLevel());
	     
	     createView(worldWidth, worldHeight);

	     

	}

	/**
	 * creert de view zonder viewport
	 * 
	 * @param screenWidth
	 *            Breedte van het scherm
	 * @param screenHeight
	 *            Hoogte van het scherm
	 */
	private void createView(int screenWidth, int screenHeight) {
		View view = new View(screenWidth, screenHeight);
		view.setBackground(loadImage(level.pickBackground(getCurrentLevel())));

		setView(view);
		size(screenWidth, screenHeight);
	}

	//Functie om een dashboard te maken.
	private void createDashboard(int dashboardWidth, int dashboardHeight, int currentLevel) {
		deleteAllDashboards();
		Dashboard dashboard = new Dashboard(0, 0, dashboardWidth, dashboardHeight);
		if(getCurrentLevel() == 0 || getCurrentLevel() == -1 ) {
			menu = new Menu(this,"", currentLevel, worldWidth, worldHeight);
			dashboard.addGameObject(menu);
			addGameObject(menu);
		} else if (getCurrentLevel() >= 1) {
			dashboardText = new TextObject("", currentLevel, worldWidth, worldHeight);
			dashboard.addGameObject(dashboardText);
		}
		addDashboard(dashboard);
	}

	//
	@Override
	public void mouseClicked(){
		if(mouseX > worldWidth/2 && mouseY > (worldHeight/3)*2&& mouseX < worldWidth/2+80 && mouseY < 440 && currentLevel == 0 
				|| currentLevel == -1 && mouseX > worldWidth/2 && mouseY > (worldHeight/3)*2&& mouseX < worldWidth/2+80 && mouseY < 440) {
			if(currentLevel == 0) {
				naamText=menu.getNaam();
			}
			currentLevel = 1;
			
			setupGame();
		}
	}
	//om de dashboard te verversen.
	public void refreshDasboardText() {
		if (getCurrentLevel() == 0) {
			menu.setText("Kill The Meme!");
			menu.setNaamText(naamText);
		}
		if (getCurrentLevel() >= 1) {
			dashboardText.setText("Level: " + getCurrentLevel() + "  " + naamText);
		}
		if(getCurrentLevel() == -1) {
			menu.setText("Dead! Retry?");
		}
	}
	
	
	//Dit is voor de creatie van Game Objecten
	public void createObjects(int currentLevel) {
		if (currentLevel == 1) {
			speler = new Speler(this,0.3f);
			addGameObject(speler, 10, 100);

			vogel = new Vogel(this);
			addGameObject(vogel, 1000, 100);
			baaseen = new BaasEen(this);
			addGameObject(baaseen, 220, 500);

			PowerUp copy = new PowerUp(this, "copyPower");
			addGameObject(copy, 10, 100);
		}
		if (currentLevel == 2) {
			speler = new Speler(this,0.4f);
			addGameObject(speler, 10, 100);

			vogel = new Vogel(this);
			addGameObject(vogel, 1000, 100);
			baaseen = new BaasEen(this);
			addGameObject(baaseen, 700, 500);


			PowerUp copy = new PowerUp(this, "copyPower");
			addGameObject(copy, 100, 300);
		}

	}

	//Functie om het geluid te initieeren
	private void initializeSound() {
		backgroundSound = new Sound(this, "src/main/java/nl/han/ica/killthememe/media/SeaShanty2.mp3");
		backgroundSound.loop(-1);
//		bubblePopSound = new Sound(this, "src/main/java/nl/han/ica/waterworld/media/pop.mp3");
	}

    
    //Functie om de tilemap in te laden en op te halen van Level.
    private void initializeTileMap(int currentLevel) {
        /* TILES */

        Sprite boardsSprite = new Sprite(level.pickLevelTile());
        TileType<BoardsTile> boardTileType = new TileType<>(BoardsTile.class, boardsSprite);

        TileType[] tileTypes = { boardTileType };
        int tileSize=50;
        
        tileMap = new TileMap(tileSize, tileTypes, level.getLevelTile(currentLevel));
    }
    
    
    public void bossVerslagen() {
    	bossVerslagen = true;
    }


    //niet gebruikt
	@Override
	public void update() {


	}

	//Haalt de gameobject op zodat de projectiel weet waar die naartoe moet gaan
	public GameObject getSpeler() {
		
		return speler;
	}
	//Functie die de huidige level teruggeeft
	public int getCurrentLevel() {
		return currentLevel;
	}
	//Functie om de level te wijzigen
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	//Functie om de naam van de speler op te slaan.
	public void setCurrentName(String naamText) {
		this.naamText=naamText;
	}
	// Haalt de X pos van de speler op
	public float getSpelerX() {
		return speler.getX();
	}
	//Haalt de Y pos van de speler op
	public float getSpelerY() {
		return speler.getY();
	}
	//Haalt de gameobject op zodat de projectiel weet waar die naartoe moet gaan 
	public GameObject getBaasEen() {
		return baaseen;
	}
	
	
	//checkt of de level is gecleared en weergeeft true.
	boolean levelClear() {
		if(getCurrentLevel() == 1 && getSpelerX() >= 740 && speler.getY() >= 50 && speler.getX() <= 800 && speler.getY() <= 150) {
			return true;
		}
		if(getCurrentLevel() == 2 && getSpelerX() >= 715 && speler.getY() >= 500 && speler.getX() <= 800 && speler.getY() <= 600 || bossVerslagen) {
			return true;
		}
		return false;
	}

	
	

}
