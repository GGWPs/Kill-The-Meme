package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.waterworld.Player;
import nl.han.ica.waterworld.Swordfish;
import nl.han.ica.waterworld.tiles.BoardsTile;

public class Level {
	private int levels;
	private Sound backgroundSound;
	private Speler speler;
	private int currentLevel;

	public Level(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	boolean levelClear() {

		return true;
	}

	void obstakel() {

	}

	public void setupGame() {

	}

	void statusBalk() {

	}

	void updateStatus() {

	}

	void initializeSound() {

	}

	public String pickBackground(int currentLevel) {
		if (currentLevel == 0) {
			return "src/main/java/nl/han/ica/killthememe/media/menuZwart.png";
		}
		if (currentLevel == 1) {
			return "src/main/java/nl/han/ica/killthememe/media/nether.jpg";
		} else if (currentLevel == 2) {
			return "src/main/java/nl/han/ica/killthememe/media/beech.jpg";
		} else {
			return null;
		}
	}

	public int[][] getLevelTile(int currentLevel) {
		if (currentLevel == 0) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][] = { { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 } };
			return tilesMap;
		}
		if (currentLevel == 1) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][]={
	                {0,0,0,0,0,0,0,0,0,0},
	                {-1,-1,-1,-1,0,-1,0,-1,-1,-1},
	                {-1,-1,-1,-1,0,-1,-1,-1,-1,0},
	                {-1,-1,-1,-1,0,-1,-1,-1,-1,0},
	                {-1,-1,-1,0,0,0,0,0,-1,-1},
	                {-1,-1,-1,-1,0,-1,-1,-1,-1,0},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1, 0, 0, 0, 0,-1,0 , 0},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
	        };
			return tilesMap; 
		} else if (currentLevel == 2) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][] = { { -1, -1, -1, -1, 0, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, 0, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, 0, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, 0, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, 0, 0, 0, 0, 0, -1, -1 }, { -1, -1, -1, -1, 0, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, 0, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, 0, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, 0, -1, -1, -1, -1, -1 }, { -1, -1, -1, 0, 0, 0, 0, -1, 0, 0 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 } };
			return tilesMap;
		} else {
			System.out.println("Geen level gevonden!");
			return null;
		}

	}
}
