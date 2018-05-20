package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class PowerUp extends SpriteObject implements ICollidableWithGameObjects, IAlarmListener{
	private String powerUpNaam;
	private Sprite powerUp;
	private MainGame mainGame;
	private boolean itemIsOpgepakt;
	
	
	/*
	 * @param mainGame referentie naar de wereld
	 * @param powerUpNaam referentie naar de naam van de powerup
	 */
	public PowerUp(MainGame mainGame,String  powerUpNaam) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/PowerUpCopyAttack.png"));
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

	@Override
	public void triggerAlarm(String alarmName) {
		// TODO Auto-generated method stub
		
	}


	
	

}
