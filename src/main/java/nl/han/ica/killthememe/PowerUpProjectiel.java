package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpProjectiel extends PowerUp {

	private Sprite projectileSprite;

	/**
	 * PowerupProjectiel constructor
	 * 
	 * @param mainGame
	 *            De wereld
	 */
	public PowerUpProjectiel(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/powerups/PowerUpCopyAttack.png"), mainGame);
	}

	/**
	 * Functie die een projectiel afvuurt zodra de speler een powerup heeft opgepakt
	 * en op spatie drukt.
	 */
	public void gebruikPowerUp() {
		Speler.powerUpAanval = true;
	}

	public void resetPowerUp() {
		System.out.println("Reset PowerUpProjectiel");
		Speler.powerUpAanval = false;
	}
}
