package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class SpelerEenAanval extends Projectiel {
	private int damageDone;

	public SpelerEenAanval(MainGame mainGame, Sprite sprite, float richting, float snelheid) {
		super(mainGame, new Sprite("src/main/java/nl/han/ica/killthememe/media/BossEenAanval.png"), richting, snelheid);

	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof BaasEen) {
				if (mainGame.getCurrentLevel() == 1) {
					System.out.print("imgod");
					damageDone++;
					if (damageDone == 3) {

					}
				}
			}
		}

	}
}
