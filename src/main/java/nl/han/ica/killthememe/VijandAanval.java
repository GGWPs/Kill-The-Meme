package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

public class VijandAanval extends Aanval{
	
	/*
	 * VijandAanval constructor
	 * 
	 * @param mainGame referentie naar maingame
	 * @param sprite referentie naar de sprite
	 */
	public VijandAanval(MainGame mainGame, Sprite sprite, float richting, float snelheid) {
		super(mainGame,sprite, richting,snelheid);
	}
	/**
	 * Update constant uitgevoerd en checkt of het object buiten zijn gebied komt.
	 * 
	 */
	@Override
	public void update() {
		if(mainGame.getCurrentLevel() == -10) {
			if (getY() < 0 || getY() > mainGame.getHeight() || 
					getX() < (mainGame.getWidth()/4)*3 || getX() > mainGame.getWidth()) {
				mainGame.deleteGameObject(this);
			}
		} else if (getY() < 0 || getY() > mainGame.getHeight() || 
				getX() < 0 || getX() > mainGame.getWidth()) {
			mainGame.deleteGameObject(this);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see nl.han.ica.killthememe.Projectiel#gameObjectCollisionOccurred(java.util.List)
	 */
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Speler) {
				((Speler) go).verliesLeven();
				mainGame.deleteGameObject(this);
			}
			if (go instanceof Vogel) {
				((Vogel) go).setVisible(false);
				mainGame.deleteGameObject(this);
			}
			if (go instanceof SpelerAanval) {
				mainGame.deleteGameObject(this);
			}
		}
	}
}
