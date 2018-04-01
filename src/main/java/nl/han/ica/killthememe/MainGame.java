package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PApplet;

//yeet


@SuppressWarnings("serial")
public class MainGame extends GameEngine{
	private Speler speler;
	private Vijand vijand;
//	Level level = new Level();
//	Menu menu = new Menu();
	
	public static void main(String[] args) {
		PApplet.main(new String[] {"nl.han.ica.killthememe.MainGame"});
		
	}
	
	@Override
	public void setupGame() {
		// TODO Auto-generated method stub
		 int worldWidth=1204;
	     int worldHeight=903;
	     
	     initializeTileMap();
//	     menu.createDashboard(worldWidth, 100);
	     createView(worldWidth, worldHeight);
		 createObjects();
	}

	/**
     * creert de view zonder viewport
     * @param screenWidth Breedte van het scherm
     * @param screenHeight Hoogte van het scherm
     */
    private void createView(int screenWidth, int screenHeight) {
        View view = new View(screenWidth,screenHeight);
//        view.setBackground(loadImage("src/main/java/nl/han/ica/killthememe/media/background1.jpg"));
        view.setBackground(loadImage("src/main/java/nl/han/ica/waterworld/media/background.jpg"));

        
        setView(view);
        size(screenWidth, screenHeight);
    }
    
	public void createObjects() {
		speler = new Speler(this);
        addGameObject(speler, 100, 100);
        Vijand vf=new Vijand(this);
        addGameObject(vf,200,200);
		
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
