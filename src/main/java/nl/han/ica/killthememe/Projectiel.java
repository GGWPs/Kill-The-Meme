package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Projectiel extends Aanval {
	

	public static int WIDTH = 20;

	/**
	 * Projectiel constructor 
	 * 
	 * @param mainGame
	 * @param sprite
	 */
	public Projectiel(MainGame mainGame, Sprite sprite, float richting, float snelheid) {
		super(mainGame, sprite, richting, snelheid);
	}
	
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Speler && (go instanceof PowerUp)) {
			
				mainGame.deleteGameObject(this);
				mainGame.setCurrentLevel(-1);
				mainGame.setupGame();
			}
		}
		
	}

}
