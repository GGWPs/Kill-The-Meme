package nl.han.ica.killthememe;

import java.net.URL;

public class Level {
	private MainGame mainGame;
	private static URL levelTile = Level.class.getResource("/boards.jpg");
	private static URL menuZwart = Level.class.getResource("/menuZwart.png");
	private static URL tiles1 = Level.class.getResource("/tiles1.jpg");
	private static URL fccAcht = Level.class.getResource("/fccachtergrond.jpg");

	/**
	 * Level constructor
	 * 
	 * @param currentLevel de huidige level.
	 */
	public Level(MainGame mainGame) {
		this.mainGame = mainGame;
	}

	/**
	 * Functie die per level een andere tile kan uitkiezen of te wel een andere
	 * muur.
	 * 
	 * @return tile locatie
	 */
	public String pickLevelTile() {
		return levelTile.toString();
	}

	/**
	 * Functie die de achtergrond voor de level ophaalt.
	 * 
	 * @param currentLevel
	 * @return achtergrond level
	 */
	public String pickBackground(int currentLevel) {
		if (currentLevel == 0 || currentLevel == -1 || currentLevel == 6 || currentLevel == -10) {
			return menuZwart.toString();
		} else if (currentLevel >= 1 && currentLevel <= 4) {
			return tiles1.toString();
		} else if (currentLevel == 5) {
			return fccAcht.toString();
		} else {
			return menuZwart.toString();
		}
	}

	/*
	 * Methode die returnt wat de huidige level doel is.
	 * 
	 * @param int currentLevel de huidige level.
	 * 
	 */
	public String doel(int currentLevel) {
		if (currentLevel == 1) {
			return "Bereik het einde van de level!";
		} else if (currentLevel == 2) {
			return "Gebruik de powerup en versla de vijand!";
		} else if (currentLevel == 3) {
			return "Gebruik de powerup en bereik het einde!";
		} else if (currentLevel == 4) {
			return "Gebruik de powerup en bereik het einde!";
		} else if (currentLevel == 5) {
			return "Overleef!";
		} else {
			return " ";
		}
	}

	/**
	 * Functie die de tilemap teruggeeft bij de bijhorende level.
	 * 
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
			int tilesMap[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, 0, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
					{ -1, 0, -1, -1, 0, -1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, 0, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, 0, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, 0, -1, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, 0, -1, -1, 0, -1, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, -1, -1, -1, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, -1, -1, -1, 0, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, -1, -1, -1, 0, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }

			};
			return tilesMap;
		} else if (currentLevel == 4) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0 },
					{ 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0 },
					{ 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
			return tilesMap;
		} else if (currentLevel == 5) {
			System.out.println("Level" + currentLevel);
			int tilesMap[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 },
					{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 },
					{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 },
					{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 },
					{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 },
					{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 },
					{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 },
					{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 },
					{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
			return tilesMap;
		} else {
			System.out.println("Geen level!");
			return null;
		}

	}

	/**
	 * 
	 * Voegt verschillende PowerUps toe aan het level
	 * 
	 * @param currentLevel voor huidige level
	 * 
	 */
	public void addPowerUp(int currentLevel) {
		if (currentLevel == -10) {
			mainGame.addGameObject(new PowerUpProjectiel(mainGame), 600 / 4, 250);
		} else if (currentLevel == 2) {
			mainGame.addGameObject(new PowerUpProjectiel(mainGame), 0, 300);
		} else if (currentLevel == 3) {
			mainGame.addGameObject(new PowerUpVlug(mainGame), 0, 300);
		} else if (currentLevel == 4) {
			mainGame.addGameObject(new PowerUpSloop(mainGame), 100, 300);
			mainGame.addGameObject(new PowerUpLeven(mainGame), 650, 250);
		}
	}

	/*
	 * Functie die de vijanden voor het level teruggeeft.
	 * 
	 * @param int currentLevel de huidige level
	 */
	public Vijand[] getVijanden(int currentLevel) {
		if (currentLevel == -10) {
			Vijand[] vijanden = { new BaasA(mainGame, 650, 250) };
			return vijanden;
		} else if (currentLevel == 1) {
			Vijand[] vijanden = { new BaasA(mainGame, 220, 500) };
			return vijanden;
		} else if (currentLevel == 2) {
			Vijand[] vijanden = { new BaasB(mainGame, 700, 500) };
			return vijanden;
		} else if (currentLevel == 3) {
			Vijand[] vijanden = { new BaasB(mainGame, 700, 500), new BaasB(mainGame, 600, 500),
					new BaasA(mainGame, 500, 500), new BaasA(mainGame, 400, 500) };
			return vijanden;
		} else if (currentLevel == 5) {
			Vijand[] vijanden = { new BaasC(mainGame, 700, 500) };
			return vijanden;
		}
		return null;
	}

}
