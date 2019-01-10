package gui.parkett;

import java.util.ArrayList;
import java.util.List;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Parkett-Varianten
 * kontrolliert.
 */
public final class ParkettControl {
	
	// das View-Objekt des Parkett-Fensters
	private ParkettView parkettView;

	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum 
	 * Fenster fuer die Sonderwuensche zur Parkett.
	 * @param parkettStage, Stage fuer das View-Objekt zu den Sonderwuenschen zur Parkett
	 */
	public ParkettControl(KundeModel kundeModel){  
	   	Stage stageParkett = new Stage();
    	stageParkett.initModality(Modality.APPLICATION_MODAL);
    	this.parkettView = new ParkettView(this, stageParkett);
	}
	    
	/**
	 * macht das ParkettView-Objekt sichtbar.
	 */
	public void oeffneParkettView(){ 
		this.parkettView.oeffneParkettView();
	}

	public List<Integer> leseParkettSonderwuensche() {
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
