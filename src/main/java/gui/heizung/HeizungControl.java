package gui.heizung;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HeizungControl {

	private HeizungView heizungView;

	public HeizungControl(KundeModel kundeModel){  
	   	Stage stageGrundriss = new Stage();
    	stageGrundriss.initModality(Modality.APPLICATION_MODAL);
    	this.heizungView = new HeizungView(this, stageGrundriss);
	}

	public void oeffneHeizungView(){ 
		this.heizungView.oeffneHeizungView();
	}

	public void leseHeizungSonderwuensche(){
    } 
	
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		return true;
	}
}
