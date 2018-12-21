package main.java.gui.sanitaerinstallation;

import main.java.business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Sanitaerinstallation-Varianten
 * kontrolliert.
 */
public final class SanitaerinstallationControl {
	
	// das View-Objekt des Sanitaerinstallation-Fensters
	private SanitaerinstallationView sanitaerinstallationView;

	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum 
	 * Fenster fuer die Sonderwuensche zur Sanitaerinstallation.
	 * @param sanitaerinstallationStage, Stage fuer das View-Objekt zu den Sonderwuenschen zur Sanitaerinstallation
	 */
	public SanitaerinstallationControl(KundeModel kundeModel){  
	   	Stage stageSanitaerinstallation = new Stage();
    	stageSanitaerinstallation.initModality(Modality.APPLICATION_MODAL);
    	this.sanitaerinstallationView = new SanitaerinstallationView(this, stageSanitaerinstallation);
	}
	    
	/**
	 * macht das SanitaerinstallationView-Objekt sichtbar.
	 */
	public void oeffneSanitaerinstallationView(){ 
		this.sanitaerinstallationView.oeffneSanitaerinstallationView();
	}

	public void leseSanitaerinstallationSonderwuensche(){
    } 
	
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		return true;
	}
}
