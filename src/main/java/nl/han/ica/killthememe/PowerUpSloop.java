package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

public class PowerUpSloop extends PowerUp {


	/**
	 * PowerUpSloop constructor
	 * 
	 * @param mainGame de wereld
	 *            
	 */
	public PowerUpSloop(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/powerups/PowerUpSloop.png"), mainGame);
	}

	/**
	 * Functie voor het gebruiken van de powerup
	 * 
	 */
	public void gebruikPowerUp(Speler speler) {
		sloop = true;
	}
	
	/**
	 * Functie voor het resetten van de powerup.
	 * 
	 */
	public void resetPowerUp(Speler speler) {
		sloop = false;
		speler.setPowerup(null);
	}
}
