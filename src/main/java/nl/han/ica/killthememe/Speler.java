package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PVector;

public class Speler extends AnimatedSpriteObject implements ICollidableWithTiles {
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
        setFriction(0.05f);
	}

	void beweeg() {
		
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
            setX(level.getWidth() - size);
        }
        if (getY()>=mainGame.getHeight()-size) {
            setySpeed(0);
            setY(level.getHeight() - size);
        }

    }
	
	@Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 5;
        if (keyCode == level.LEFT) {
            setDirectionSpeed(270, speed);
            setCurrentFrameIndex(0);
        }
        if (keyCode == level.UP) {
            setDirectionSpeed(0, speed);
        }
        if (keyCode == level.RIGHT) {
            setDirectionSpeed(90, speed);
            setCurrentFrameIndex(1);
        }
        if (keyCode == level.DOWN) {
            setDirectionSpeed(180, speed);
        }
        if (key == ' ') {
            System.out.println("Spatie!");
        }
    }
	
	
	 @Override
	    public void tileCollisionOccurred(List<CollidedTile> collidedTiles)  {
	        PVector vector;

	        for (CollidedTile ct : collidedTiles) {
	            if (ct.theTile instanceof BoardsTile) {
	                if (ct.collisionSide == ct.TOP) {
	                    try {
	                        vector = level.getTileMap().getTilePixelLocation(ct.theTile);
	                        setY(vector.y - getHeight());
	                    } catch (TileNotFoundException e) {
	                        e.printStackTrace();
	                    }
	                }
	                if (ct.collisionSide == ct.RIGHT) {
	                    try {
	                        vector = level.getTileMap().getTilePixelLocation(ct.theTile);
	                        level.getTileMap().setTile((int) vector.x / 50, (int) vector.y / 50, -1);
	                    } catch (TileNotFoundException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	
	

}
