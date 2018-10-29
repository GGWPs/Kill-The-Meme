	package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.sound.Sound;

public class Vijand extends SpriteObject implements IAlarmListener {
	protected float aanvallenPerSeconden = 0.2f;
	protected Level level;
	protected int leven;
	protected boolean magAanvallen;
	protected MainGame mainGame;
	protected Sprite projectileSprite;
	protected float x;
	protected float y;
	
	/**
	 * Vijand constructor
	 * 
	 * @param sprite de vijand zijn afbeelding
	 * @param mainGame klasse van mainGame
	 * @param aanvallenperSeconden het aantal aanvallen per seconden
	 * 
	 */
	public Vijand(Sprite sprite, MainGame mainGame, float x, float y) {
		super(sprite);
		this.mainGame = mainGame;
		this.magAanvallen = false;
		this.x = x;
		this.y = y;
		setFriction(0.05f);

	}
	
	public void update() {
		
	}
	
	/**
	 * Basis functie voor het afvuren van projectielen richting de speler.
	 */
	public void afvuren() {
		
	}
	
	/**
	 * Functie om een alarm te starten voor de vijand zodat hij alleen aanvalt wanneer de alarm is afgelopen.
	 */
	public void startAlarm(){
		Alarm alarm = new Alarm("magAanvallen", 1 / aanvallenPerSeconden);
		alarm.addTarget(this);
		alarm.start();
	}
	
	/** 
	 * Functie die wordt uitgevoerd zodra de alarm afgaat.
	 */
	@Override
	public void triggerAlarm(String alarmName) {
		magAanvallen = false;
	}
	/**
	 * Basis functie voor het verliezen van levens bij de vijand.
	 */
	public void verliesLeven() {
		
	}
}
