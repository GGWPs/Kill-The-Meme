package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;
import java.util.List;
import nl.han.ica.OOPDProcessingEngineHAN.collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.objects.GameObject;

import nl.han.ica.OOPDProcessingEngineHAN.objects.SpriteObject;

public abstract class Aanval extends SpriteObject implements ICollidableWithGameObjects{

	protected MainGame mainGame;

	/**
	 * Aanval constructor
	 * 
	 * @param mainGame de wereld
	 * @param sprite de sprite van de aanval
	 * @param richting de richting van de aanval
	 * @param snelheid snelheid van de aanval
	 */
	public Aanval(MainGame mainGame, Sprite sprite, float richting, float snelheid) {
		super(sprite);
		this.mainGame = mainGame;
		setDirectionSpeed(richting, snelheid);
	}

	/**
	 * kijkt of de aanval buiten het scherm komt
	 */
	@Override
	public void update() {
		if (getY() < 0 || getY() > mainGame.getHeight() || 
				getX() < 0 || getX() > mainGame.getWidth()) {
			mainGame.deleteGameObject(this);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects#gameObjectCollisionOccurred(java.util.List)
	 */
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		
	}
}

