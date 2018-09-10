package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpVlug extends PowerUp{
	
	private String powerNaam = "Speed";
	
	/**
	 * PowerupVlug constructor
	 * 
	 * @param mainGame de wereld
	 */
	public PowerUpVlug(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/powerups/PowerUpVlug.png"), mainGame);
	}
	
	/**
	 * Functie voor het gebruiken van de powerup, wordt niet gebruikt bij deze powerup.
	 */
	public void gebruikPowerUp() {
		//Speler.setSpeed(4);
		Speler.speed = 4;
		
	}
	
	/**
	 * Functie die uitgevoert wordt als de speler tegen het object aanloopt, verandert de snelheid van de speler en maakt de powerup onzichtbaar.
	 */
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject go : collidedGameObjects) {
            if (go instanceof Speler) {
                ((Speler) go).setPowerup(this);	
                //((Speler) go).setSpeed(4);
                setItemIsOpgepakt(true);
                setVisible(false);
            }
        }
    }
	
	/**
	 * Functie voor het ophalen van de powerup naam
	 */
	@Override
	public String powerNaam() {
		return powerNaam;
	}

}
