package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class Aanval extends SpriteObject implements ICollidableWithGameObjects{

	protected MainGame mainGame;

	/**
	 * Aanval constructor
	 * @param mainGame
	 * @param sprite
	 * @param richting
	 * @param snelheid
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
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// TODO Auto-generated method stub
		
	}
}

