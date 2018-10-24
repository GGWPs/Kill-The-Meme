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

public class Speler extends AnimatedSpriteObject implements ICollidableWithTiles, IAlarmListener {

	private MainGame mainGame;
	private boolean isAnimatie;
	private float aanvallenPerSeconden;
	private PowerUp powerup;
	public int speed = 2;
	public boolean sloop;
	public boolean magAanvallen;
	public boolean powerUpAanval;
	private Sprite projectileSprite;
	private final int size = 50;
	private int totalFramez = 0;

	/**
	 * Speler constructor
	 * 
	 * @param mainGame
	 *            de wereld
	 * @param aanvallenPerSeconden
	 *            aanvallen per seconde
	 */
	public Speler(MainGame mainGame, float aanvallenPerSeconden) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/frisk1.png"), 8);
		this.mainGame = mainGame;
		this.aanvallenPerSeconden = aanvallenPerSeconden;
		this.magAanvallen = false;
		setCurrentFrameIndex(3);
		setFriction(0.10f);
	}

	/**
	 * Functie die kijkt op de speler uit de scherm probeert te lopen en hem stopt
	 * als hij dat doet.
	 */
	@Override
	public void update() {
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
		if (powerUpAanval && !magAanvallen) {
			float richting = getAngleFrom(mainGame.getBaas());
			Aanval projectiel = new SpelerEenAanval(mainGame, projectileSprite, richting, 0.9f);
			mainGame.addGameObject(projectiel, mainGame.getSpelerX() + getWidth() / 2 - Projectiel.WIDTH / 2 - 10,
					mainGame.getSpelerY() + getHeight() - 10);
			magAanvallen = true;
			startAlarmAanval();
		}
	}

	/**
	 * functie voor de alarm voor de animatie.
	 */
	public void startAlarm() {
		Alarm alarm = new Alarm("Animatie", 1 / 0.95f);
		alarm.addTarget(this);
		alarm.start();
	}

	/**
	 * Functie om alarm te starten voor de aanval van de speler.
	 */
	public void startAlarmAanval() {
		Alarm alarm = new Alarm("magAanvallen", 1 / aanvallenPerSeconden);
		alarm.addTarget(this);
		alarm.start();

	}

	/**
	 * Zodra de alarm afgaat, wordt deze functie uitgevoerd en wisselt hij een
	 * boolean voor de animatie en maakt hij magAanvallen false.
	 * 
	 */
	public void triggerAlarm(String alarmName) {
		if (isAnimatie) {
			isAnimatie = false;
		} else if (!isAnimatie) {
			isAnimatie = true;
		}
		if (alarmName == "magAanvallen") {
			magAanvallen = false;
		}
	}

	/**
	 * Deze functie controleert of de speler een knop indrukt en als hij dat wel
	 * doet, checkt hij de animatie of het een beweging is of het een aanval is of
	 * dat de level gecleared is.
	 */
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
			beweeg(270, speed, 0 + totalFramez);
		} else if (keyCode == mainGame.UP || key == 'w') {
			beweeg(0, speed, 4 + totalFramez);
		} else if (keyCode == mainGame.RIGHT || key == 'd') {
			beweeg(90, speed, 6 + totalFramez);
		} else if (keyCode == mainGame.DOWN || key == 's') {
			beweeg(180, speed, 2 + totalFramez);
		} else if (key == ' ') {
			if (powerup != null) {
				powerup.gebruikPowerUp(this);
			}
		}
	}

	
	/**
	 * Functie die de speler beweegt en animatie verandert.
	 * 
	 * @param directionspeed
	 *            de richting
	 * @param speed
	 *            de snelheid
	 * @param frame
	 *            de frame van de afbeelding
	 */
	public void beweeg(int directionspeed, int speed, int frame) {
		setDirectionSpeed(directionspeed, speed);
		setCurrentFrameIndex(frame);
	}
	

	/**
	 * Deze functie kijkt of de speler tegen een tile aanloopt en als de speler de
	 * powerup sloop heeft opgeraapt, sloopt hij alle tiles.
	 * 
	 */
	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		PVector vector;
		for (CollidedTile ct : collidedTiles) {
			if (ct.theTile instanceof BoardsTile) {
				if (sloop == true) {
					if (ct.collisionSide == ct.RIGHT) {
						try {
							vector = mainGame.getTileMap().getTilePixelLocation(ct.theTile);
							mainGame.getTileMap().setTile((int) vector.x / 50, (int) vector.y / 50, -1);
						} catch (TileNotFoundException e) {
							e.printStackTrace();
						}
					}
					if (ct.collisionSide == ct.LEFT) {
						try {
							vector = mainGame.getTileMap().getTilePixelLocation(ct.theTile);
							mainGame.getTileMap().setTile((int) vector.x / 50, (int) vector.y / 50, -1);
						} catch (TileNotFoundException e) {
							e.printStackTrace();
						}
					}
					if (ct.collisionSide == ct.TOP) {
						try {
							vector = mainGame.getTileMap().getTilePixelLocation(ct.theTile);
							mainGame.getTileMap().setTile((int) vector.x / 50, (int) vector.y / 50, -1);
						} catch (TileNotFoundException e) {
							e.printStackTrace();
						}
					}
					if (ct.collisionSide == ct.BOTTOM) {
						try {
							vector = mainGame.getTileMap().getTilePixelLocation(ct.theTile);
							mainGame.getTileMap().setTile((int) vector.x / 50, (int) vector.y / 50, -1);
						} catch (TileNotFoundException e) {
							e.printStackTrace();
						}
					}
				} else {
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
	}

	/**
	 * Functie die teruggeeft welke powerup de speler heeft.
	 * 
	 * @return powerup de powerup van de speler.
	 */
	public PowerUp getPowerup() {
		return powerup;
	}

	/**
	 * Functie om de powerup van de speler aan te passen
	 * 
	 * @param powerup
	 *            powerup van de speler.
	 */
	public void setPowerup(PowerUp powerup) {
		this.powerup = powerup;
	}

	/**
	 * Functie om de spelers snelheid aan te passen
	 * 
	 * @param speed
	 *            spelers snelheid
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setSloop(boolean sloop) {
		this.sloop = sloop;
	}
	
	public void setPowerUpAanval(boolean powerUpAanval) {
		this.powerUpAanval = powerUpAanval;
	}

	public float getVijandRichting() {
		return getAngleFrom(mainGame.getBaas());
	}


}
