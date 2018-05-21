package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpSloop extends PowerUp{
	
	String powerNaam = "Sloop";
	
	public PowerUpSloop(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/PowerUpCopyAttack.png"), mainGame);
	}
	
	//
	public void gebruikPowerUp(float richting) {
		System.out.print("Speed");
	}
	
	
	@Override
	public String powerNaam() {
		return powerNaam;
	}

}
