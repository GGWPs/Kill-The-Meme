package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.objects.GameObject;
import processing.core.PGraphics;

@SuppressWarnings("serial")
public class Menu extends GameObject {
	private char[] alfabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private int currentLevel;
	private MainGame mainGame;
	private int maxNaamLengte = 15;
	private int menuKnopX = 80;
	private int menuKnopY = 30;
	private String naamTekst, tekst;
	private int worldWidth, worldHeight;

	/**
	 * menu constructor
	 * 
	 * @param tekst
	 * @param currentLevel huidige level
	 * @param worldWidth scherm breedte
	 * @param worldHeight scherm hoogte
	 */
	public Menu(MainGame mainGame, String tekst, int currentLevel, int worldWidth, int worldHeight) {
		this.mainGame = mainGame;
		this.tekst = tekst;
		this.currentLevel = currentLevel;
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
	}

	/**
	 * Functie om de tekst te wijzigen
	 * 
	 * @param tekst menu tekst en dergelijke
	 */
	public void setText(String tekst) {
		this.tekst = tekst;
	}

	/**
	 * Functie om de naam te wijzigen
	 * 
	 * @param naamTekst String die de naam bevat
	 */
	public void setNaamText(String naamTekst) {
		this.naamTekst = naamTekst;
	}

	/**
	 * Functie die kijkt of er een knop is ingedrukt en om de naam in te
	 * voeren/retry knop te gebruiken op een andere manier dan muis. Checkt ook op
	 * max naam lengte
	 */
	@Override
	public void keyPressed(int keyCode, char key) {
		if (currentLevel == 0) {
			if (keyCode == BACKSPACE) {
				if (naamTekst.length() > 0) {
					naamTekst = naamTekst.substring(0, naamTekst.length() - 1);
				}
			} else if (keyCode == DELETE) {
				naamTekst = "";
			}
			for (int i = 0; i < alfabet.length; i++) {
				if ((key == alfabet[i]) && naamTekst.length() < maxNaamLengte) {
					naamTekst += key;
				}
			}
		}
		if (keyCode == ENTER) {
			if (currentLevel == 0) {
				mainGame.setCurrentName(naamTekst);
				mainGame.setCurrentLevel(1);
				mainGame.setupGame();
			} else if (currentLevel == -10) {
				mainGame.setCurrentLevel(1);
				mainGame.setupGame();
			}
		}
	}

	/**
	 * Draw methode van processing om het menu te tekenen.
	 */
	@Override
	public void draw(PGraphics g) {
		g.textAlign(g.CENTER, g.TOP);
		g.textSize(50);
		if (currentLevel == 0 || currentLevel == -1 || currentLevel == 6) {
			g.setSize(worldWidth, worldHeight);
			g.background(0);
			g.text(tekst, worldWidth / 2, worldHeight / 4);
			g.fill(255);
		}
		if (currentLevel == 0) {
			g.textSize(25);
			g.text("Naam: ", worldWidth / 2 - menuKnopX, (worldHeight / 40) * 18);
			g.fill(255);
			g.rect(worldWidth / 3, (worldHeight / 4) * 2, menuKnopX * 3, menuKnopY, 8);
			g.fill(0);
			g.textAlign(g.LEFT, g.TOP);
			g.text(naamTekst, worldWidth / 2 - menuKnopY * 4, ((worldHeight / 40) * 18) + menuKnopY);
			tekenKnoppen(g, worldWidth / 3, worldWidth / 2, (worldHeight / 3) * 2, "Next ", "Quit ");
		} else if (currentLevel == -1 || currentLevel == 6) {
			g.rect(worldWidth / 2, (worldHeight / 3) * 2, menuKnopX, menuKnopY, 8);
			g.rect(worldWidth / 3, (worldHeight / 3) * 2, menuKnopX, menuKnopY, 8);
			g.fill(0);
			tekenKnoppen(g, worldWidth / 3, worldWidth / 2, (worldHeight / 3) * 2, "Retry ", "Quit ");
		} else if (currentLevel == -10) {
			g.text(tekst, worldWidth / 2, worldHeight / 12);
			g.textSize(20);
			tekenKnoppen(g, worldWidth / 3, worldWidth / 2, (worldHeight / 3) * 2, "Terug ", "Start ");

			g.text("In ieder level is een doel te behalen om naar het volgende level te gaan.", worldWidth / 12,
					worldHeight / 5);
			g.text("Dit zijn objecten binnen het spel waar je mee te maken hebt.", worldWidth / 12,
					worldHeight / 5 + menuKnopY);

			g.text("Interactie:", menuKnopX / 2, worldWidth / 3 + menuKnopX);
			g.text("Powerup ", worldHeight / 4, worldHeight / 4 + menuKnopX);
			g.text("Speler", worldHeight / 2, worldHeight / 4 + menuKnopX);
			g.text("Vijand", worldWidth - (menuKnopX * 2), worldHeight / 4 + menuKnopX);

			g.text("Spatie", worldHeight / 4, worldWidth / 3 + menuKnopX);

			g.text("Pijltjestoetsen", worldWidth / 3, worldHeight / 2 + menuKnopY);
			g.text("W,A,S,D", worldWidth / 3, worldHeight / 2 + menuKnopY * 2);

			g.text("Schiet projectielen", worldWidth / 2 + worldWidth / 4, worldHeight / 2 + menuKnopY);
			g.text("(ontwijkt ze!)", worldWidth / 2 + worldWidth / 4, worldHeight / 2 + menuKnopY * 2);
		}
	}

	/*
	 * @param g processing PGraphics aX, eerste X coordinaat eerste knop bX tweede X
	 * coordinaat tweede knop cY allebei Y coordinaat van beide knoppen en tekst
	 * want ze zullen allebei dezelfde Y coordinaat hebben tekstA de tekst die de
	 * linker eerste knop heeft tekstB de tekst die de rechter tweede knop heeft
	 */
	public void tekenKnoppen(PGraphics g, int aX, int bX, int cY, String tekstA, String tekstB) {
		g.textSize(20);
		g.fill(255);
		g.rect(aX, cY, menuKnopX, menuKnopY, 8);
		g.rect(bX, cY, menuKnopX, menuKnopY, 8);
		g.fill(0);
		g.textAlign(g.LEFT, g.TOP);
		g.text(tekstA, aX + (menuKnopY / 2), cY);
		g.text(tekstB, bX + (menuKnopY / 2), cY);
		g.fill(255);
	}

	@Override
	public void update() {
	}

	/**
	 * Functie om de naam op te halen.
	 * 
	 * @return naamTekst de naam van de speler.
	 */
	public String getNaam() {
		return naamTekst;
	}

}
