package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.TextObject;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PApplet;

//yeete

@SuppressWarnings("serial")
public class MainGame extends GameEngine implements IAlarmListener {
	private Speler speler;
	private Vijand vijand;
	private Vogel vogel;
	private Sound backgroundSound;
	private Sound bubblePopSound;
	private TextObject dashboardText;
	private IPersistence persistence;
	private Menu menu;
	private int currentLevel = 1;
	private Level level;
	private int worldWidth;

	private int worldHeight;
	private boolean isNext;

	public static void main(String[] args) {
		PApplet.main(new String[] { "nl.han.ica.killthememe.MainGame" });

	}

	@Override
	public void setupGame() {

		worldWidth = 800;
		worldHeight = 600;

		initializeSound();
		// createMenu();
		// menu.createDashboard(worldWidth, 100);
		createDashboard(worldWidth, 100);
		initializeTileMap(currentLevel);

		initializeSound();
		initializePersistence();
		

		startAlarm();
		createView(worldWidth, worldHeight);
		createObjects();
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
		view.setBackground(loadImage("src/main/java/nl/han/ica/killthememe/media/nether.jpg"));
		// view.setBackground(loadImage("src/main/java/nl/han/ica/waterworld/media/background.jpg"));

		setView(view);
		size(screenWidth, screenHeight);
	}

	public void createMenu() {
		menu = new Menu(this);
	}

	private void createDashboard(int dashboardWidth, int dashboardHeight) {
		Dashboard dashboard = new Dashboard(0, 0, dashboardWidth, dashboardHeight);
		dashboardText = new TextObject("");
		dashboard.addGameObject(dashboardText);
		addDashboard(dashboard);
	}

	public void initializePersistence() {
		refreshDasboardText();
	}

	public void refreshDasboardText() {
		dashboardText.setText("Level: " + currentLevel);
	}

	public void createObjects() {
		speler = new Speler(this);
		addGameObject(speler, 10, 100);
		// vijand =new Vijand(this);
		// addGameObject(vijand,1000,500);
		vogel = new Vogel(this);
		addGameObject(vogel, 1000, 100);
		Vijand vf = new BaasEen(this);
		addGameObject(vf, 450, -50);

	}

	private void initializeSound() {
		backgroundSound = new Sound(this, "src/main/java/nl/han/ica/waterworld/media/Waterworld.mp3");
		backgroundSound.loop(-1);
		bubblePopSound = new Sound(this, "src/main/java/nl/han/ica/waterworld/media/pop.mp3");
	}

	private void initializeTileMap(int currentLevel) {
		/* TILES */

		Sprite boardsSprite = new Sprite("src/main/java/nl/han/ica/waterworld/media/boards.jpg");
		TileType<BoardsTile> boardTileType = new TileType<>(BoardsTile.class, boardsSprite);

		TileType[] tileTypes = { boardTileType };
		int tileSize = 60;

		int tilesMap[][] = laadTileMap(currentLevel);

		tileMap = new TileMap(tileSize, tileTypes, tilesMap);
		// tileMap = new TileMap(tileSize, tileTypes, level.getLevelTile(currentLevel));
	}

	private int[][] laadTileMap(int currentLevel) {
		if (currentLevel == 1) {
			int tileMap[][] = { { -1, -1, -1, -1, -1, 0, 0, 0, -1, -1 }, { -1, -1, -1, -1, -1, -1, 0, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, 0, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, 0, -1, -1, -1 },
					{ -1, -1, -1, 0, 0, 0, 0, 0, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, 0, 0, 0, 0, -1, 0, 0 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 } };

			return tileMap;
		} else if (currentLevel == 2) {
			int tileMap[][] = { { -1, -1, -1, -1, -1, 0, 0, 0, -1, -1 }, { -1, -1, -1, -1, -1, -1, 0, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, 0, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, 0, -1, -1, -1 },
					{ -1, -1, -1, 1, 1, 1, 1, 1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, 1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, 0, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, 0, -1, -1, -1 }, { -1, -1, -1, 0, 0, 0, 0, -1, 0, 0 },
					{ -1, -1, -1, -1, -1, 0, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, 0, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, 0, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, 0, -1, -1, -1, -1 } };

			return tileMap;
		} else {
			return null;
		}
	}

	void startAlarm() {
		Alarm alarm = new Alarm("Next", 1 / 0.2f);
		alarm.addTarget(this);
		alarm.start();
	}

	public void triggerAlarm(String alarmName) {
		if (!isNext) {
			isNext = true;
			currentLevel++;
			startAlarm();
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
