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
	public Projectiel(MainGame mainGame, Sprite sprite, float richting) {
		super(mainGame, sprite, richting, 0.25f);
	}
	
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Speler) {
				//System.out.print("Het is een hit");
				mainGame.deleteGameObject(this);
				//hier komt wat moet gebeuren als iets de speler raakt.
			}
		}
		
	}

}
