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
	protected int leven;
	
	/**
	 * Vijand constructor
	 * 
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
