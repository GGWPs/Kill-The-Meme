package nl.han.ica.killthememe;

public class LevelEen extends Level {

	public LevelEen(int currentLevel) {
		super(currentLevel);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String pickBackground(int currentLevel) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
	}
}
