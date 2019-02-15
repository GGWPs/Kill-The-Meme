package nl.han.ica.killthememe;

import java.net.URL;

import nl.han.ica.OOPDProcessingEngineHAN.alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.objects.SpriteObject;

public class Vogel extends AnimatedSpriteObject implements IAlarmListener {

	private boolean inAnimatie;
	private MainGame mainGame;
	private int totalFramez = 0;
	private static URL vogel = Vogel.class.getResource(
            "/twitter-bird-sprite.png");
	/**
	 * Vogel constructor
	 * 
	 * @param mainGame de wereld
	 */
	public Vogel(MainGame mainGame) {
		this(new Sprite(vogel.toString()));
		this.mainGame = mainGame;
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
		Alarm alarm = new Alarm("Animatie", 1 / 0.99f);
		alarm.addTarget(this);
		alarm.start();
	}

	/**
	 * Zodra de alarm afgaat, wordt deze functie uitgevoerd en wisselt hij een
	 * boolean voor de animatie en maakt hij magAanvallen false.
	 * 
	 */
	public void triggerAlarm(String alarmName) {
		inAnimatie = false;
	}

	/**
	 * Functie die kijkt of de vogel uit het scherm gaat, zodra hij dat doet komt
	 * hij weer vanuit een random X positie weer terug aan de rechterkant van de
	 * spelers scherm. Bevat ook een functie voor de animatie van de vogel.
	 */
	@Override
	public void update() {
		if (getX() + getWidth() <= 0) {
			setX(mainGame.getWidth());
			setY(mainGame.random(0, mainGame.getHeight()));
		}
		if (!inAnimatie) {
			if (totalFramez == 4) {
				totalFramez = 0;
			}
			if (totalFramez < 4) {
				setCurrentFrameIndex(totalFramez);
				totalFramez++;
				inAnimatie = true;
				startAlarm();
			}

		}
	}

}
