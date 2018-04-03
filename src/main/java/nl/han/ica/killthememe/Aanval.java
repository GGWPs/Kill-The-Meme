package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class Aanval extends SpriteObject{

	protected MainGame mainGame;
	
	
	
	public Aanval(MainGame mainGame, Sprite sprite, float richting, float snelheid) {
		super(sprite);
		this.mainGame = mainGame;
		setDirectionSpeed(richting,snelheid);
		
	}
@Override
	public void update() {
		if (getY() < 0 || getY() > mainGame.getHeight() || getX() < 0 || getX() > mainGame.getWidth()) {
			mainGame.deleteGameObject(this);
		}
	}


}
