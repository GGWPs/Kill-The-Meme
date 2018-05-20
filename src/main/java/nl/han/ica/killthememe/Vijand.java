package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class Vijand extends SpriteObject implements IAlarmListener {

	protected Level level;
	protected MainGame mainGame;
	protected Sprite projectileSprite;
	protected float aanvallenPerSeconden;
	protected boolean magAanvallen;
	
	/**
	 * @param sprite de vijand zijn afbeelding
	 * @param mainGame klasse van mainGame
	 * @param aanvallenperSeconden het aantal aanvallen per seconden
	 * 
	 */
	public Vijand(Sprite sprite, MainGame mainGame, float aanvallenPerSeconden) {
		super(sprite);
		this.mainGame = mainGame;
		this.aanvallenPerSeconden = aanvallenPerSeconden;
		this.magAanvallen = false;
		setFriction(0.05f);

	}
	//wordt niet gebruikt
	public void update() {
		
	}

	public void afvuren() {
		
	}
	
	private void initializeSound() {
		
		// bubblePopSound = new Sound(this,
		// "src/main/java/nl/han/ica/waterworld/media/pop.mp3");
	}
	//Functie om alarm te starten voor de aanval van de vijand
	public void startAlarm(){
		Alarm alarm = new Alarm("magAanvallen", 1 / aanvallenPerSeconden);
		alarm.addTarget(this);
		alarm.start();
	}

	@Override
	public void triggerAlarm(String alarmName) {
		magAanvallen = false;
	}

}
