package main.java.gui.kunde;

import java.sql.SQLException;

import main.java.business.kunde.Kunde;
import main.java.business.kunde.KundeModel;
import main.java.gui.grundriss.GrundrissControl;
import main.java.gui.parkett.ParkettControl;
import main.java.gui.sanitaerinstallation.SanitaerinstallationControl;
import main.java.gui.aussenanlage.AussenanlageControl;
import main.java.gui.Innentuer.InnentuerControl;
import main.java.gui.fliesen.FliesenControl;
import javafx.stage.Stage;

/**
 * Klasse, welche das Grundfenster mit den Kundendaten kontrolliert.
 */
public class KundeControl {
       
    // das View-Objekt des Grundfensters mit den Kundendaten
	private KundeView kundeView;
    // das Model-Objekt des Grundfensters mit den Kundendaten
    private KundeModel kundeModel;
    /* das GrundrissControl-Objekt fuer die Sonderwuensche
    zum Grundriss zu dem Kunden */
	private GrundrissControl grundrissControl;
	/* das ParkettControl-Objekt fuer die Sonderwuensche
	 zum Parkett zu dem Kunden */
	private ParkettControl parkettControl;
	/* das SanitaerinstallationControl-Objekt fuer die Sonderwuensche
	 zur Sanitaerinstallation zu dem Kunden */
	private SanitaerinstallationControl sanitaerinstallationControl;
    /* das AussenanlageControl-Objekt fuer die Sonderwuensche
    	zur Aussenanlage zu dem Kunden */
    private AussenanlageControl aussenanlageControl;
    /* das AussenanlageControl-Objekt fuer die Sonderwuensche
	der Innent�ren zu dem Kunden */
    private InnentuerControl innentuerControl;
    /* das FliesenControl-Objekt fuer die Sonderwuensche
	zu Fliesen */
    private FliesenControl fliesenControl;
    
    /**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum 
	 * Grundfenster mit den Kundendaten.
	 * @param primaryStage, Stage fuer das View-Objekt zu dem Grundfenster mit den Kundendaten
	 */
    public KundeControl(Stage primaryStage) {
		this.kundeModel = KundeModel.getInstance();
        this.kundeView = new KundeView(this, primaryStage, kundeModel);
    }
    
    /*
     * erstellt, falls nicht vorhanden, ein Grundriss-Control-Objekt.
     * Das GrundrissView wird sichtbar gemacht.
     */
    public void oeffneGrundrissControl(){
    	if (this.grundrissControl == null){
    		this.grundrissControl = new GrundrissControl(kundeModel);
      	}
    	this.grundrissControl.oeffneGrundrissView();
    }
    
    /*
     * erstellt, falls nicht vorhanden, ein Parkett-Control-Objekt.
     * Das ParkettView wird sichtbar gemacht.
     */
    public void oeffneParkettControl(){
    	if (this.parkettControl == null){
    		this.parkettControl = new ParkettControl(kundeModel);
      	}
    	this.parkettControl.oeffneParkettView();
    }
    /*
     * erstellt, falls nicht vorhanden, ein Sanitaerinstallation-Control-Objekt.
     * Das SanitaerinstallationView wird sichtbar gemacht.
     */
    public void oeffneSanitaerinstallationControl(){
    	if (this.sanitaerinstallationControl == null){
    		this.sanitaerinstallationControl = new SanitaerinstallationControl(kundeModel);
      	}
        this.sanitaerinstallationControl.oeffneSanitaerinstallationView();
    }

    public void oeffneAussenanlageControl(){
    	if (this.aussenanlageControl == null){
    		this.aussenanlageControl = new AussenanlageControl(kundeModel);
      	}
    	this.aussenanlageControl.oeffneAussenanlageView();
    }
    
    /*
     * erstellt, falls nicht vorhanden, ein Innentuer-Control-Objekt.
     * Das AussenanlageView wird sichtbar gemacht.
     */
    public void oeffneInnentuerControl(){
    	if (this.innentuerControl == null){
    		this.innentuerControl = new InnentuerControl(kundeModel);
      	}
    	this.innentuerControl.oeffneinnentuerView();
    }
    
    public void oeffneFliesenControl(){
    	if (this.fliesenControl == null){
    		this.fliesenControl = new FliesenControl(kundeModel);
      	}
    	this.fliesenControl.oeffneFliesenView();
    }
    
	/**
	 * speichert ein Kunde-Objekt in die Datenbank
	 * @param kunde, Kunde-Objekt, welches zu speichern ist
	 */
    public void speichereKunden(Kunde kunde){
      	try{
    		kundeModel.speichereKunden(kunde);
    	}
    	catch(SQLException exc){
    		exc.printStackTrace();
    		this.kundeView.zeigeFehlermeldung("SQLException",
                "Fehler beim Speichern in die Datenbank");
    	}
    	catch(Exception exc){
    		exc.printStackTrace();
    		this.kundeView.zeigeFehlermeldung("Exception",
                "Unbekannter Fehler");
    	}
    }

    public int getPlannummer() {
    	return kundeView.getPlannummer();
	}
}
