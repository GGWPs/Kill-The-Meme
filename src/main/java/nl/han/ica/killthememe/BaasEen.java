package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class BaasEen {
	private Sprite projectileSprite;
	private MainGame mainGame;
	
	
	public BaasEen(MainGame mainGame) {
		 this(new Sprite("src/main/java/nl/han/ica/killthememe/media/sprite1.png"));
	     this.mainGame=mainGame;
	     projectileSprite = new Sprite("src/main/java/nl/han/ica/killthememe/media/sprite1.png");

	}
	public void afschieten() {
		float direction = getAngleFrom(mainGame.getVijand());
		Aanval aanval = new Aanval(mainGame, projectileSprite, direction, 10, true, 8);
		mainGame.addGameObject(aanval, getX() + getWidth() / 2 - Aanval.WIDTH / 2, getY() + getHeight());
	}
	
}
