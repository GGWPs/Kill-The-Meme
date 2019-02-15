package nl.han.ica.killthememe;

import java.net.URL;

import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

public class PowerUpLeven extends PowerUp {
	
	private boolean gebruikt;
	private static URL url = PowerUpLeven.class.getResource(
            "/powerups/PowerUpProjectiel.png");
	/**
	 * PowerUpProjectiel constructor
	 * 
	 * @param mainGame de wereld
	 *            
	 */
	public PowerUpLeven(MainGame mainGame) {
		super(new Sprite(url.toString()), mainGame);
	}


	/**
	 * Functie voor het gebruiken van de powerup
	 * 
	 */
	public void gebruikPowerUp(Speler speler) {
		if(!gebruikt) {
			speler.setLeven(2);
			gebruikt = true;
		}
	}
}
