package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class Aanval extends SpriteObject {

	protected MainGame mainGame;

	public Aanval(MainGame mainGame, Sprite sprite, float richting, float snelheid) {
		super(sprite);
		this.mainGame = mainGame;
		setDirectionSpeed(richting, snelheid);

	}

	/**
	 * kijkt of de aanval buiten het scherm komt
	 */
	@Override
	public void update() {
		if (mainGame.getX() <= getX()) {
			mainGame.deleteGameObject(this);
		}

	}
}
