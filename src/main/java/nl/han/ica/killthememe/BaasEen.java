package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

/**
 * @author Kaene Peters
 * 
 */

public class BaasEen extends Vijand {

	/**
	 * BaasEen constructor
	 * 
	 * @param mainGame
	 */
	public BaasEen(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/BossEenCarlosMatos.png"), mainGame, 0.3f);

	}

	/**
	 * vuurt projectielen af
	 */
	@Override
	public void afvuren() {
		float richting = getAngleFrom(mainGame.getSpeler());
		Aanval projectiel = new BaasEenAanval(mainGame, projectileSprite, richting,0.25f);
		mainGame.addGameObject(projectiel, getX() + getWidth() / 2 - Projectiel.WIDTH / 2 - 16,
				getY() + getHeight() - 65);
	}

	/**
	 * kijkt of er aangevallen mag worden
	 */
	public void update() {
		if (!magAanvallen) {
			afvuren();
			magAanvallen = true;
			startAlarm();
		}
	}

}
