package nl.han.ica.killthememe;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import processing.core.PApplet;
//import waterworld.View;

//yeet


@SuppressWarnings("serial")
public class MainGame extends GameEngine{

//	Level level = new Level();
//	Menu menu = new Menu();
	
	public static void main(String[] args) {
		PApplet.main(new String[] {"nl.han.ica.killthememe.MainGame"});
		
	}
	
	@Override
	public void setupGame() {
		// TODO Auto-generated method stub
		 int worldWidth=1204;
	     int worldHeight=903;
	     
	     
//	     menu.createDashboard(worldWidth, 100);
	     createView(worldWidth, worldHeight);
		
	}

	/**
     * creert de view zonder viewport
     * @param screenWidth Breedte van het scherm
     * @param screenHeight Hoogte van het scherm
     */
    public void createView(int screenWidth, int screenHeight) {
        View view = new View(screenWidth,screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/killthememe/media/background.jpeg"));

        setView(view);
        size(screenWidth, screenHeight);
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
