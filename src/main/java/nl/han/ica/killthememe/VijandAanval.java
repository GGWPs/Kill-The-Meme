package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class VijandAanval extends Projectiel{
	
	/*
	 * VijandAanval constructor
	 * 
	 * @param mainGame referentie naar maingame
	 * @param sprite referentie naar de sprite
	 */
	public VijandAanval(MainGame mainGame, Sprite sprite, float richting, float snelheid) {
		super(mainGame,sprite, richting,snelheid);
	}
	
	/*
	 * (non-Javadoc)
	 * @see nl.han.ica.killthememe.Projectiel#gameObjectCollisionOccurred(java.util.List)
	 */
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Speler) {
				mainGame.deleteGameObject(this);
				mainGame.setCurrentLevel(-1);
				mainGame.setupGame();
			}
		}
	}
}
