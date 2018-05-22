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
	final int size = 50;
	private MainGame mainGame;
	private boolean isAnimatie;
	private float aanvallenPerSeconden;
	int totalFramez = 0;
	PowerUp powerup;
	protected boolean magAanvallen;
	private int speed = 2;

	/**
	 * Speler constructor
	 * 
	 * @param mainGame de wereld
	 * @param aanvallenPerSeconden aanvallen per seconde
	 */
	public Speler(MainGame mainGame, float aanvallenPerSeconden) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/frisk1.png"), 8);
		this.mainGame = mainGame;
		this.aanvallenPerSeconden = aanvallenPerSeconden;
		this.magAanvallen = false;
		setCurrentFrameIndex(3);
		setFriction(0.10f);
	}

	// Dit stopt de speler zodra hij het rand van het scherm aanraakt.
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
	}

	// alarm voor animatie
	void startAlarm() {
		Alarm alarm = new Alarm("Animatie", 1 / 0.95f);
		alarm.addTarget(this);
		alarm.start();
	}

	// Zodra de alarm afgaat, wordt deze functie uitgevoerd en wisselt hij een
	// bolean voor de animatie en maakt hij magAanvallen false.
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
	 * Functie om alarm te starten voor de aanval van de speler.
	 */
	public void startAlarmAanval() {
		Alarm alarm = new Alarm("magAanvallen", 1 / aanvallenPerSeconden);
		alarm.addTarget(this);
		alarm.start();

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
			beweegLinks(270, speed, 0 + totalFramez);
		}
		if (keyCode == mainGame.UP || key == 'w') {
			beweegOmhoog(0, speed, 4 + totalFramez);
		}
		if (keyCode == mainGame.RIGHT || key == 'd') {
			beweegRechts(90, speed, 6 + totalFramez);
		}
		if (keyCode == mainGame.DOWN || key == 's') {
			beweegOmlaag(180, speed, 2 + totalFramez);
		}
		if (key == ' ') {
			if (powerup != null && powerup.isItemIsOpgepakt()) {
				if(powerup.powerNaam() == "Projectiel" && !magAanvallen ) {
					float richting = getAngleFrom(mainGame.getBaas());
					System.out.print("Projectiel");
					powerup.gebruikPowerUp(richting);
					magAanvallen = true;
					startAlarmAanval();
				} else if (powerup.powerNaam()  == "Speed"){
					System.out.print("Speed");
					setSpeed(4);
				} else if (powerup.powerNaam()  == "Sloop"){
					System.out.print("Sloop");
				}
			}
		}
		// dit checkt met elke keypress of de speler de level heeft gecleared.
		if (mainGame.levelClear()) {
			mainGame.setCurrentLevel(mainGame.getCurrentLevel() + 1);
			mainGame.setupGame();
		}
	}

	// functie om naar links te bewegen
	public void beweegLinks(int directionspeed, int speed, int frame) {
		setDirectionSpeed(directionspeed, speed);
		setCurrentFrameIndex(frame);
	}

	// functie om naar rechts te bewegen
	public void beweegRechts(int directionspeed, int speed, int frame) {
		setDirectionSpeed(directionspeed, speed);
		setCurrentFrameIndex(frame);
	}

	// functie omhoog te lopen
	public void beweegOmhoog(int directionspeed, int speed, int frame) {
		setDirectionSpeed(directionspeed, speed);
		setCurrentFrameIndex(frame);
	}

	// functie om omlaag te bewegen
	public void beweegOmlaag(int directionspeed, int speed, int frame) {
		setDirectionSpeed(directionspeed, speed);
		setCurrentFrameIndex(frame);
	}

	// Functie geërft van de beweeg interface voor het bewegen.

	// Deze functie kijkt of de speler tegen een tile aanloopt.
	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		PVector vector;

		for (CollidedTile ct : collidedTiles) {
			if (ct.theTile instanceof BoardsTile) {
				if(powerup != null && powerup.powerNaam() == "Sloop") {
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
	
	
	
	public PowerUp getPowerup() {
		return powerup;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setPowerup(PowerUp powerup) {
		this.powerup = powerup;
	}

}
