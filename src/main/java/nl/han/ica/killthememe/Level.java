package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.waterworld.Player;
import nl.han.ica.waterworld.Swordfish;

public class Level extends MainGame{
	private int levels;
	private Sound backgroundSound;
	private Speler speler;
	private int currentLevel;
	
	
	public Level(int currentLevel) {
		this.currentLevel=currentLevel;
	}
	
	
	
	boolean levelClear() {
		
		return true;
	}
	
	void obstakel() {
		
	}
	
	public void setupGame() {
		
	}
	
	void statusBalk() {
		
	}
	
	void updateStatus() {
		
	}
	
	void initializeSound(){
			
	}
	
	void initializeTileMap(){
		
	}


	public int[][] getLevelTile(int currentLevel){
		
		if (currentLevel == 1) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][]={
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,0,0,0,0,0,-1,-1},
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
			return tilesMap; 
		} else if (currentLevel == 2) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][]={
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,0,0,0,0,0,-1,-1},
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
			return tilesMap;
		} else {
			System.out.println("Geen level gevonden!");
		return null;
		}
		
	}
}
