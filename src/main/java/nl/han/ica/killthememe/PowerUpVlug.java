package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpVlug extends PowerUp {


	/**
	 * PowerupVlug constructor
	 * 
	 * @param mainGame
	 *            de wereld
	 */
	public PowerUpVlug(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/powerups/PowerUpVlug.png"), mainGame);
	}

	/**
	 * Functie voor het gebruiken van de powerup, wordt niet gebruikt bij deze
	 * powerup.
	 */
	public void gebruikPowerUp() {
		// Speler.setSpeed(4);
		Speler.speed = 4;
	}

	public void resetPowerUp() {
		System.out.println("Reset PowerUpVlug");
		Speler.speed = 2;
	}

}
