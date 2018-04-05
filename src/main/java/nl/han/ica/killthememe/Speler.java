package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PVector;

public class Speler extends AnimatedSpriteObject implements ICollidableWithTiles, Beweeg, IAlarmListener {
	final int size = 50;
	private int huidigLevel;
	private String naam;
	private char controls;
	private Level level;
	private MainGame mainGame;
	private boolean isAnimatie;
	int totalFramez = 0;
	private Sprite projectileSprite;
	private float aanvallenPerSeconden;
	PowerUp powerup;
	boolean magAanvallen;
	final int speed = 2;
	String naamText = "";

	/**
	 *
	 * @param mainGame
	 */
	public Speler(MainGame mainGame,float aanvallenPerSeconden) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/frisk1.png"), 8);
		this.mainGame = mainGame;
		this.aanvallenPerSeconden = aanvallenPerSeconden;
		this.magAanvallen = false;
		setCurrentFrameIndex(3);
		setFriction(0.10f);

	}

	// dit is zodat de speler niet uit het scherm gaat.
	@Override
	public void update() {
		spelerAfvuren();
		if (getX() <= 0) {
			setxSpeed(0);
			setX(0);
		}
		if (getY() <= 0) {
			setySpeed(0);
			setY(0);
		}
		if (getX() >= mainGame.getWidth() - size) {
			setxSpeed(0);
			setX(mainGame.getWidth() - size);
		}
		if (getY() >= mainGame.getHeight() - size) {
			setySpeed(0);
			setY(mainGame.getHeight() - size);
		}

	}

	public void spelerAfvuren() {
		if (powerup != null && powerup.isItemIsOpgepakt() && mainGame.getCurrentLevel() == 1 &&  !magAanvallen) {
			float richting = getAngleFrom(mainGame.getBaasEen());
			Aanval projectiel = new BaasEenAanval(mainGame, projectileSprite, richting,0.1f);
			mainGame.addGameObject(projectiel, getX() + getWidth() / 2 - Projectiel.WIDTH / 2 - 16,
					getY() + getHeight() - 65);
			magAanvallen = true;
			startAlarmAanval();

		}
	}

	// alarm voor animatie

	void startAlarm() {
		Alarm alarm = new Alarm("Animatie", 1 / 0.95f);
		alarm.addTarget(this);
		alarm.start();
	}

	
	public void triggerAlarm(String alarmName) {
		if (isAnimatie) {
			isAnimatie = false;
		} else if (!isAnimatie) {
			isAnimatie = true;
		}

	}
	/**
	 * alarm voor aantal aanvaller per seconden
	 */
	public void startAlarmAanval() {
		Alarm alarm = new Alarm("magAanvallen", 1 / aanvallenPerSeconden);
		alarm.addTarget(this);
		alarm.start();
	}
	public void triggerAlarmAanval(String alarmName) {
		magAanvallen = false;
	}

	// dit zijn de keybinds van de speler.
	@Override
	public void keyPressed(int keyCode, char key) {
		if (!isAnimatie) {
			totalFramez = 1;
			startAlarm();
		}
		if (isAnimatie) {
			totalFramez = 0;
			startAlarm();
		}
		if (keyCode == mainGame.LEFT || key == 'a') {
			beweegLinks();
		}
		if (keyCode == mainGame.UP || key == 'w') {
			beweegOmhoog();
		}
		if (keyCode == mainGame.RIGHT || key == 'd') {
			beweegRechts();
		}
		if (keyCode == mainGame.DOWN || key == 's') {
			beweegOmlaag();
		}
		if (key == ' ') {
			System.out.println("Spatie!");
		}
		// dit checkt met elke keypress of de speler de level heeft gecleared.
		if (mainGame.levelClear()) {
			mainGame.setCurrentLevel(mainGame.getCurrentLevel() + 1);
			mainGame.setupGame();
		}

	}

	// functie om naar links te bewegen
	public void beweegLinks() {
		// setCurrentFrameIndex(0 + totalFramez);
		beweeg(270, speed, 0 + totalFramez);
	}

	// functie om naar rechts te bewegen
	public void beweegRechts() {
		// setCurrentFrameIndex(6 + totalFramez);
		beweeg(90, speed, 6 + totalFramez);
	}

	// functie omhoog te lopen
	public void beweegOmhoog() {
		// setCurrentFrameIndex(4 + totalFramez);
		beweeg(0, speed, 4 + totalFramez);
	}

	// functie om omlaag te bewegen
	public void beweegOmlaag() {
		// setCurrentFrameIndex(2 + totalFramez);
		beweeg(180, speed, 2 + totalFramez);
	}

	@Override
	public void beweeg(int directionspeed, int speed, int frame) {
		setDirectionSpeed(directionspeed, speed);
		setCurrentFrameIndex(frame);
	}

	// collision
	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		PVector vector;

		for (CollidedTile ct : collidedTiles) {
			if (ct.theTile instanceof BoardsTile) {
				if (ct.collisionSide == ct.TOP) {
					try {
						vector = mainGame.getTileMap().getTilePixelLocation(ct.theTile);
						setY(vector.y - getHeight());
					} catch (TileNotFoundException e) {
						e.printStackTrace();
					}
				}
				if (ct.collisionSide == ct.BOTTOM) {
					try {
						vector = mainGame.getTileMap().getTilePixelLocation(ct.theTile);
						setY(vector.y + getHeight());
					} catch (TileNotFoundException e) {
						e.printStackTrace();
					}
				}
				// if (ct.collisionSide == ct.RIGHT) {
				// try {
				// vector = mainGame.getTileMap().getTilePixelLocation(ct.theTile);
				// mainGame.getTileMap().setTile((int) vector.x / 50, (int) vector.y / 50, -1);
				// } catch (TileNotFoundException e) {
				// e.printStackTrace();
				// }
				if (ct.collisionSide == ct.RIGHT) {
					try {
						vector = mainGame.getTileMap().getTilePixelLocation(ct.theTile);
						setX(vector.x + getHeight());
					} catch (TileNotFoundException e) {
						e.printStackTrace();
					}
				}
				if (ct.collisionSide == ct.LEFT) {
					try {
						vector = mainGame.getTileMap().getTilePixelLocation(ct.theTile);
						setX(vector.x - getHeight());
					} catch (TileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void beweeg(int directionspeed, int speed) {
		// TODO Auto-generated method stub

	}

	public PowerUp getPowerup() {
		return powerup;
	}

	public void setPowerup(PowerUp powerup) {
		this.powerup = powerup;
	}

}
