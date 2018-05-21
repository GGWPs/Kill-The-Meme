package nl.han.ica.killthememe;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

/**
 * @author Kaene Peters & Ivan Miladinovic
 * 
 */

public class BaasDrie extends Vijand {
	
	private Sprite projectileSprite = new Sprite("src/main/java/nl/han/ica/killthememe/media/aanvallen/BaasDrieAanval.png");
	
	int speciaalAanval = 0;
	double aanvalSnelheid = 1.5;
	/**
	 * BaasEen constructor
	 * 
	 * @param mainGame
	 */
	public BaasDrie(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/BaasDrie.png"), mainGame, 0.2f);

	}

	/**
	 * vuurt projectielen af
	 */
	@Override
	public void afvuren() {
		float richting = getAngleFrom(mainGame.getSpeler());
		Aanval projectiel = new VijandAanval(mainGame, projectileSprite, richting,0.7f);
		mainGame.addGameObject(projectiel, getX() + getWidth() / 2 - Projectiel.WIDTH / 2 - 16,
				getY() + getHeight() - 65);
	}

	/**
	 * kijkt of er aangevallen mag worden
	 */
	@Override
	public void update() {
		if (!magAanvallen) {
			afvuren();
			magAanvallen = true;
			startAlarm();
			speciaalAanval++;
			if(speciaalAanval >= 4 && speciaalAanval <= 7) {
				aanvalSnelheid = 0.2;
			} else if (speciaalAanval >= 7) {
				aanvalSnelheid = 1.1;
			}
			
		}
	}
	
	//Functie om alarm te starten voor de aanval van de vijand
	@Override
	public void startAlarm(){
		Random r = new Random();
		Alarm alarm = new Alarm("magAanvallen", aanvalSnelheid+r.nextFloat());
		alarm.addTarget(this);
		alarm.start();
	}
	//Functie die automatisch wordt uitgevoerd zodra de alarm afgaat.
	@Override
	public void triggerAlarm(String alarmName) {
		magAanvallen = false;
	}

}
