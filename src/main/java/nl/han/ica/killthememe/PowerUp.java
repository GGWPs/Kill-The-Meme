package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUp extends Aanval {
	private String powerUpNaam;
	private Sprite powerUp;
	private boolean itemIsOpgepakt;

	public PowerUp(MainGame mainGame, String powerUpNaam) {
		super(mainGame, new Sprite("src/main/java/nl/han/ica/killthememe/media/PowerUpCopyAttack.png"), 0, 0);
		this.powerUpNaam = powerUpNaam;
		this.setItemIsOpgepakt(false);
	}

	public void spawnPowerUp() {
		PowerUp copy = new PowerUp(mainGame, powerUpNaam);
		mainGame.addGameObject(copy, 300, 300);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Speler) {
				itemIsOpgepakt = true;
				mainGame.deleteGameObject(this);

			}
		}

	}

	public boolean isItemIsOpgepakt() {
		return itemIsOpgepakt;
	}

	public void setItemIsOpgepakt(boolean itemIsOpgepakt) {
		this.itemIsOpgepakt = itemIsOpgepakt;
	}

}
