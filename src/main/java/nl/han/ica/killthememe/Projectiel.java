package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Projectiel extends Aanval {
	

	public static int WIDTH = 20;

	/**
	 * Projectiel constructor 
	 * 
	 * @param maingGame
	 * @param sprite
	 */
	public Projectiel(MainGame mainGame, Sprite sprite) {
		super(mainGame, sprite, 180, 0.25f);
	}

}
