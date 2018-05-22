package nl.han.ica.killthememe;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

/**
 * @author Kaene Peters & Ivan Miladinovic
 * 
 */

public class BaasEen extends Vijand {
	
	private Sprite projectileSprite = new Sprite("src/main/java/nl/han/ica/killthememe/media/aanvallen/BaasEenAanval.png");
	
	/**
	 * BaasEen constructor
	 * 
	 * @param mainGame
	 */
	public BaasEen(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/BaasEenCarlosMatos.png"), mainGame, 0.2f);
	}

	/**
	 * vuurt projectielen af die richting de speler gaan
	 */
	@Override
	public void afvuren() {
		float richting = getAngleFrom(mainGame.getSpeler());
		Aanval projectiel = new VijandAanval(mainGame, projectileSprite, richting,0.4f);
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
