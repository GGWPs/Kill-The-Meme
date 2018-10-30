package nl.han.ica.killthememe;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

public class BaasA extends Vijand {

	private Sprite projectileSprite = new Sprite(
			"src/main/java/nl/han/ica/killthememe/media/aanvallen/BaasAAanval.png");

	/**
	 * BaasEen constructor
	 * 
	 * @param mainGame de wereld
	 */
	public BaasA(MainGame mainGame, float x, float y) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/BaasA.png"), mainGame, x, y);
	}

	/**
	 * Maakt een Aanval aan die richting de speler gaat
	 */
	@Override
	public void afvuren() {
		if (!magAanvallen) {
			mainGame.speelAfvuurGeluid();
			float richting = getAngleFrom(mainGame.getSpeler());
			projectiel = new VijandAanval(mainGame, projectileSprite, richting, 0.3f);
			mainGame.addGameObject(projectiel, getX() + getWidth() / 2 - 20 / 2 - 16, getY() + getHeight() - 65);
			magAanvallen = true;
			startAlarm();
		}
	}
}
