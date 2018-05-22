package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class PowerUpSloop extends PowerUp{
	
	private String powerNaam = "Sloop";
	
	/**
	 * PowerupSloop constructor
	 * 
	 * @param mainGame de wereld
	 */
	public PowerUpSloop(MainGame mainGame) {
		super(new Sprite("src/main/java/nl/han/ica/killthememe/media/powerups/PowerUpSloop.png"), mainGame);
	}
	
	/**
	 * Functie voor het gebruiken van de powerup, wordt niet gebruikt bij deze powerup.
	 */
	public void gebruikPowerUp(float richting) {
	}
	
	
	/**
	 * Functie voor het ophalen van de powerup naam
	 */
	@Override
	public String powerNaam() {
		return powerNaam;
	}

}
