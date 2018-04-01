package nl.han.ica.killthememe;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Speler extends AnimatedSpriteObject implements ICollidableWithTiles {
	private int size;
	private int huidigLevel;
	private String naam;
	private char controls;
	private Level level;
	
	
	
	
	
	
	public Speler(Level level) {
        super(new Sprite("src/main/java/nl/han/ica/waterworld/media/player.png"),2);
        this.level=level;
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
        if (getX()>=level.getWidth()-size) {
            setxSpeed(0);
            setX(level.getWidth() - size);
        }
        if (getY()>=level.getHeight()-size) {
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
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		// TODO Auto-generated method stub
		
	}
	
	

}
