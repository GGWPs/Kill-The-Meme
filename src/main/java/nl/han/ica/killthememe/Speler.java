package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.collision.CollisionSide;
import nl.han.ica.OOPDProcessingEngineHAN.collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PVector;

public class Speler extends AnimatedSpriteObject implements ICollidableWithTiles, IAlarmListener {

	private MainGame mainGame;
	private boolean inAnimatie;
	private float aanvallenPerSeconden = 0.3f;
	private PowerUp powerup;
	private int spelerSpeed = 2;
	private int leven = 3;
	private boolean magPowerUpGebruiken;
	private final int size = 50;
	private float richting;
	private int totalFramez = 0;
	private PVector vector;

	/**
	 * Speler constructor
	 * 
	 * @param mainGame
	 *            de wereld
	 */
	public Speler(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/frisk1.png"), 8);
		this.mainGame = mainGame;
		this.magPowerUpGebruiken = false;
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

		if (powerup instanceof PowerUpProjectiel) {
			this.setRichting(getAngleFrom(mainGame.getBaas()));
		}
		if (leven <= 0) {
			mainGame.deleteGameObject(this);
			leven = 3;
			mainGame.setCurrentLevel(-1);
			mainGame.setupGame();
		}
	}

	/**
	 * functie voor de alarm voor de animatie.
	 */
	public void startAlarm(String alarmName) {
		if (alarmName == "Animatie") {
			Alarm alarm = new Alarm(alarmName, 1 / 0.95f);
			alarm.addTarget(this);
			alarm.start();
		} else if (alarmName == "magPowerUpGebruiken") {
			Alarm alarm = new Alarm(alarmName, 1 / aanvallenPerSeconden);
			alarm.addTarget(this);
			alarm.start();
		}
	}

	/**
	 * Zodra de alarm afgaat, wordt deze functie uitgevoerd en wisselt hij een
	 * boolean voor de animatie en maakt hij magAanvallen false.
	 * 
	 */
	public void triggerAlarm(String alarmName) {
		if (inAnimatie) {
			inAnimatie = false;
		} else if (!inAnimatie) {
			inAnimatie = true;
		}
		if (alarmName == "magPowerUpGebruiken") {
			magPowerUpGebruiken = false;
		}
	}

	/**
	 * Deze functie controleert of de speler een knop indrukt en als hij dat wel
	 * doet, checkt hij de animatie of het een beweging is of het een aanval is of
	 * dat de level gecleared is.
	 */
	@Override
	public void keyPressed(int keyCode, char key) {
		if (!inAnimatie) {
			totalFramez = 1;
			startAlarm("Animatie");
		}
		if (inAnimatie) {
			totalFramez = 0;
			startAlarm("Animatie");
		}
		if (keyCode == mainGame.LEFT || key == 'a') {
			beweeg(270, spelerSpeed, 0 + totalFramez);
		} else if (keyCode == mainGame.UP || key == 'w') {
			beweeg(0, spelerSpeed, 4 + totalFramez);
		} else if (keyCode == mainGame.RIGHT || key == 'd') {
			beweeg(90, spelerSpeed, 6 + totalFramez);
		} else if (keyCode == mainGame.DOWN || key == 's') {
			beweeg(180, spelerSpeed, 2 + totalFramez);
		} else if (key == ' ') {
			if (powerup != null && !magPowerUpGebruiken) {
				powerup.gebruikPowerUp(this);
				magPowerUpGebruiken = true;
				startAlarm("magPowerUpGebruiken");
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
	 * powerup sloop heeft opgeraapt sloopt hij de tile.
	 * 
	 */
	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		//PVector vector;
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof BoardsTile) {
				vector = mainGame.getTileMap().getTilePixelLocation(ct.getTile());
				if (powerup != null && powerup.getSloop() == true) {
					for (CollisionSide cs : CollisionSide.values()) {
						if (cs.equals(ct.getCollisionSide())) {
							try {
								setVector(vector);
								powerup.gebruikPowerUp(this);
							} catch (TileNotFoundException e) {
								e.printStackTrace();
							}
						}
					}
				} else {
					if (CollisionSide.TOP.equals(ct.getCollisionSide())) {
						try {
							setY(vector.y - getHeight());
						} catch (TileNotFoundException e) {
							e.printStackTrace();
						}
					}
					if (CollisionSide.BOTTOM.equals(ct.getCollisionSide())) {
						try {
							setY(vector.y + getHeight());
						} catch (TileNotFoundException e) {
							e.printStackTrace();
						}
					}
					if (CollisionSide.RIGHT.equals(ct.getCollisionSide())) {
						try {
							setX(vector.x + getHeight());
						} catch (TileNotFoundException e) {
							e.printStackTrace();
						}
					}
					if (CollisionSide.LEFT.equals(ct.getCollisionSide())) {
						try {
							setX(vector.x - getHeight());
						} catch (TileNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	
	
	/*
	 * Getter en setter voor de vector. Wordt gebruikt voor de tilecollision
	 * 
	 * @return Spelers vector tile
	 */
	public void setVector(PVector vector) {
		this.vector = vector;
	}
	
	public PVector getVector() {
		return vector;
	}

	/**
	 * Functie die teruggeeft welke powerup de speler heeft.
	 * 
	 * @return powerup de powerup van de speler.
	 */
	public PowerUp getPowerup() {
		return powerup;
	}

	public void resetPowerups() {
		if (powerup != null) {
			powerup.resetPowerUp(this);
		}
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
		this.spelerSpeed = speed;
	}

	/**
	 * Functie voor het verliezen van levens bij de vijand.
	 */
	public void verliesLeven() {
		leven--;
	}
	
	/*
	 * Getter en Setter voor het leven van de speler.
	 */
	public int getLeven() {
		return leven;
	}

	public void setLeven(int leven) {
		this.leven += leven;
	}

	
	/*
	 * Getter en Setter voor de richting van de speler.
	 * 
	 */
	public float getRichting() {
		return richting;
	}

	public void setRichting(float richting) {
		this.richting = richting;
	}

}
