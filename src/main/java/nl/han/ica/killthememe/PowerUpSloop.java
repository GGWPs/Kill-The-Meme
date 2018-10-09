package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpSloop extends PowerUp {


	/**
	 * PowerupSloop constructor
	 * 
	 * @param mainGame
	 *            de wereld
	 */
	public PowerUpSloop(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/powerups/PowerUpSloop.png"), mainGame);
	}

	/**
	 * Functie voor het gebruiken van de powerup, wordt niet gebruikt bij deze
	 * powerup.
	 */
	public void gebruikPowerUp() {
		Speler.sloop = true;
	}

	public void resetPowerUp() {
		System.out.println("Reset PowerUpSloop");
		Speler.sloop = false;

	}
}
