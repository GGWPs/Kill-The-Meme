package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Vijand extends SpriteObject{
	
	private Level level;
	private MainGame mainGame;
	
	
	public Vijand(MainGame mainGame) {
		 this(new Sprite("src/main/java/nl/han/ica/killthememe/media/sprite1.png"));
	     this.mainGame=mainGame;
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
