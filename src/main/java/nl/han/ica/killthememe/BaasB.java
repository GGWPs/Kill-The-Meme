package nl.han.ica.killthememe;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;


public class BaasB extends Vijand {

	private Sprite projectileSprite = new Sprite(
			"src/main/java/nl/han/ica/killthememe/media/aanvallen/BaasBAanval.png");
	private int leven = 3;

	/**
	 * BaasTwee constructor
	 * 
	 * @param mainGame
	 */
	public BaasB(MainGame mainGame, float x, float y) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/BaasB.png"), mainGame, x, y);
	}

	/**
	 * Maakt een Aanval object aan die richting de speler gaat
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
	 * kijkt of de vijand nog levens heeft
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
