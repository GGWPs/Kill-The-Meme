package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class PowerUp extends SpriteObject implements ICollidableWithGameObjects {
	protected MainGame mainGame;
	protected Sprite powerUp;
	protected boolean sloop;
	protected boolean aanval;
	
	
	/**
	 * Attribuut van de speler voor het checken van de collision.
	 */
	protected Speler speler;

	/**
	 * PowerUp constructor
	 * 
	 * @param mainGame
	 *            referentie naar de wereld
	 * 
	 * @param powerUpNaam
	 *            referentie naar de naam van de powerup
	 */
	public PowerUp(Sprite sprite, MainGame mainGame) {
		super(sprite);
		this.mainGame = mainGame;

	}

	/**
	 * Functie om de powerup te gebruiken
	 * 
	 * 
	 */
	public void gebruikPowerUp(Speler speler) {
	}
	
	

	/**
	 * (non-Javadoc) kijkt of de speler tegen het object aan loopt en zet een
	 * boolean dat de speler het heeft opgeraapt op true en maakt dan het object
	 * onzichtbaar.
	 * 
	 * @see nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects#
	 *      gameObjectCollisionOccurred(java.util.List)
	 */
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Speler) {
				((Speler) go).setPowerup(this);
				setVisible(false);
			}
		}
	}
	
	
	public boolean getSloop() {
		return sloop;
	}
	
	public boolean getAanval() {
		return aanval;
	}

	public void update() {
	}

}
