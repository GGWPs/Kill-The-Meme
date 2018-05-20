package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

/**
 * @author Kaene Peters & Ivan Miladinovic
 * 
 */

public class BaasTwee extends Vijand {

	/**
	 * BaasEen constructor
	 * 
	 * @param mainGame
	 */
	public BaasTwee(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/harambeboss.png"), mainGame, 0.2f);

	}

	/**
	 * vuurt projectielen af
	 */
	@Override
	public void afvuren() {
		float richting = getAngleFrom(mainGame.getSpeler());
		Aanval projectiel = new BaasTweeAanval(mainGame, projectileSprite, richting,0.4f);
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
