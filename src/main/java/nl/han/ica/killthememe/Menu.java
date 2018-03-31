package nl.han.ica.killthememe;


import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.TextObject;


@SuppressWarnings("serial")
public class Menu extends MainGame{
	//yeet
    private TextObject dashboardText;
	

    public void createDashboard(int dashboardWidth,int dashboardHeight) {
        Dashboard dashboard = new Dashboard(0,0, dashboardWidth, dashboardHeight);
        dashboardText = new TextObject("",10);
        dashboard.addGameObject(dashboardText);
        addDashboard(dashboard);
    }

	
	
	

}
