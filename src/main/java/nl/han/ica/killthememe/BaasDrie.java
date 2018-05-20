package nl.han.ica.killthememe;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

/**
 * @author Kaene Peters & Ivan Miladinovic
 * 
 */

public class BaasDrie extends Vijand {

	/**
	 * BaasEen constructor
	 * 
	 * @param mainGame
	 */
	public BaasDrie(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/harambeboss.png"), mainGame, 0.2f);

	}

	/**
	 * vuurt projectielen af
	 */
	@Override
	public void afvuren() {
		Random r = new Random();
		float richting = getAngleFrom(mainGame.getSpeler());
		Aanval projectiel = new BaasTweeAanval(mainGame, projectileSprite, richting,r.nextFloat());
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
		}
	}

}
