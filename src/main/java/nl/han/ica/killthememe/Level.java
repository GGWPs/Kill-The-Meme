package nl.han.ica.killthememe;

public class Level {
	private int currentLevel;
	
	
	
	/*
	 * @param currentLevel huidige level
	 */
	public Level(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public String pickLevelTile() {
		return "src/main/java/nl/han/ica/killthememe/media/boards.jpg";
	}
	public String pickBackground(int currentLevel) {
		if (currentLevel == 0) {
			return "src/main/java/nl/han/ica/killthememe/media/menuZwart.png";
		}
		if (currentLevel == 1) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
		} else if (currentLevel == 2) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
		} else if (currentLevel == 3) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
		} else if (currentLevel == -1) {
			return "src/main/java/nl/han/ica/killthememe/media/menuZwart.png";
		} else {
			return null;
		}
	}

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
			int tilesMap[][]={
	                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,0,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,0,-1,-1,0,-1,0,-1,-1,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,-1,0,-1,-1,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,-1,0,-1,-1,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,-1,0,0,0,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,-1,-1,-1,0,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,-1,-1,-1,0,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,-1,-1,-1,0,0,0,-1,0,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,-1,-1,-1,0,-1,0,-1,-1,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,-1,-1,-1,0,-1,0,-1,-1,-1,0,0,0,0,0,0,0,0,0,0},
	                {-1,-1,-1,-1,0,-1,0,-1,-1,-1,0,0,0,0,0,0,0,0,0,0}
	        };
			return tilesMap; 
		} else if (currentLevel == 2) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][]={
	                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,-1,-1,0,-1,-1,-1,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,-1,-1,-1,-1,-1,-1,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,-1,-1,-1,-1,-1,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,0,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,0,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,0,-1,-1,-1,-1,0,0,0,-1,0,0,0,0,0,-1,-1},
	                {-1,0,0,0,0,-1,-1,0,0,-1,0,0,0,0,0,-1,-1},
	                {-1,-1,-1,-1,0,-1,-1,0,0,-1,0,0,0,0,0,-1,-1},
	                {-1,-1,-1,-1,0,0,-1,0,0,-1,0,0,0,0,0,-1,-1},
	                {0,0,0,-1,-1,-1,-1,0,0,-1,-1,-1,-1,-1,-1,-1,-1},
	                {0,0,0,-1,-1,-1,-1,0,0,-1,-1,-1,-1,-1,-1,-1,-1}
	        };
			return tilesMap; 
		} else if (currentLevel == 3) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][]={
	                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,-1,-1,0,-1,-1,-1,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,-1,-1,-1,-1,-1,-1,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,-1,-1,-1,-1,-1,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,0,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,0,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,0,-1,-1,-1,-1,0,0,0,-1,0,0,0,0,0,-1,-1},
	                {-1,0,0,0,0,-1,-1,0,0,-1,0,0,0,0,0,-1,-1},
	                {-1,-1,-1,-1,0,-1,-1,0,0,-1,0,0,0,0,0,-1,-1},
	                {-1,-1,-1,-1,0,0,-1,0,0,-1,0,0,0,0,0,-1,-1},
	                {0,0,0,-1,-1,-1,-1,0,0,-1,-1,-1,-1,-1,-1,-1,-1},
	                {0,0,0,-1,-1,-1,-1,0,0,-1,-1,-1,-1,-1,-1,-1,-1}
	        };
			return tilesMap; 
		} else if (currentLevel == 4) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][]={
	                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,-1,-1,0,-1,-1,-1,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,-1,-1,-1,-1,-1,-1,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,-1,-1,-1,-1,-1,0,0,0,0,0,0,0},
	                {-1,0,-1,-1,0,0,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,0,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	                {-1,0,-1,-1,-1,-1,0,0,0,-1,0,0,0,0,0,-1,-1},
	                {-1,0,0,0,0,-1,-1,0,0,-1,0,0,0,0,0,-1,-1},
	                {-1,-1,-1,-1,0,-1,-1,0,0,-1,0,0,0,0,0,-1,-1},
	                {-1,-1,-1,-1,0,0,-1,0,0,-1,0,0,0,0,0,-1,-1},
	                {0,0,0,-1,-1,-1,-1,0,0,-1,-1,-1,-1,-1,-1,-1,-1},
	                {0,0,0,-1,-1,-1,-1,0,0,-1,-1,-1,-1,-1,-1,-1,-1}
	        };
			return tilesMap; 
		} else {
			System.out.println("Geen level gevonden!");
			return null;
		}

	}
}
