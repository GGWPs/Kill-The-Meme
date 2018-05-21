package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class SpelerEenAanval extends Projectiel {
	
	/*
	 * @oparam mainGame referentie naar mainGame
	 * @param sprite de afbeelding van de aanval
	 * @param richting de richting van de projectiel
	 */
	public SpelerEenAanval(MainGame mainGame, Sprite sprite, float richting, float snelheid) {
		super(mainGame, new Sprite("src/main/java/nl/han/ica/killthememe/media/aanvallen/BaasEenAanval.png"), richting, snelheid);

	}
	/*
	 * (non-Javadoc)
	 * @see nl.han.ica.killthememe.Projectiel#gameObjectCollisionOccurred(java.util.List)
	 */
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Vijand) {
				((Vijand) go).verliesLeven();
				mainGame.deleteGameObject(this);
			}
		}

	}
}
