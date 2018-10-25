package nl.han.ica.killthememe;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

/**
 * @author Ivan Miladinovic
 * 
 */

public class BaasB extends Vijand {

	private Sprite projectileSprite = new Sprite(
			"src/main/java/nl/han/ica/killthememe/media/aanvallen/BaasTweeAanval.png");
	private int leven = 3;

	/**
	 * BaasTwee constructor
	 * 
	 * @param mainGame
	 */
	public BaasB(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/harambeboss.png"), mainGame, 0.2f);

	}

	/**
	 * vuurt projectielen af die richting de speler gaan
	 */
	@Override
	public void afvuren() {
		if (!magAanvallen) {
			Random r = new Random();
			float richting = getAngleFrom(mainGame.getSpeler());
			Aanval projectiel = new VijandAanval(mainGame, projectileSprite, richting, r.nextFloat());
			mainGame.addGameObject(projectiel, getX() + getWidth() / 2 - 20 / 2 - 16, getY() + getHeight() - 65);
			magAanvallen = true;
			startAlarm();
		}

	}

	/**
	 * kijkt of er aangevallen mag worden
	 */
	@Override
	public void update() {
		if (leven <= 0) {
			mainGame.deleteGameObject(this);
			mainGame.bossVerslagen();
		}
	}

	/**
	 * Functie voor het verliezen van levens bij de vijand.
	 */
	public void verliesLeven() {
		leven--;
	}

}
