package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpProjectiel extends PowerUp {

	/**
	 * PowerupProjectiel constructor
	 * 
	 * @param mainGame
	 *            De wereld
	 */
	public PowerUpProjectiel(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/powerups/PowerUpProjectiel.png"), mainGame);
	}

	/**
	 * Functie die een projectiel afvuurt zodra de speler een powerup heeft opgepakt
	 * en op spatie drukt.
	 */
	public void gebruikPowerUp(Speler speler) {
		aanval = true;
	}

}
