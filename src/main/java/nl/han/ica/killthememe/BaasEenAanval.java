package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class BaasEenAanval extends Projectiel{
	
	/*
	 * @param mainGame referentie naar maingame
	 * @param sprite voor de sprite
	 */
	public BaasEenAanval(MainGame mainGame, Sprite sprite, float richting, float snelheid) {
		super(mainGame,new Sprite("src/main/java/nl/han/ica/killthememe/media/BossEenAanval.png"), richting,snelheid);
		
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
