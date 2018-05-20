package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpHeal extends PowerUp {

	public PowerUpHeal(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/PowerUpCopyAttack.png"), mainGame);
	}
	
	//niet gebruikt
	public void gebruikPowerUp() {
		
	}
}
