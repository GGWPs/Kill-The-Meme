package nl.han.ica.killthememe;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;


public class BaasC extends Vijand {
	
	private Sprite projectileSprite = new Sprite("src/main/java/nl/han/ica/killthememe/media/aanvallen/BaasCAanval.png");
	private int speciaalAanval = 0;
	private double aanvalSnelheid = 1.5;
	
	/**
	 * BaasDrie constructor
	 * 
	 * @param mainGame de wereld.
	 */
	public BaasC(MainGame mainGame, float x, float y) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/BaasC.png"), mainGame, x, y);

	}

	/**
	 * Maakt een Aanval aan die richting de speler gaat met de mogelijkheid voor een speciale aanval
	 */
	@Override
	public void afvuren() {
		if (!magAanvallen) {
			Random r = new Random();
			float richting = getAngleFrom(mainGame.getSpeler());
			Aanval projectiel = new VijandAanval(mainGame, projectileSprite, richting,r.nextFloat());
			mainGame.addGameObject(projectiel, getX() + getWidth() / 2 - 20 / 2 - 16,
					getY() + getHeight() - 65);
			magAanvallen = true;
			startAlarm();
			speciaalAanval++;
			if(speciaalAanval >= 4 && speciaalAanval <= 7) {
				aanvalSnelheid = 0.2;
			} else if (speciaalAanval >= 7) {
				aanvalSnelheid = 1.1;
				speciaalAanval = 0;
			}
		}
	}

	
	/**
	 * Functie om alarm te starten voor de random aanval van het object.
	 * 
	 */
	@Override
	public void startAlarm(){
		Random r = new Random();
		Alarm alarm = new Alarm("magAanvallen", aanvalSnelheid+r.nextFloat());
		alarm.addTarget(this);
		alarm.start();
	}
	/**
	 * Functie die automatisch wordt uitgevoerd zodra de alarm afgaat.
	 */
	@Override
	public void triggerAlarm(String alarmName) {
		magAanvallen = false;
	}

}
