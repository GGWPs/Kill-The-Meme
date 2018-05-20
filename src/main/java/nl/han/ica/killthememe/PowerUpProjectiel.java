package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpProjectiel extends PowerUp {

	private MainGame mainGame;
	boolean magAanvallen;
	private Sprite projectileSprite;

	public PowerUpProjectiel(MainGame mainGame, String powerUpNaam) {
		super(mainGame, powerUpNaam);
		(this).magAanvallen = false;
	}
	
	//dit vuurt een projectiel af zodra de speler een powerup heeft.
	public void spelerAfvuren() {
		if (isItemIsOpgepakt() && !magAanvallen) {
			float richting = getAngleFrom(mainGame.getBaasEen());
			Aanval projectiel = new SpelerEenAanval(mainGame, projectileSprite, richting, 0.3f);
			mainGame.addGameObject(projectiel, mainGame.getSpelerX() + getWidth() / 2 - Projectiel.WIDTH / 2 - 10,
					mainGame.getSpelerY() + getHeight() - 10);
			magAanvallen = true;
			startAlarmAanval();
			System.out.print("spelerAfvuren");
		}
	}
	
	public void triggerAlarm(String alarmName) {
		if (alarmName == "magAanvallen") {

			magAanvallen = false;

		}
	}
	
	/**
	 * Functie om alarm te starten voor de aanval van de speler.
	 */
	public void startAlarmAanval() {
		Alarm alarm = new Alarm("magAanvallen", 1 / 6);
		alarm.addTarget(this);
		alarm.start();

	}	
}
