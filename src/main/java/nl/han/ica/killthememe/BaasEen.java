package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
/**
 * @author Kaene Peters
 * 
 */

public class BaasEen extends Vijand {
	private Sprite projectileSprite;

	/**
	 * BaasEen constructor
	 * 
	 * @param mainGame
	 */
	public BaasEen(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/BossEenCarlosMatos.png"), mainGame, 0.3f);
		projectileSprite = new Sprite("src/main/java/nl/han/ica/killthememe/media/BossEenAanval.png");

	}

	/**
	 * vuurt projectielen af
	 */
	@Override
	public void afvuren() {
		float richting = getAngleFrom(mainGame.getSpeler());
		Aanval projectiel = new Projectiel(mainGame, projectileSprite,richting);
		mainGame.addGameObject(projectiel,getX() + getWidth() / 2 - Projectiel.WIDTH / 2 - 16, getY() + getHeight()-65);


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
