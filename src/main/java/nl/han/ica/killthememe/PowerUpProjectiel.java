package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpProjectiel extends PowerUp {

	Sprite projectileSprite;
	String powerNaam = "Projectiel";

	public PowerUpProjectiel(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/PowerUpCopyAttack.png"), mainGame);
	}

	// dit vuurt een projectiel af zodra de speler een powerup heeft.
	public void gebruikPowerUp(float richting) {
		if (isItemIsOpgepakt()) {
			Aanval projectiel = new SpelerEenAanval(mainGame, projectileSprite, richting, 0.7f);
			mainGame.addGameObject(projectiel, mainGame.getSpelerX() + getWidth() / 2 - Projectiel.WIDTH / 2 - 10,
					mainGame.getSpelerY() + getHeight() - 10);

		}
	}

}
