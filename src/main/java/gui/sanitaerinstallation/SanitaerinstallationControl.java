package gui.sanitaerinstallation;

import java.util.ArrayList;
import java.util.List;

import business.kunde.KundeModel;
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

	public List<Integer> leseSanitaerinstallationSonderwuensche() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		//TODO Markierte Sonderwuensche auslesen
		return arrayList;
	}
	
	public boolean pruefeKonstellationSonderwuensche(List<Integer> sw){
		return true;
		//TODO Ueberpruefung fehlt noch
	}

	public void speichereKonstellation(List<Integer> ausgewaehlteWuensche) {
		System.out.println("Gespeichert!");
		//TODO Markierte Sonderwuensche abspeichern
	}
}
