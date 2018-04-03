package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.TextObject;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PApplet;

//yeete


@SuppressWarnings("serial")
public class MainGame extends GameEngine{
	private Speler speler;
	private Vijand vijand;
	private Sound backgroundSound;
    private Sound bubblePopSound;
    private TextObject dashboardText;
    private IPersistence persistence;
    private int bubblesPopped;
    
    private Menu menu;

//	Level level = new Level();
//	Menu menu = new Menu();
	
	public static void main(String[] args) {
		PApplet.main(new String[] {"nl.han.ica.killthememe.MainGame"});
		
	}
	
	@Override
	public void setupGame() {

		 int worldWidth=1204;
	     int worldHeight=903;
	     
	     
	     initializeSound();
	    // createMenu();
//	     menu.createDashboard(worldWidth, 100);
	     createDashboard(worldWidth, 100);
	     initializeTileMap();

	     initializeSound();
	     initializePersistence();
	     createObjects();
	     
	     
	     createView(worldWidth, worldHeight);
	     
		 
	}

	/**
     * creert de view zonder viewport
     * @param screenWidth Breedte van het scherm
     * @param screenHeight Hoogte van het scherm
     */
    private void createView(int screenWidth, int screenHeight) {
        View view = new View(screenWidth,screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/killthememe/media/background.jpeg"));
//        view.setBackground(loadImage("src/main/java/nl/han/ica/waterworld/media/background.jpg"));

        
        setView(view);
        size(screenWidth, screenHeight);
    }
    
    public void createMenu() {
    	menu = new Menu(this);

    }
    private void createDashboard(int dashboardWidth,int dashboardHeight) {
        Dashboard dashboard = new Dashboard(0,0, dashboardWidth, dashboardHeight);
        dashboardText = new TextObject("");
        dashboard.addGameObject(dashboardText);
        addDashboard(dashboard);
    }

    public void initializePersistence() {
        persistence = new FilePersistence("main/java/nl/han/ica/waterworld/media/bubblesPopped.txt");
        if (persistence.fileExists()) {
            bubblesPopped = Integer.parseInt(persistence.loadDataString());
            refreshDasboardText();
        }
    }
    
    public void refreshDasboardText() {
        dashboardText.setText("Level: "+bubblesPopped);
    }
	
    
	public void createObjects() {
		speler = new Speler(this);
        addGameObject(speler, 100, 100);
        Vijand vf=new Vijand(this);
        addGameObject(vf,200,200);
		
	}
	
    private void initializeSound() {
        backgroundSound = new Sound(this, "src/main/java/nl/han/ica/waterworld/media/Waterworld.mp3");
        backgroundSound.loop(-1);
        bubblePopSound = new Sound(this, "src/main/java/nl/han/ica/waterworld/media/pop.mp3");
    }

    
    
    private void initializeTileMap() {
        /* TILES */
        Sprite boardsSprite = new Sprite("src/main/java/nl/han/ica/waterworld/media/boards.jpg");
        TileType<BoardsTile> boardTileType = new TileType<>(BoardsTile.class, boardsSprite);

        TileType[] tileTypes = { boardTileType };
        int tileSize=50;
        int tilesMap[][]={
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1, 0, 0, 0, 0,-1,0 , 0},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
        };
        tileMap = new TileMap(tileSize, tileTypes, tilesMap);
    }
    

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
