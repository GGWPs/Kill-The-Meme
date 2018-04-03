package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;


public class Projectiel extends Aanval{
		public static int WIDTH = 20;
		
		/**
		 * Missile constructor
		 * @param maingGame
		 * @param sprite
		 */
		public Projectiel(MainGame mainGame, Sprite sprite) {
			super(mainGame, sprite, 270, 10);
		}
		
		
//		@Override
//		public void update() {
//			if (mainGame.getX() <= getX()) {
//				mainGame.deleteGameObject(this);
//			}
//		}
    	
}
