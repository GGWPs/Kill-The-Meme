package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PVector;

public class Speler extends AnimatedSpriteObject implements ICollidableWithTiles, Beweeg {
    final int size=30;
	private int huidigLevel;
	private String naam;
	private char controls;
	private Level level;
	private MainGame mainGame;
	
	
	
	
	
	
	public Speler(MainGame mainGame) {
     //   super(new Sprite("src/main/java/nl/han/ica/killthememe/media/testsprite.png"),2);
        super(new Sprite("src/main/java/nl/han/ica/waterworld/media/player.png"),2);
        this.mainGame=mainGame;
        setCurrentFrameIndex(1);
        setFriction(0.02f);
	}


	
	void player() {
		
	}
	
	@Override
    public void update() {
        if (getX()<=0) {
            setxSpeed(0);
            setX(0);
        }
        if (getY()<=0) {
            setySpeed(0);
            setY(0);
        }
        if (getX()>=mainGame.getWidth()-size) {
            setxSpeed(0);
            setX(mainGame.getWidth() - size);
        }
        if (getY()>=mainGame.getHeight()-size) {
            setySpeed(0);
            setY(mainGame.getHeight() - size);
        }

    }
	
	@Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 3;
        if (keyCode == mainGame.LEFT) {
            beweeg(270, speed);
            setCurrentFrameIndex(0);
        }
        if (keyCode == mainGame.UP) {
            beweeg(0, speed);
        }
        if (keyCode == mainGame.RIGHT) {
            beweeg(90, speed);
            setCurrentFrameIndex(1);
        }
        if (keyCode == mainGame.DOWN) {
            beweeg(180, speed);
        }
        if (key == ' ') {
            System.out.println("Spatie!");
        }
    }
	
	@Override
		public void beweeg(int directionspeed, int speed){
		setDirectionSpeed(directionspeed, speed);
		}
	
	
	 @Override
	    public void tileCollisionOccurred(List<CollidedTile> collidedTiles)  {
	        PVector vector;

	        for (CollidedTile ct : collidedTiles) {
	            if (ct.theTile instanceof BoardsTile) {
	                if (ct.collisionSide == ct.TOP) {
	                    try {
	                        vector = mainGame.getTileMap().getTilePixelLocation(ct.theTile);
	                        setY(vector.y - getHeight());
	                    } catch (TileNotFoundException e) {
	                        e.printStackTrace();
	                    }
	                }
	                if (ct.collisionSide == ct.RIGHT) {
	                    try {
	                        vector = mainGame.getTileMap().getTilePixelLocation(ct.theTile);
	                        mainGame.getTileMap().setTile((int) vector.x / 50, (int) vector.y / 50, -1);
	                    } catch (TileNotFoundException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	
	

}
