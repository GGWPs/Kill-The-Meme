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
	 * @param mainGame de wereld
	 */
	public BaasEen(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/BaasEenCarlosMatos.png"), mainGame, 0.2f);
		this.mainGame = mainGame;
	}

	/**
	 * vuurt projectielen af die richting de speler gaan
	 */
	@Override
	public void afvuren() {
		if (!magAanvallen) {
			float richting = getAngleFrom(mainGame.getSpeler());
			Aanval projectiel = new VijandAanval(mainGame, projectileSprite, richting,0.3f);
			mainGame.addGameObject(projectiel, getX() + getWidth() / 2 - Projectiel.WIDTH / 2 - 16,
					getY() + getHeight() - 65);
			magAanvallen = true;
			startAlarm();
		}

	}


}
