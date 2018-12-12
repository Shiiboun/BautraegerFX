package gui.bild;

import business.bild.BildModel;
import javafx.stage.Modality;
import javafx.stage.Stage;
import business.kunde.KundeModel;

/**
 * Klasse, welche das Fenster mit dem Bild des Hauses kontrolliert.
 */
public class BildControl {
       
    // das View-Objekt des Fensters mit dem Bild des Hauses
	private BildView bildView;
    // das Model-Objekt des Fensters mit dem Bild
    private BildModel bildModel;
   
    /**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum 
	 * Fenster mit den Bild.
	 * @param primaryStage, Stage fuer das View-Objekt zu dem Fenster mit dem Bild
	 */
    public BildControl(KundeModel kundeModel) { 
        Stage stageBild = new Stage();
        stageBild.initModality(Modality.APPLICATION_MODAL);
        this.bildModel = BildModel.getInstance(); 
    	this.bildView = new BildView(this, stageBild, bildModel);
    }
    
    /**
	 * macht das BildView-Objekt sichtbar.
	 */
	public void oeffneBildView(int plannummer){ 
		this.bildView.oeffneBildView(plannummer);
	}
	
}
