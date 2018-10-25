package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

public class PowerUpLeven extends PowerUp {
	
	private boolean gebruikt;
	
	/**
	 * PowerUpProjectiel constructor
	 * 
	 * @param mainGame de wereld
	 *            
	 */
	public PowerUpLeven(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/powerups/PowerUpProjectiel.png"), mainGame);
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
