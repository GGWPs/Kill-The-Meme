package nl.han.ica.killthememe;




import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class Vijand extends SpriteObject{
	
	protected Level level;
	protected MainGame mainGame;
	protected Sprite projectileSprite;

	
	/**
	 * 
	 * @param mainGame
	 */
	public Vijand( Sprite sprite, MainGame mainGame) {
		 super(new Sprite("src/main/java/nl/han/ica/killthememe/media/marge.png"));
	     this.mainGame = mainGame;
	

    }

    @Override
    public void update() {
        if (getX()+getWidth()<=0) {
            setX(mainGame.getWidth());
        }

    }

	public abstract void afvuren();

		
	
}


