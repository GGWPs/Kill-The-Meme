package nl.han.ica.killthememe;


import java.awt.image.BufferedImage;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Vijand extends SpriteObject{
	
	private Level level;
	private MainGame mainGame;
	private Sprite projectileSprite;

	
	
	public Vijand(MainGame mainGame) {
		 this(new Sprite("src/main/java/nl/han/ica/killthememe/media/sprite1.png"));
	     this.mainGame=mainGame;
	     projectileSprite = new Sprite();

	}
	public void afschieten() {
		float direction = getAngleFrom(mainGame.getVijand());
		Aanval aanval = new Aanval(mainGame, projectileSprite, direction, 10, true, 8);
		mainGame.addGameObject(Aanval, getX() + getWidth() / 2 - Aanval.WIDTH / 2, getY() + getHeight());
	}
	
 	
    private Vijand(Sprite sprite) {
        super(sprite);
        setxSpeed(-1);
    }

    @Override
    public void update() {
        if (getX()+getWidth()<=0) {
            setX(mainGame.getWidth());
        }

    }
}


