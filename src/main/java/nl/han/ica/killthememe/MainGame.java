package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.view.View;
import nl.han.ica.killthememe.TextObject;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class MainGame extends GameEngine implements IAlarmListener {
	private Sound backgroundSound;
	private boolean bossVerslagen;
	private int currentLevel = 0;
	private TextObject dashboardText;
	private Level level = new Level(this);
	private Menu menu;
	private String naamText = " ";
	private PowerUp powerup;
	private Speler speler;
	private String gameNaam = "Kill The Meme!";
	private String doodTekst = "Dood! Opnieuw?";
	private String winTekst = "Gefeliciteerd! Je hebt gewonnen!";
	private int tijd = 30;
	private Vijand vijand;
	private Vijand[] vijanden = {new BaasA(this), new BaasA(this), new BaasA(this), new BaasA(this)};
	private Vogel vogel;
	private int worldWidth;
	private int worldHeight;
	public static void main(String[] args) {
		PApplet.main(new String[] { "nl.han.ica.killthememe.MainGame" });
	}

	/**
	 * Dit creert alle objecten en maakt de level.
	 */
	@Override
	public void setupGame() {
		bossVerslagen = false;
		worldWidth = 800;
		worldHeight = 600;

		deleteAllGameOBjects();
		if (currentLevel == 0 && backgroundSound == null) {
			initializeSound();
		}
		createDashboard(worldWidth, 100, getCurrentLevel());
		initializeTileMap(getCurrentLevel());
		refreshDasboardText();
		createObjects(getCurrentLevel());
		createView(worldWidth, worldHeight);
	}

	/**
	 * creert de view zonder viewport
	 * 
	 * @param screenWidth
	 *            Breedte van het scherm
	 * @param screenHeight
	 *            Hoogte van het scherm
	 */
	private void createView(int screenWidth, int screenHeight) {
		View view = new View(screenWidth, screenHeight);
		view.setBackground(loadImage(level.pickBackground(getCurrentLevel())));
		setView(view);
		size(screenWidth, screenHeight);
	}

	/**
	 * Functie om een dashboard te maken.
	 * 
	 * @param dashboardWidth
	 *            breedte van de scherm
	 * @param dashboardHeight
	 *            hoogte van de scherm
	 */
	private void createDashboard(int dashboardWidth, int dashboardHeight, int currentLevel) {
		deleteAllDashboards();
		Dashboard dashboard = new Dashboard(0, 0, dashboardWidth, dashboardHeight);
		if (getCurrentLevel() == 0 || getCurrentLevel() == -1 || getCurrentLevel() == 6 || getCurrentLevel() == -10) {
			menu = new Menu(this, "", currentLevel, worldWidth, worldHeight);
			dashboard.addGameObject(menu);
			addGameObject(menu);
		} else if (getCurrentLevel() >= 1 && getCurrentLevel() <= 5) {
			dashboardText = new TextObject("", currentLevel);
			dashboard.addGameObject(dashboardText);
		}
		addDashboard(dashboard);
	}

	/**
	 * Functie om de dashboard te verversen.
	 */
	private void refreshDasboardText() {
		if (getCurrentLevel() == 0) {
			menu.setText(gameNaam);
			menu.setNaamText(naamText);
		} else if (getCurrentLevel() >= 1 && getCurrentLevel() <= 4) {
			dashboardText.setText("Level: " + getCurrentLevel() + "  " + naamText + "  Doel:" + level.doel(currentLevel));
		} else if (getCurrentLevel() == 5) {
			dashboardText.setText("Level: " + getCurrentLevel() + "  " + naamText + "   Doel: " + level.doel(currentLevel) + " Tijd om te winnen: " + tijd);
		} else if (getCurrentLevel() == 6) {
			menu.setText(winTekst);
			menu.setNaamText(naamText);
		} else if (getCurrentLevel() == -1) {
			menu.setText(doodTekst);
		} else if (getCurrentLevel() == -10) {
			menu.setText("Instructies:");
			// menu.setNaamText(naamText);
		}
	}

	/**
	 * Dit is voor de creatie van Game Objecten
	 * 
	 * @param currentLevel
	 *            de hudige level
	 */
	private void createObjects(int currentLevel) {
		if (currentLevel == -10) {
			addGameObject(new PowerUpProjectiel(this), worldHeight/4, 250);
			addGameObject(speler = new Speler(this, 0.3f), 300, 250);
			addGameObject(vijand = new BaasA(this), 650, 250);
		}
		if (currentLevel == 1) {
			backgroundSound.rewind();
			
			addGameObject(speler = new Speler(this, 0.3f), 10, 100);
			addGameObject(vogel = new Vogel(this), 1000, 100);
			addGameObject(vijand = new BaasA(this), 220, 500);
		} else if (currentLevel == 2) {
			addGameObject(speler = new Speler(this, 0.4f), 10, 100);
			addGameObject(vogel = new Vogel(this), 1000, 100);
			level.addPowerUp(currentLevel);
			addGameObject(vijand = new BaasB(this), 700, 500);
		} else if (currentLevel == 3) {
			addGameObject(speler = new Speler(this, 0.4f), 10, 100);
			addGameObject(vogel = new Vogel(this), 1000, 100);
			addGameObject(powerup = new PowerUpVlug(this), 0, 300);
			int teller = 700;
			for (Vijand v : vijanden) {
				addGameObject(v, teller, 500);
				teller -= 100;
			}
		} else if (currentLevel == 4) { 
			addGameObject(speler = new Speler(this, 0.4f), 10, 100);
			addGameObject(vogel = new Vogel(this), 1000, 100);
			addGameObject(powerup = new PowerUpSloop(this), 100, 300);
		} else if (currentLevel == 5) {
			addGameObject(speler = new Speler(this, 0.4f), 50, 250);
			addGameObject(vijand = new BaasC(this), 700, 500);
			startTimerAlarm();
		}
//		PowerUp[] powerarr = level.getPowerUp(currentLevel);
//		int[] xy = level.getPowerXY(currentLevel);
//			for(int i = 0; i < powerarr.length; i++) {
//				addGameObject(powerarr[i], xy[i], xy[i+1]);
//			}
	}

	/**
	 * Functie voor het initialiseren van het geluid
	 */
	private void initializeSound() {
		backgroundSound = new Sound(this, "src/main/java/nl/han/ica/killthememe/media/SeaShanty2.mp3");
		backgroundSound.loop(-1);
	}

	/*
	 * 
	 * Functie om de tilemap in te laden en op te halen van Level.
	 * 
	 * @param currentLevel huidige level
	 */
	private void initializeTileMap(int currentLevel) {
		/* TILES */

		Sprite boardsSprite = new Sprite(level.pickLevelTile());
		TileType<BoardsTile> boardTileType = new TileType<>(BoardsTile.class, boardsSprite);
		TileType[] tileTypes = {boardTileType};
		int tileSize = 50;

		tileMap = new TileMap(tileSize, tileTypes, level.getLevelTile(currentLevel));
	}

	public void bossVerslagen() {
		bossVerslagen = true;
	}

	public void update() {
		if (speler != null) { 
			if (levelClear()) {
				setCurrentLevel(getCurrentLevel() + 1);
				setupGame();
			}
			if (currentLevel == 3) {
				for (Vijand v : vijanden) {
					v.afvuren();
				}
			} else if (vijand != null) {
				vijand.afvuren();
			}
		}
	}

	/**
	 * Haalt de spelers gameobject op zodat de vijands projectiel weet waar die
	 * naartoe moet gaan
	 * 
	 * @return speler Object van de speler
	 */
	public GameObject getSpeler() {
		return speler;
	}

	/**
	 * Functie die de huidige level teruggeeft
	 * 
	 * @return huidige level
	 */
	public int getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * Functie om de level te wijzigen
	 * 
	 * @param currentLevel
	 *            huidige level
	 */
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
	 * Functie om de naam op te slaan.
	 * 
	 * @param naamText
	 *            de naam die ingevoerd is
	 */
	public void setCurrentName(String naamText) {
		this.naamText = naamText;
	}

	/**
	 * Haalt de X pos van de speler op
	 * 
	 * @return X pos van speler.
	 */
	public float getSpelerX() {
		return speler.getX();
	}

	/**
	 * Haalt de Y pos van de speler op
	 * 
	 * @return Y pos van speler.
	 */
	public float getSpelerY() {
		return speler.getY();
	}

	/**
	 * Haalt de gameobject op zodat de projectiel weet waar die naartoe moet gaan
	 * 
	 * @return baas object
	 */
	public GameObject getBaas() {
		return vijand;
	}

	/**
	 * checkt of de level is gecleared en returnt true.
	 * 
	 * @return
	 */
	public boolean levelClear() {
		if (getCurrentLevel() == 1 && speler.getX() >= 740 && speler.getY() >= 50 && speler.getX() <= 800
				&& speler.getY() <= 150) {
			return true;
		} else if (getCurrentLevel() == 2 && speler.getX() >= 715 && speler.getY() >= 500 && speler.getX() <= 800
				&& speler.getY() <= 600 || getCurrentLevel() == 2 && bossVerslagen) {
			return true;
		} else if (getCurrentLevel() == 3 && speler.getX() >= 740 && speler.getY() >= 50 && speler.getX() <= 800
				&& speler.getY() <= 150) {
			return true;
		} else if (getCurrentLevel() == 4 && speler.getX() >= 750 && speler.getY() >= 250 && speler.getX() <= 800
				&& speler.getY() <= 350) {
			return true;
		} else if (getCurrentLevel() == 5 && bossVerslagen) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Kijkt of de muisknop ingedrukt wordt bij het start menu, gameover scherm of
	 * eindscherm en start het spel zodra de start of retry knop wordt gedrukt.
	 */
	@Override
	public void mouseClicked() {
		if (currentLevel == 0 || currentLevel == -1 || currentLevel == 6) {
			if (mouseX > worldWidth / 3 && mouseY > (worldHeight / 3) * 2 && mouseX < worldWidth / 3 + 80
					&& mouseY < 440) {
				if (currentLevel == 0) {
					naamText = menu.getNaam();
				}
				currentLevel = -10;
				setupGame();
			} else if (mouseX > worldWidth / 2 && mouseY > (worldHeight / 3) * 2 && mouseX < worldWidth / 2 + 80
					&& mouseY < 440) {
				System.exit(0);
			}
		} else if (currentLevel == -10) {
			if (mouseX > worldWidth / 3 && mouseY > (worldHeight / 3) * 2 && mouseX < worldWidth / 3 + 80
					&& mouseY < 440) {
				currentLevel = 0;
				setupGame();
			} else if (mouseX > worldWidth / 2 && mouseY > (worldHeight / 3) * 2 && mouseX < worldWidth / 2 + 80
					&& mouseY < 440) {
				if (currentLevel == 0) {
					naamText = menu.getNaam();
				}
				currentLevel = 1;
				setupGame();
			}
		}
	}

	/**
	 * Functie om alarm te starten voor de timer die laat zien hoelang de speler het
	 * moet overleven.
	 */
	private void startTimerAlarm() {
		Alarm alarm = new Alarm("timer", 1);
		alarm.addTarget(this);
		alarm.start();
	}

	/**
	 * Functie die uitgevoerd wordt zodra de alarm is afgelopen
	 */
	public void triggerAlarm(String alarmName) {
		if (tijd >= 1) {
			tijd--;
			refreshDasboardText();
			startTimerAlarm();
		} else if (tijd <= 0)   {
			bossVerslagen = true;
		}
	}
}
