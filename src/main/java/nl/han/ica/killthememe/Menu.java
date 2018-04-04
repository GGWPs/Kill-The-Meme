package nl.han.ica.killthememe;


import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;


@SuppressWarnings("serial")
public class Menu{
	//yeet
    private TextObject dashboardText;
    private IPersistence persistence;
    private int bubblesPopped;
    private MainGame mainGame;
	
    
    
    
	/**
	 * 
	 * @param mainGame
	 */
    public Menu(MainGame mainGame) {
		this.mainGame=mainGame;
	}

//	public void createDashboard(int dashboardWidth,int dashboardHeight) {
//        Dashboard dashboard = new Dashboard(0,0, dashboardWidth, dashboardHeight);
//        dashboardText = new TextObject("");
//        dashboard.addGameObject(dashboardText);
//        addDashboard(dashboard);
//    }

    public void initializePersistence() {
        persistence = new FilePersistence("main/java/nl/han/ica/waterworld/media/bubblesPopped.txt");
        if (persistence.fileExists()) {
            bubblesPopped = Integer.parseInt(persistence.loadDataString());
            refreshDasboardText();
        }
    }
    
    public void refreshDasboardText() {
        dashboardText.setText("Niggas popped: "+bubblesPopped);
    }
	
	

}
