package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpSpeed extends PowerUp{
	
	
	public PowerUpSpeed(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/PowerUpCopyAttack.png"), mainGame);
	}
	
	//niet gebruikt
	public void gebruikPowerUp() {
		speler.setSpeed(4);
	}
}
