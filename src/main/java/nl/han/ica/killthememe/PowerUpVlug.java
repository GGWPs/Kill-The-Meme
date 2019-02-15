package nl.han.ica.killthememe;

import java.net.URL;

import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

public class PowerUpVlug extends PowerUp {

	private static URL url = PowerUpVlug.class.getResource(
            "/powerups/PowerUpVlug.png");
	/**
	 * PowerUpVlug constructor
	 * 
	 * @param mainGame de wereld
	 *           
	 */
	public PowerUpVlug(MainGame mainGame) {
		super(new Sprite(url.toString()), mainGame);
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
