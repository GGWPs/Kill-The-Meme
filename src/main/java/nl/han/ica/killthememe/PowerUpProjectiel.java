package nl.han.ica.killthememe;

import java.net.URL;

import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

public class PowerUpProjectiel extends PowerUp {
	private static URL url = PowerUpProjectiel.class.getResource(
            "/powerups/PowerUpProjectiel.png");
	/**
	 * PowerUpProjectiel constructor
	 * 
	 * @param mainGame de wereld
	 *            
	 */
	public PowerUpProjectiel(MainGame mainGame) {
		super(new Sprite(url.toString()), mainGame);
	}

	/**
	 * Functie die een projectiel afvuurt zodra de speler een powerup heeft opgepakt
	 * en op spatie drukt.
	 */
	public void gebruikPowerUp(Speler speler) {
		Aanval projectiel = new SpelerAanval(mainGame, projectileSprite, speler.getRichting(), 0.9f);
		mainGame.addGameObject(projectiel, mainGame.getSpelerX(),
				mainGame.getSpelerY());
	}
	
	/**
	 * Functie voor het resetten van de powerup.
	 * 
	 */
	public void resetPowerUp(Speler speler) {
		speler.setPowerup(null);
	}
	
}
