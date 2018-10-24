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
	public void gebruikPowerUp(Speler speler) {
		//speler.speed = 4;
		System.out.println("Setspeed4");
		speler.setSpeed(4);
	}
	
	
	/*
	 * Functie om de powerups van de speler te resetten.
	 */
	public void resetPowerUp(Speler speler) {
		speler.setSpeed(2);
	}

}
