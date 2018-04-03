package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Vogel  extends AnimatedSpriteObject {

	
	private MainGame mainGame;
	
	
	
	/**
	 * 
	 * @param mainGame
	 */
	public Vogel(MainGame mainGame) {
		 super(new Sprite("src/main/java/nl/han/ica/killthememe/media/twitter-bird-sprite.png"), 4);
		 this.mainGame=mainGame;
		 setCurrentFrameIndex(1);
	}
	
//    private Vogel(Sprite sprite) {
//        super(sprite, 4);
//        setxSpeed(-1);
//    }

	void aanval() {
		
	}
	
	void beweeg() {
		
	}

	@Override
	public void update() {
		  if (getX()+getWidth()<=0) {
	            setX(mainGame.getWidth());
	        }
	}
	
}
