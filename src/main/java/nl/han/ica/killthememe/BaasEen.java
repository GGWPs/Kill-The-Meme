package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class BaasEen extends Vijand{
	private Sprite projectileSprite;
	
	
	public BaasEen(MainGame mainGame) {
		 super(new Sprite("src/main/java/nl/han/ica/killthememe/media/sprite1.png"), mainGame);

	     projectileSprite = new Sprite("src/main/java/nl/han/ica/killthememe/media/BossEenAanval.png");

	}
	@Override
	public void afvuren() {
		Aanval projectiel = new Projectiel(mainGame, projectileSprite);
		mainGame.addGameObject(projectiel,200,200);
	}
	@Override
	public void update() {
		afvuren();
	}
}
