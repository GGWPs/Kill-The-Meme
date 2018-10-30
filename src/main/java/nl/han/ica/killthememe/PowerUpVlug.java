package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

public class PowerUpVlug extends PowerUp {


	/**
	 * PowerUpVlug constructor
	 * 
	 * @param mainGame de wereld
	 *           
	 */
	public PowerUpVlug(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/powerups/PowerUpVlug.png"), mainGame);
	}

	/**
	 * Functie voor het gebruiken van de powerup, hiermee wordt de snelheid van de speler verhoogt
	 * 
	 */
	public void gebruikPowerUp(Speler speler) {
		speler.setSpeed(4);
	}
	/**
	 * Functie voor het resetten van de powerup.
	 * 
	 */
	public void resetPowerUp(Speler speler) {
		speler.setSpeed(2);
		speler.setPowerup(null);
	}
}
