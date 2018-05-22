package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpProjectiel extends PowerUp {

	Sprite projectileSprite;
	String powerNaam = "Projectiel";
	
	
	/**
	 * PowerupProjectiel constructor
	 * 
	 * @param mainGame De wereld
	 */
	public PowerUpProjectiel(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/powerups/PowerUpCopyAttack.png"), mainGame);
	}

	/**
	 * Functie die een projectiel afvuurt zodra de speler een powerup heeft opgepakt en op spatie drukt.
	 */
	public void gebruikPowerUp(float richting) {
		if (isItemIsOpgepakt()) {
			Aanval projectiel = new SpelerEenAanval(mainGame, projectileSprite, richting, 0.9f);
			mainGame.addGameObject(projectiel, mainGame.getSpelerX() + getWidth() / 2 - Projectiel.WIDTH / 2 - 10,
					mainGame.getSpelerY() + getHeight() - 10);

		}
	}
	
	/**
	 * Functie voor het ophalen van de powerup naam
	 */
	@Override
	public String powerNaam() {
		return powerNaam;
	}

}
