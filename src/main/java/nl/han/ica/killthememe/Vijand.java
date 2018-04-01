package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Vijand extends SpriteObject{
	
	private Level level;
	
	
	public Vijand(Level level) {
		 this(new Sprite("src/main/java/nl/han/ica/waterworld/media/swordfish.png"));
	     this.level=level;
	}
	
    private Vijand(Sprite sprite) {
        super(sprite);
        setxSpeed(-1);
    }
}
