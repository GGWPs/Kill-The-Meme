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
import nl.han.ica.OOPDProcessingEngineHAN.userinput.IKeyInput;
import nl.han.ica.OOPDProcessingEngineHAN.view.View;
import nl.han.ica.killthememe.TextObject;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class MainGame extends GameEngine implements IAlarmListener {
	private Sound backgroundSound, afvuurGeluid;
	private boolean bossVerslagen;
	private int currentLevel = 0;
	private TextObject dashboardText;
	private Level level = new Level(this);
	private Menu menu;
	private String naamText = " ";
	private Speler speler = new Speler(this);
	private String gameNaam = "Kill The Meme!";
	private String doodTekst = "Dood! Opnieuw?";
	private String winTekst = "Gefeliciteerd! Je hebt gewonnen!";
	private int tijd = 30;
	private Vijand[] vijanden;
	private Vogel vogel = new Vogel(this);
	private int worldWidth;
	private int worldHeight;

	public static void main(String[] args) {
		String[] processingArgs = {"nl.han.ica.killthememe.MainGame"};
		MainGame mySketch = new MainGame();
		PApplet.runSketch(processingArgs, mySketch);
	}

	/**
	 * Dit verwijderd alle huidige objecten en maakt het volgende level aan.
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
		createDashboard(worldWidth, worldHeight, getCurrentLevel());
		initializeTileMap(getCurrentLevel());
		createObjects(getCurrentLevel());
		refreshDasboardText();
		createView(worldWidth, worldHeight);
		speler.resetPowerups();
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
			dashboardText = new TextObject(" ", currentLevel);
			dashboard.addGameObject(dashboardText);
		}
		addDashboard(dashboard);
	}

	/**
	 * Functie om het dashboard te verversen.
	 */
	private void refreshDasboardText() {
		if (getCurrentLevel() == 0) {
			menu.setText(gameNaam);
			menu.setNaamText(naamText);
		} else if (getCurrentLevel() >= 1 && getCurrentLevel() <= 4) {
			dashboardText
					.setText("Level: " + getCurrentLevel() + "  " + naamText + "  Doel:" + level.doel(currentLevel));
		} else if (getCurrentLevel() == 5) {
			dashboardText.setText("Level: " + getCurrentLevel() + "  " + naamText + "   Doel: "
					+ level.doel(currentLevel) + " Tijd om te winnen: " + tijd);
		} else if (getCurrentLevel() == 6) {
			menu.setText(winTekst);
			menu.setNaamText(naamText);
		} else if (getCurrentLevel() == -1) {
			menu.setText(doodTekst);
		} else if (getCurrentLevel() == -10) {
			menu.setText("Instructies:");
		}
	}

	/**
	 * Dit is voor de creatie van de Game Objecten
	 * 
	 * @param currentLevel het hudige level
	 */
	private void createObjects(int currentLevel) {
		vijanden = level.getVijanden(currentLevel);
		level.addPowerUp(currentLevel);
		addGameObject(vogel, 1000, 100);
		if (currentLevel == -10) {
			addGameObject(speler, 300, 250);
		} else if (currentLevel == 1) {
			backgroundSound.rewind();
			addGameObject(speler, 10, 100);
		} else if (currentLevel == 2 || currentLevel == 3 || currentLevel == 4) {
			addGameObject(speler, 10, 100);
		} else if (currentLevel == 5) {
			addGameObject(speler, 50, 250);
			eindBaasAlarm();
		}
		if(vijanden != null) {
			for (Vijand v : vijanden) {
					addGameObject(v, v.x, v.y);
			}
		}
	}

	/**
	 * Functie voor het initialiseren van het geluid
	 */
	private void initializeSound() {
		backgroundSound = new Sound(this, "src/main/java/nl/han/ica/killthememe/media/SeaShanty2.mp3");
		backgroundSound.loop(-1);
		afvuurGeluid = new Sound(this, "src/main/java/nl/han/ica/killthememe/media/biem.mp3");
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
		TileType[] tileTypes = { boardTileType };
		int tileSize = 50;

		tileMap = new TileMap(tileSize, tileTypes, level.getLevelTile(currentLevel));
	}
	/*
	 * Update functie die constant uitgevoerd wordt.
	 */
	public void update() {
		if (speler != null) {
			if (currentLevel >= 1 && currentLevel <= 5) {
				dashboardText.setLeven(speler.getLeven());
			}
			if (levelClear()) {
				setCurrentLevel(getCurrentLevel() + 1);
				setupGame();
			}
			if (vijanden != null) {
				for (Vijand v : vijanden) {
					v.afvuren();
				}
			}
		}
	}
	/*
	 * Methode die een geluid afspeelt
	 */
	public void speelAfvuurGeluid() {
		afvuurGeluid.rewind();
		afvuurGeluid.play();
	}

	/*
	 * Zet bossVerslagen op true.
	 */
	public void bossVerslagen() {
		bossVerslagen = true;
	}

	/**
	 * Haalt het speler gameobject op om de richting van het projectiel voor de vijand te bepalen
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
	 * Functie om het level te wijzigen
	 * 
	 * @param currentLevel huidige level
	 */
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	/**
	 * Functie om de naam op te slaan.
	 * 
	 * @param naamText de naam die ingevoerd is
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
	 * Haalt het gameobject op zodat de projectiel naar het vijand object toe gaat
	 * 
	 * @return baas object
	 */
	public GameObject getBaas() {
		return vijanden[0];
	}

	/**
	 * checkt of het de eisesn voor hetlevel gecleared zijn en returnt dan true.
	 * 
	 * @return boolean
	 */
	public boolean levelClear() {
		if (getCurrentLevel() == 1 && speler.getX() >= 740 && speler.getY() >= 50 && speler.getX() <= 800
				&& speler.getY() <= 150) {
			return true;
		} else if (getCurrentLevel() == 2 && speler.getX() >= 715 && speler.getY() >= 500 && speler.getX() <= worldWidth
				&& speler.getY() <= 600 || getCurrentLevel() == 2 && bossVerslagen) {
			return true;
		} else if (getCurrentLevel() == 3 && speler.getX() >= 740 && speler.getY() >= 50 && speler.getX() <= worldWidth
				&& speler.getY() <= 150) {
			return true;
		} else if (getCurrentLevel() == 4 && speler.getX() >= worldWidth - 50 && speler.getY() >= 250
				&& speler.getX() <= worldWidth && speler.getY() <= 350) {
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
	private void eindBaasAlarm() {
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
			eindBaasAlarm();
		} else if (tijd <= 0) {
			bossVerslagen = true;
		}
	}

}
