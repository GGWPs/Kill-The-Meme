package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Vogel  extends AnimatedSpriteObject {

	
	private MainGame mainGame;
	
	
	public Vogel(MainGame mainGame) {
		 this(new Sprite("src/main/java/nl/han/ica/killthememe/media/twitter-bird-sprite.png"));
		 this.mainGame=mainGame;
	}
	
    private Vogel(Sprite sprite) {
        super(sprite, 2);
        setxSpeed(-1);
    }

	void aanval() {
		
	}
	
	void beweeg() {
		
	}

	@Override
	public void update() {
		  if (getX()+getWidth()<=0) {
	            setX(mainGame.getWidth());
	            for(int i = 1; i < 5; i++) {
	            setCurrentFrameIndex(i);
	            }
	            
	        }
	}
	
}
