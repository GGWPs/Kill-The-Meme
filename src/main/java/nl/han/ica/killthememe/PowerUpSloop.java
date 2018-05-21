package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpSloop extends PowerUp{
	
	String powerNaam = "Sloop";
	
	public PowerUpSloop(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/powerups/PowerUpSloop.png"), mainGame);
	}
	
	//
	public void gebruikPowerUp(float richting) {
		System.out.print("Sloop");
	}
	
	
	@Override
	public String powerNaam() {
		return powerNaam;
	}

}
