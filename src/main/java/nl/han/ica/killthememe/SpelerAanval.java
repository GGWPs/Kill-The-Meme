package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.objects.Sprite;

public class SpelerAanval extends Aanval {
	
	/*
	 * SpelerEenAanval constructor
	 * 
	 * @oparam mainGame referentie naar mainGame
	 * @param sprite de afbeelding van de aanval
	 * @param richting de richting van de aanval
	 * @param snelheid van de aanval
	 */
	public SpelerAanval(MainGame mainGame, Sprite sprite, float richting, float snelheid) {
		super(mainGame, new Sprite("src/main/java/nl/han/ica/killthememe/media/aanvallen/BaasAAanval.png"), richting, snelheid);

	}
	/*
	 * (non-Javadoc) functie die kijkt of de projectiel tegen een speler aankomt.
	 * @see nl.han.ica.killthememe.Projectiel#gameObjectCollisionOccurred(java.util.List)
	 */
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Vijand) {
				((Vijand) go).verliesLeven();
				mainGame.deleteGameObject(this);
			}
			if (go instanceof Vogel) {
				((Vogel) go).setVisible(false);
				mainGame.deleteGameObject(this);
			}
			if (go instanceof VijandAanval) {
				mainGame.deleteGameObject(this);
			}
		}

	}
}
