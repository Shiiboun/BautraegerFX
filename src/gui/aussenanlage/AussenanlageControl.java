package gui.aussenanlage;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den
 * Auﬂenanlage-Varianten
 * kontrolliert.
 */
public final class AussenanlageControl {

	// das View-Objekt des Aussenanlage-Fensters
	private AussenanlageView aussenanlageView;

	// Speicherte welche Boxen angehackt sind
	private boolean b91 = false;
	private boolean b92 = false;
	private boolean b93 = false;
	private boolean b94 = false;
	private boolean b95 = false;
	private boolean b96 = false;
	private boolean b97 = false;
	public int[] ausgewaehlteSw;
	private int counter;

	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum
	 * Fenster fuer die Sonderwuensche zur Auﬂenanlage.
	 * 
	 * @param aussenanlageStage,
	 *            Stage fuer das View-Objekt zu den Sonderwuenschen zur Auﬂenanlage
	 */
	public AussenanlageControl(KundeModel kundeModel) {
		Stage stageAussenanlage = new Stage();
		stageAussenanlage.initModality(Modality.APPLICATION_MODAL);
		this.aussenanlageView = new AussenanlageView(this, stageAussenanlage);
	}

	/**
	 * macht das AuﬂenanlageView-Objekt sichtbar.
	 */
	public void oeffneAussenanlageView() {
		this.aussenanlageView.oeffneAussenanlageView();
	}

	// wird aufgerufen wenn eine der Checkboxen angeklickt wird
	public void boxClicked(int id, boolean zustand) {
		switch (id) {
		case 91:
			b91 = !b91;
			break;
		case 92:
			b92 = !b92;
			break;
		case 93:
			b93 = !b93;
			break;
		case 94:
			b94 = !b94;
			break;
		case 95:
			b95 = !b95;
			break;
		case 96:
			b96 = !b96;
			break;
		case 97:
			b97 = !b97;
			break;
		default:
			System.out.println("Fehler beim Box anklicken bei der Aussananlagenauswahl!");
			break;
		}
		
		//loescht die ausgewaehlten Switches und befuellt sie neu
		int[] speicher = new int[7];
		counter = 0;		
		if(b91) {
			speicher[counter] = 91;
			counter++;
		}
		if(b92) {
			speicher[counter] = 92;
			counter++;
		}
		if(b93) {
			speicher[counter] = 93;
			counter++;
		}
		if(b94) {
			speicher[counter] = 94;
			counter++;
		}
		if(b95) {
			speicher[counter] = 95;
			counter++;
		}
		if(b96) {
			speicher[counter] = 96;
			counter++;
		}
		if(b97) {
			speicher[counter] = 97;
			counter++;
		}
		ausgewaehlteSw = new int[counter];
		for(int i = 0; i < counter; i++) {
			ausgewaehlteSw[i] = speicher[i];
		}	
	}

	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
	protected void berechneUndZeigePreisSonderwuensche() {
		// Not implemented yet
	}

	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
	protected void speichereSonderwuensche() {
		if(pruefeKonstellationSonderwuensche(ausgewaehlteSw)) {
			// Not implemented yet
		}
		else {
			System.out.println("Fehler beim speichern der AussenanlageSonderwuensche!");
		}
	}

	public void leseAussenanlageSonderwuensche() {
	}

	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw) {
		return true;
	}
}
