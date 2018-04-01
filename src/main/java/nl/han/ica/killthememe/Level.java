package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.waterworld.Player;

public class Level extends MainGame{
	private int levels;
	private Sound backgroundSound;
	private Speler speler;
	
	
	
	private void createObjects() {
		speler = new Speler(this);
		
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
}
