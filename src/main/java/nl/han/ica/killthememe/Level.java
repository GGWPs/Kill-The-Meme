package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.waterworld.Player;
import nl.han.ica.waterworld.Swordfish;

public class Level extends MainGame{
	private int levels;
	private Sound backgroundSound;
	private Speler speler;
	
	
	
	
	
	public void createObjects() {
		speler = new Speler(this);
        addGameObject(speler, 100, 100);
        Vijand vf=new Vijand(this);
        addGameObject(vf,200,200);
		
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
	}
}
