package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

public class PowerUpProjectiel extends PowerUp {
	
	/**
	 * PowerUpProjectiel constructor
	 * 
	 * @param mainGame de wereld
	 *            
	 */
	public PowerUpProjectiel(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/powerups/PowerUpProjectiel.png"), mainGame);
	}

	/**
	 * Functie die een projectiel afvuurt zodra de speler een powerup heeft opgepakt
	 * en op spatie drukt.
	 */
	public void gebruikPowerUp(Speler speler) {
		Aanval projectiel = new SpelerEenAanval(mainGame, projectileSprite, speler.richting, 0.9f);
		mainGame.addGameObject(projectiel, mainGame.getSpelerX(),
				mainGame.getSpelerY());
	}
}
