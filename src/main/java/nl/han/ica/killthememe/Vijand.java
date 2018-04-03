package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class Vijand extends SpriteObject implements IAlarmListener {

	protected Level level;
	protected MainGame mainGame;
	protected Sprite projectileSprite;
	protected float aanvallenPerSeconden;
	protected boolean magAanvallen;

	/**
	 * 
	 * @param mainGame
	 */
	public Vijand(Sprite sprite, MainGame mainGame, float aanvallenPerSeconden) {
		super(sprite);
		this.mainGame = mainGame;
		this.aanvallenPerSeconden = aanvallenPerSeconden;
		this.magAanvallen = false;
		setFriction(0.05f);
 
	}

	public void update() {

	}

	public abstract void afvuren();

	protected void startAlarm() {
		Alarm alarm = new Alarm("magAanvallen", 1 / aanvallenPerSeconden);
		alarm.addTarget(this);
		alarm.start();
	}

	@Override
	public void triggerAlarm(String alarmName) {
		magAanvallen = false;
	}

}
