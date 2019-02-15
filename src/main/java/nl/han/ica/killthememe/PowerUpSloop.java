package nl.han.ica.killthememe;

import java.net.URL;

import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

public class PowerUpSloop extends PowerUp {
	private static URL url = PowerUpSloop.class.getResource(
            "/powerups/PowerUpSloop.png");
	/**
	 * PowerUpSloop constructor
	 * 
	 * @param mainGame de wereld
	 * 
	 */
	public PowerUpSloop(MainGame mainGame) {
		super(new Sprite(url.toString()), mainGame);
	}

	/**
	 * Methode voor het gebruiken van de powerup
	 * 
	 */
	public void gebruikPowerUp(Speler speler) {
		sloop = true;
		if (speler.getVector() != null) {
			mainGame.getTileMap().setTile((int) speler.getVector().x / 50, (int) speler.getVector().y / 50, -1);
		}
	}

	/**
	 * Methode voor het resetten van de powerup.
	 * 
	 */
	public void resetPowerUp(Speler speler) {
		sloop = false;
		speler.setPowerup(null);
	}
}
