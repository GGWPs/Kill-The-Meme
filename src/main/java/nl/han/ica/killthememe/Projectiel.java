package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Projectiel extends Aanval {
	public static int WIDTH = 20;

	/**
	 * Missile constructor 
	 * 
	 * @param maingGame
	 * @param sprite
	 */
	public Projectiel(MainGame mainGame, Sprite sprite, float direction, int speed) {
		super(mainGame, sprite, direction, speed);
	}

}
