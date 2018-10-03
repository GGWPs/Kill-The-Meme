package nl.han.ica.killthememe;

public class LevelEen extends Level {

	public LevelEen(int currentLevel) {
		super(currentLevel);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String pickBackground(int currentLevel) {
		if (currentLevel == 0 || currentLevel == -1 || currentLevel == 6) {
			return "src/main/java/nl/han/ica/killthememe/media/menuZwart.png";
		} else if (currentLevel == 1) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
		} else if (currentLevel == 2) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
		} else if (currentLevel == 3) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
		} else if (currentLevel == 4) {
			return "src/main/java/nl/han/ica/killthememe/media/tiles1.jpg";
		} else if (currentLevel == 5) {
			return "src/main/java/nl/han/ica/killthememe/media/fccachtergrond.jpg";
		}  else {
			return "src/main/java/nl/han/ica/killthememe/media/menuZwart.png";
		}
	}
}
