package nl.han.ica.killthememe;

public class Level {
	private int currentLevel;

	/**
	 * Level constructor
	 * @param currentLevel de huidige level.
	 */
	public Level(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	
	/**
	 * Functie die per level een andere tile kan uitkiezen of te wel een andere muur.
	 * @return tile locatie
	 */
	public String pickLevelTile() {
		return "src/main/java/nl/han/ica/killthememe/media/boards.jpg";
	}
	
	
	/**
	 * Functie die de achtergrond voor de level ophaalt.
	 * @param currentLevel
	 * @return achtergrond level
	 */
	public String pickBackground(int currentLevel) {
		if (currentLevel == 0 || currentLevel == -1 || currentLevel == 6) {
			return "src/main/java/nl/han/ica/killthememe/media/menuZwart.png";
		} else if (currentLevel == 1) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
		} else if (currentLevel == 2) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
		} else if (currentLevel == 3) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
		} else if (currentLevel == 4) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
		} else if (currentLevel == 5) {
			return "src/main/java/nl/han/ica/killthememe/media/fccachtergrond.jpg";
		}  else {
			return "src/main/java/nl/han/ica/killthememe/media/menuZwart.png";
		}
	}
	
	
	/**
	 * Functie die de tilemap teruggeeft bij de bijhorende level.
	 * @param currentLevel
	 * @return tilemap
	 */
	public int[][] getLevelTile(int currentLevel) {
		if (currentLevel == 0 || currentLevel == -1) {
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
			int tilesMap[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, 0, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, 0, -1, -1, 0, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, 0, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, 0, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, 0, -1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, 0, -1, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, 0, -1, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, -1, -1, -1, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, -1, -1, -1, 0, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, -1, -1, -1, 0, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, -1, -1, -1, 0, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
			return tilesMap;
		} else if (currentLevel == 2) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, 0, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, 0, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, 0, -1, -1, -1, -1, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, -1 },
					{ -1, 0, 0, 0, 0, -1, -1, 0, 0, -1, 0, 0, 0, 0, 0, -1, -1 },
					{ -1, -1, -1, -1, 0, -1, -1, 0, 0, -1, 0, 0, 0, 0, 0, -1, -1 },
					{ -1, -1, -1, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -1, -1 },
					{ 0, 0, 0, -1, -1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ 0, 0, 0, -1, -1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1 } };
			return tilesMap;
		} else if (currentLevel == 3) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][]={
	                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,0,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,0,-1,-1,0,-1,0,0,0,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,-1,-1,-1,-1,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,-1,-1,-1,-1,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,-1,-1,-1,0,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,-1,-1,-1,0,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,-1,-1,-1,0,0,0,-1,0,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,-1,-1,-1,0,-1,0,-1,-1,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,-1,-1,-1,0,-1,0,-1,-1,-1,0,0,0,0,0,0,0,0,0,0}
	               
	        };
			return tilesMap; 
		} else if (currentLevel == 4) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][]={
	                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                {-1,-1,-1,-1,0,0,0,0,0,0,0,0,0,-1,-1,0,0},
	                {-1,-1,-1,-1,0,0,0,0,0,0,0,0,0,-1,-1,0,0},
	                {0,-1,-1,-1,0,0,0,0,0,0,0,0,0,-1,-1,0,0},
	                {0,-1,-1,-1,0,0,0,0,0,0,0,0,0,-1,-1,0,0},
	                {0,-1,-1,-1,0,0,0,0,0,0,0,0,0,-1,-1,-1,0},
	                {0,-1,-1,-1,0,0,0,0,0,0,0,0,0,-1,-1,-1,0},
	                {0,-1,-1,-1,0,0,0,0,0,0,0,0,0,-1,-1,0,0},
	                {0,-1,-1,-1,0,0,0,0,0,0,0,0,0,-1,-1,0,0},
	                {0,-1,-1,-1,0,0,0,0,0,0,0,0,0,-1,-1,0,0},
	                {0,-1,-1,-1,0,0,0,0,0,0,0,0,0,-1,-1,0,0},
	                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	        };
			return tilesMap; 
		} else if (currentLevel == 5) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][]={
	                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                {0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0},
	                {0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0},
	                {0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0},
	                {0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0},
	                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0},
	                {0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0},
	                {0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0},
	                {0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0},
	                {0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0},
	                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	        };
			return tilesMap; 
		} else {
			System.out.println("Geen level!");
			return null;
		}

	}
}
