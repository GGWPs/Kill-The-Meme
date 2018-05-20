package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class PowerUp extends SpriteObject implements ICollidableWithGameObjects {
	protected Sprite powerUp;
	protected MainGame mainGame;
	protected boolean itemIsOpgepakt;
	public Speler speler;
	String powerNaam;

	/*
	 * @param mainGame referentie naar de wereld
	 * 
	 * @param powerUpNaam referentie naar de naam van de powerup
	 */
	public PowerUp(Sprite sprite, MainGame mainGame) {
		super(sprite);
		this.mainGame = mainGame;
		this.itemIsOpgepakt = false;

	}

	public void gebruikPowerUp(float richting) {

	}
	/*
	 * (non-Javadoc) kijkt of het item is opgepakt
	 * 
	 * @see nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects#
	 * gameObjectCollisionOccurred(java.util.List)
	 */

	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Speler) {
				((Speler) go).setPowerup(this);
				setItemIsOpgepakt(true);
				setVisible(false);
			}
		}
	}

	// bolean die returnt of de item is opgepakt
	public boolean isItemIsOpgepakt() {
		return itemIsOpgepakt;
	}

	/*
	 * Functie om de bolean aan te passen.
	 */
	public void setItemIsOpgepakt(boolean itemIsOpgepakt) {
		this.itemIsOpgepakt = itemIsOpgepakt;
	}

	public void update() {
	}

}
