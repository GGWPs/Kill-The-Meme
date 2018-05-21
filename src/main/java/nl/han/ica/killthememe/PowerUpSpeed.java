package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpSpeed extends PowerUp{
	
	String powerNaam = "Speed";
	
	public PowerUpSpeed(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/PowerUpCopyAttack.png"), mainGame);
	}
	
	//
	public void gebruikPowerUp() {
		speler.setSpeed(4);
	}
	
	
	@Override
	public String powerNaam() {
		return "Speed";
	}

}
