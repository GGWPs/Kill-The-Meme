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
	protected String powerNaam;
	/**
	 * Attribuut van de speler voor het checken van de collision.
	 */
	public Speler speler;

	/**
	 * PowerUp constructor
	 * 
	 * @param mainGame referentie naar de wereld
	 * 
	 * @param powerUpNaam referentie naar de naam van de powerup
	 */
	public PowerUp(Sprite sprite, MainGame mainGame) {
		super(sprite);
		this.mainGame = mainGame;
		this.itemIsOpgepakt = false;

	}
	
	/**
	 * Functie om de powerup te gebruiken
	 * 
	 * @param richting richting naar de vijand als het toegepast wordt.
	 */
	public void gebruikPowerUp(float richting) {
	}
	
	/**
	 * (non-Javadoc) kijkt of de speler tegen het object aan loopt en zet een boolean dat de speler het heeft opgeraapt op true en maakt dan het object onzichtbaar.
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

	/**
	 * bolean die returnt of de item is opgepakt
	 * @return itemIsOpgepakt
	 */ 
	public boolean isItemIsOpgepakt() {
		return itemIsOpgepakt;
	}

	/**
	 * Functie om de boolean aan te passen.
	 * 
	 * @param itemIsOpgepakt een boolean die aangeeft of de speler de powerup heeft opgepakt.
	 */
	public void setItemIsOpgepakt(boolean itemIsOpgepakt) {
		this.itemIsOpgepakt = itemIsOpgepakt;
	}
	
	/*
	 * Returnt de naam van de powerup
	 */
	public String powerNaam() {
		return powerNaam;
	}
	
	public void update() {
	}

}
