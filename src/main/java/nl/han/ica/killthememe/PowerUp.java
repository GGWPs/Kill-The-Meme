package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class PowerUp extends SpriteObject implements ICollidableWithGameObjects{
	private String powerUpNaam;
	private Sprite powerUp;
	private MainGame mainGame;
	private boolean itemIsOpgepakt;

	public PowerUp(MainGame mainGame,String  powerUpNaam) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/PowerUpCopyAttack.png"));
		this.powerUpNaam = powerUpNaam;
		this.itemIsOpgepakt = false;
	}


	
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Speler) {
				System.out.print("item is opgepakt");
				itemIsOpgepakt = true;
				((Speler) go).setPowerup(this);
				setVisible(false);
			}
		}

	}

	public boolean isItemIsOpgepakt() {
		return itemIsOpgepakt;
	}

	public void setItemIsOpgepakt(boolean itemIsOpgepakt) {
		this.itemIsOpgepakt = itemIsOpgepakt;
	}



	
	public void update() {
		// TODO Auto-generated method stub
		
	}


	
	

}
