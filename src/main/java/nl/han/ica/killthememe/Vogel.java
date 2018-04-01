package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Vogel extends SpriteObject {

	
	private Level level;
	
	
	public Vogel(Level level) {
		 this(new Sprite("src/main/java/nl/han/ica/killthememe/media/vogel 1.png"));
		 this.level=level;
	}
	
    private Vogel(Sprite sprite) {
        super(sprite);
        setxSpeed(-1);
    }

	void aanval() {
		
	}
	
	void beweeg() {
		
	}

	@Override
	public void update() {
		  if (getX()+getWidth()<=0) {
	            setX(level.getWidth());
	        }
	}
	
}
