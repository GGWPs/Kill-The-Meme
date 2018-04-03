package nl.han.ica.killthememe;


import java.awt.image.BufferedImage;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Vijand extends SpriteObject{
	
	protected Level level;
	protected MainGame mainGame;
	protected Sprite projectileSprite;

	
	/**
	 * 
	 * @param mainGame
	 */
	public Vijand(MainGame mainGame) {
		 this(new Sprite("src/main/java/nl/han/ica/killthememe/media/marge.png"));
	     this.mainGame=mainGame;
	
//	public Vijand(Sprite sprite, MainGame mainGame) {
//	    super(sprite);
//		this.mainGame=mainGame;

	}

//	public abstract void afvuren();

	
 	
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


