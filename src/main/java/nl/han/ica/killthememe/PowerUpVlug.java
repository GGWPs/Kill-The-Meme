package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpVlug extends PowerUp{
	
	String powerNaam = "Speed";
	
	public PowerUpVlug(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/PowerUpCopyAttack.png"), mainGame);
	}
	
	//
	public void gebruikPowerUp(float richting) {
		System.out.print("Speed");
	}
	
	
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject go : collidedGameObjects) {
            if (go instanceof Speler) {
                ((Speler) go).setPowerup(this);
                ((Speler) go).setSpeed(4);
                setItemIsOpgepakt(true);
                setVisible(false);
            }
        }
    }
	
	
	@Override
	public String powerNaam() {
		return powerNaam;
	}

}
