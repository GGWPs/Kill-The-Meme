package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class PowerUp extends SpriteObject implements ICollidableWithGameObjects, IAlarmListener{
	protected String powerUpNaam;
	protected Sprite powerUp;
	protected MainGame mainGame;
	protected boolean itemIsOpgepakt;
	protected boolean magAanvallen;
	
	
	/*
	 * @param mainGame referentie naar de wereld
	 * @param powerUpNaam referentie naar de naam van de powerup
	 */
	public PowerUp(Sprite sprite, MainGame mainGame,String powerUpNaam) {
		super(sprite);
		this.mainGame = mainGame;
		this.powerUpNaam = powerUpNaam;
		this.itemIsOpgepakt = false;
	}
	

	public void gebruikPowerUp() {
		
	}
	/*
	 * (non-Javadoc)
	 *kijkt of de item is opgepakt
	 * @see nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects#gameObjectCollisionOccurred(java.util.List)
	 */
	
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Speler) {
				itemIsOpgepakt = true;
				setVisible(false);
			}
		}
	}
	//bolean die returnt of de item is opgepakt
	public boolean isItemIsOpgepakt() {
		return itemIsOpgepakt;
	}
	/*
	 * Functie om de bolean aan te passen.
	 */
	public void setItemIsOpgepakt(boolean itemIsOpgepakt) {
		this.itemIsOpgepakt = itemIsOpgepakt;
	}



	//niet gebruikt
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void triggerAlarm(String alarmName) {
		if (alarmName == "magAanvallen") {
			magAanvallen = false;
		}
	}
	
	/**
	 * Functie om alarm te starten voor de aanval van de speler.
	 */
	public void startAlarmAanval() {
		magAanvallen = true;
		Alarm alarm = new Alarm("magAanvallen", 1 / 6);
		alarm.addTarget(this);
		alarm.start();

	}	

	
	

}
