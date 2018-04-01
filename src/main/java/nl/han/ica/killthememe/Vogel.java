package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Vogel extends SpriteObject {

	
	private Level level;
	
	
	public Vogel(Sprite sprite) {
		 this(new Sprite("src/main/java/nl/han/ica/killthememe/media/vogel 1.png"));
		 this.level=level;
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
