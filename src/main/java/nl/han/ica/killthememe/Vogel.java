package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Vogel extends AnimatedSpriteObject implements IAlarmListener{

	
	private MainGame mainGame;
	protected boolean isAnimatie;
	int totalFramez = 0;
	
	
	/**
	 * 
	 * @param mainGame
	 */
	public Vogel(MainGame mainGame) {
		 this(new Sprite("src/main/java/nl/han/ica/killthememe/media/twitter-bird-sprite.png"));
		 this.mainGame=mainGame;
		 setCurrentFrameIndex(totalFramez);
	}
	
    private Vogel(Sprite sprite) {
        super(sprite, 4);
        setxSpeed(-1);
    }

	void aanval() {
		
	}
	
	void beweeg() {
		
	}
    void startAlarm() {
        Alarm alarm=new Alarm("Animatie", 1/0.99f);
        alarm.addTarget(this);
        alarm.start();
    }
    
	public void triggerAlarm(String alarmName) {
		isAnimatie = false;
	}
    
	@Override
	public void update() {
		//zodra de vogel uit het scherm is, komt hij uit een random positie weer terug
		  if (getX()+getWidth()<=0) {
	            setX(mainGame.getWidth());
	            setY(mainGame.random(0, mainGame.getHeight()));
	        }
		  //als de alarm af gaat, doet hij de volgende frame
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
