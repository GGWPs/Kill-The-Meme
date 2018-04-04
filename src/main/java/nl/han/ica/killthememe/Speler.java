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
	final int size = 70;
	private int huidigLevel;
	private String naam;
	private char controls;
	private Level level;
	private MainGame mainGame;
	private boolean isAnimatie;
	int totalFramez = 0;
	final int speed = 3;

	/**
	 * 
	 * @param mainGame
	 */
	public Speler(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/frisk1.png"), 8);
		// super(new Sprite("src/main/java/nl/han/ica/waterworld/media/player.png"),2);
		this.mainGame = mainGame;
		setCurrentFrameIndex(3);
		setFriction(0.10f);
	}

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
		if (keyCode == mainGame.LEFT) {
			beweegLinks();
		}
		if (keyCode == mainGame.UP) {
			beweegOmhoog();
		}
		if (keyCode == mainGame.RIGHT) {
			beweegRechts();
		}
		if (keyCode == mainGame.DOWN) {
			beweegOmlaag();
		}
		if (key == 'w') {
			beweegOmhoog();
		}
		if (key == 'a') {
			beweegLinks();
		}
		if (key == 's') {
			beweegOmlaag();
		}
		if (key == 'd') {
			beweegRechts();
		}
		if (key == ' ') {
			System.out.println("Spatie!");
		}
	}

	public void beweegLinks() {
		setCurrentFrameIndex(0 + totalFramez);
		beweeg(270, speed, 0 + totalFramez);
	}

	public void beweegRechts() {
		setCurrentFrameIndex(6 + totalFramez);
		beweeg(90, speed, 6 + totalFramez);
	}

	public void beweegOmhoog() {
		setCurrentFrameIndex(4 + totalFramez);
		beweeg(0, speed, 4 + totalFramez);
	}

	public void beweegOmlaag() {
		setCurrentFrameIndex(2 + totalFramez);
		beweeg(180, speed, 2 + totalFramez);
	}

	@Override
	public void beweeg(int directionspeed, int speed, int frame) {
		setDirectionSpeed(directionspeed, speed);
		setCurrentFrameIndex(frame);
	}

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

}
