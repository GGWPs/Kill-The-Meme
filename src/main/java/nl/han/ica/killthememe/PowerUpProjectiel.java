package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpProjectiel extends PowerUp {

	Sprite projectileSprite;

	public PowerUpProjectiel(MainGame mainGame, String powerUpNaam) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/PowerUpCopyAttack.png"), mainGame, powerUpNaam);
	}
	
	//dit vuurt een projectiel af zodra de speler een powerup heeft.
	public void gebruikPowerUp() {
			float richting = getAngleFrom(mainGame.getBaasTwee());
			Aanval projectiel = new SpelerEenAanval(mainGame, projectileSprite, richting, 0.7f);
			mainGame.addGameObject(projectiel, mainGame.getSpelerX() + getWidth() / 2 - Projectiel.WIDTH / 2 - 10,
			mainGame.getSpelerY() + getHeight() - 10);
			startAlarmAanval();
	}

}
