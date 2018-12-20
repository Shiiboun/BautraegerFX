package gui.aussenanlage;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Außenanlage-Varianten
 * kontrolliert.
 */
public final class AussenanlageControl {
	
	// das View-Objekt des Aussenanlage-Fensters
	private AussenanlageView aussenanlageView;

	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum 
	 * Fenster fuer die Sonderwuensche zur Außenanlage.
	 * @param aussenanlageStage, Stage fuer das View-Objekt zu den Sonderwuenschen zur Außenanlage
	 */
	public AussenanlageControl(KundeModel kundeModel){  
	   	Stage stageAussenanlage = new Stage();
    	stageAussenanlage.initModality(Modality.APPLICATION_MODAL);
    	this.aussenanlageView = new AussenanlageView(this, stageAussenanlage);
	}
	    
	/**
	 * macht das AußenanlageView-Objekt sichtbar.
	 */
	public void oeffneAussenanlageView(){ 
		this.aussenanlageView.oeffneAussenanlageView();
	}

	public void leseAussenanlageSonderwuensche(){
    } 
	
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		return true;
	}
}
