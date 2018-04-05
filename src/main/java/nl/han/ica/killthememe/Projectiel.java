package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public abstract class Projectiel extends Aanval {
	

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
	public void update() {
		if (getY() < 0 || getY() > mainGame.getHeight() || 
				getX() < 0 || getX() > mainGame.getWidth()) {
			mainGame.deleteGameObject(this);
		}
	}
	
	public abstract void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects);

}
