package nl.han.ica.killthememe;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

/**
 * @author Ivan Miladinovic
 * 
 */

public class BaasC extends Vijand {
	
	private Sprite projectileSprite = new Sprite("src/main/java/nl/han/ica/killthememe/media/aanvallen/BaasDrieAanval.png");
	private int speciaalAanval = 0;
	private double aanvalSnelheid = 1.5;
	
	/**
	 * BaasDrie constructor
	 * 
	 * @param mainGame de wereld.
	 */
	public BaasC(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/BaasDrie.png"), mainGame, 0.2f);

	}

	/**
	 * vuurt projectielen af die richting de speler gaan
	 */
	@Override
	public void afvuren() {
		if (!magAanvallen) {
			Random r = new Random();
			float richting = getAngleFrom(mainGame.getSpeler());
			Aanval projectiel = new VijandAanval(mainGame, projectileSprite, richting,r.nextFloat());
			mainGame.addGameObject(projectiel, getX() + getWidth() / 2 - Projectiel.WIDTH / 2 - 16,
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