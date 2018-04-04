package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class BaasEen extends Vijand {
	private Sprite projectileSprite;

	/**
	 * BaasEen constructor
	 * 
	 * @param mainGame
	 */
	public BaasEen(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/marge.png"), mainGame, 5);
		projectileSprite = new Sprite("src/main/java/nl/han/ica/killthememe/media/BossEenAanval.png");

	}

	/**
	 * vuurt projectielen af
	 */
	@Override
	public void afvuren() {
		Projectiel projectiel = new Projectiel(mainGame, projectileSprite, 1000, 3);
		mainGame.addGameObject(projectiel, 200 - Projectiel.WIDTH, 200);
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
