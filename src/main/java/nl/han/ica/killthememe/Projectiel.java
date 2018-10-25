package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

public abstract class Projectiel extends Aanval {
	

	public static int WIDTH = 20;

	/**
	 * Projectiel Constructor 
	 * 
	 * @param mainGame referentie naar de wereld
	 * @param sprite referentie naar een sprite 
	 * @param richting referentie naar de richting
	 * @param snelheid referentie naar de snelheid van het projectiel
	 */
	public Projectiel(MainGame mainGame, Sprite sprite, float richting, float snelheid) {
		super(mainGame, sprite, richting, snelheid);
	}
	/*
	 * (non-Javadoc)
	 * @see nl.han.ica.killthememe.Aanval#update()
	 */
	@Override
	public void update() {
		if (getY() < 0 || getY() > mainGame.getHeight() || 
				getX() < 0 || getX() > mainGame.getWidth()) {
			mainGame.deleteGameObject(this);
		}
	}
	
	public abstract void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects);

}
