package gui.fensterundaussentuer;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FensterUndAussentuerControl {

	private FensterUndAussentuerView fensterUndAussentuerView;

	public FensterUndAussentuerControl(KundeModel kundeModel){  
	   	Stage stageGrundriss = new Stage();
    	stageGrundriss.initModality(Modality.APPLICATION_MODAL);
    	this.fensterUndAussentuerView = new FensterUndAussentuerView(this, stageGrundriss);
	}

	public void oeffneFensterUndAussentuerView(){ 
		this.fensterUndAussentuerView.oeffneFensterUndAussentuerViewView();
	}

	public void leseGrundrissSonderwuensche(){
    } 
	
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		return true;
	}
}