package nl.han.ica.killthememe;

public class Level {
	private MainGame mainGame;
	private Vijand vijand;

	/**
	 * Level constructor
	 * @param currentLevel de huidige level.
	 */
	public Level(MainGame mainGame) {
		this.mainGame = mainGame;
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
		if (currentLevel == 0 || currentLevel == -1 || currentLevel == 6 || currentLevel == -10) {
			return "src/main/java/nl/han/ica/killthememe/media/menuZwart.png";
		} else if (currentLevel >= 1 && currentLevel <= 4) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
		} else if (currentLevel == 5) {
			return "src/main/java/nl/han/ica/killthememe/media/fccachtergrond.jpg";
		}  else {
			return "src/main/java/nl/han/ica/killthememe/media/menuZwart.png";
		}
	}
	
	
	public String doel(int currentLevel) {
		if(currentLevel == 1) {
			return "Bereik het einde van de level!";
		} else if(currentLevel == 2) {
			return "Gebruik de powerup en versla de vijand!";
		} else if(currentLevel == 3) {
			return "Gebruik de powerup en bereik het einde!";
		} else if(currentLevel == 4) {
			return "Gebruik de powerup en bereik het einde!";
		} else if(currentLevel == 5) {
			return "Overleef!";
		} else {
			return " ";
		}
			
	}
	
	/**
	 * Functie die de tilemap teruggeeft bij de bijhorende level.
	 * @param currentLevel
	 * @return tilemap
	 */
	public int[][] getLevelTile(int currentLevel) {
		if (currentLevel == 0 || currentLevel == -1 || currentLevel == -10) {
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
	
	
	
//	public void addGame() {
//		mainGame.addGameObject(new Speler(mainGame, 0.4f), 10, 100);
//		mainGame.addGameObject(new Vogel(mainGame), 1000, 100);
//		mainGame.addGameObject(vijand = new BaasB(mainGame), 700, 500);
//		mainGame.addGameObject(new PowerUpProjectiel(mainGame), 0, 300);
//	}
//
//
//	public Vijand getVijand() {
//		return vijand;
//	}

	
	
	public void addPowerUp(int currentLevel) {
		if(currentLevel == 2) {
			mainGame.addGameObject(new PowerUpProjectiel(mainGame), 0, 300);
		}
		
	}
	
	public PowerUp[] getPowerUp(int currentLevel) {
		if(currentLevel == 2) {
			PowerUp[] powerarr = {new PowerUpProjectiel(mainGame)};
			return  powerarr; 
		} else if(currentLevel == 3) {
			PowerUp[] powerarr = {new PowerUpVlug(mainGame)};
			return  powerarr; 
		}
		
		return null;
	}
	
	public int[] getPowerXY(int currentLevel){
		if(currentLevel == 2) {
		int[] xy = {0,300};
		
		return xy;
		} else {
			return null;
		}
		
	}

	
	
	
	
}
