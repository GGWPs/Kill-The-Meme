package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Vogel extends AnimatedSpriteObject implements IAlarmListener{

	
	private MainGame mainGame;
	private boolean isAnimatie;
	private int totalFramez = 0;
	
	
	/**
	 *  Vogel constructor
	 * 
	 * @param mainGame de wereld
	 */
	public Vogel(MainGame mainGame) {
		 this(new Sprite("src/main/java/nl/han/ica/killthememe/media/twitter-bird-sprite.png"));
		 this.mainGame=mainGame;
		 setCurrentFrameIndex(totalFramez);
	}
	
	/**
	 * 
	 * @param sprite Vogel Sprite
	 */
    private Vogel(Sprite sprite) {
        super(sprite, 4);
        setxSpeed(-1);
    }
    
	/**
	 * functie voor de alarm voor de animatie.
	 */
    public void startAlarm() {
        Alarm alarm=new Alarm("Animatie", 1/0.99f);
        alarm.addTarget(this);
        alarm.start();
    }
    
    
	/**
	 * Zodra de alarm afgaat, wordt deze functie uitgevoerd en wisselt hij een boolean voor de animatie en maakt hij magAanvallen false.
	 * 
	 */
	public void triggerAlarm(String alarmName) {
		isAnimatie = false;
	}
    
	
	/**
	 * Functie die kijkt of de vogel uit het scherm gaat, zodra hij dat doet komt hij weer vanuit een random X positie weer terug aan de rechterkant van de spelers scherm.
	 * Bevat ook een functie voor de animatie van de vogel.
	 */
	@Override
	public void update() {
		  if (getX()+getWidth()<=0) {
	            setX(mainGame.getWidth());
	            setY(mainGame.random(0, mainGame.getHeight()));
	        }
		  if (!isAnimatie) {
			  if(totalFramez == 4) {
				  totalFramez=0;
			  }
			  if(totalFramez < 4) {
				  setCurrentFrameIndex(totalFramez);
				  totalFramez++;
				  isAnimatie = true;
				  startAlarm();
			  }
		  
		  }
	}
	
}
