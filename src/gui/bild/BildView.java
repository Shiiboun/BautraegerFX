package gui.bild;

import business.bild.*;
import gui.basis.BasisView;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit dem Bild bereitstellt.
 */
public class BildView extends BasisView{
 
	// das Control-Objekt des Fensters mit dem Bild
	private BildControl bildControl;
	// das Model-Objekt des Fensters mit dem Bild
	private BildModel bildModel;

    //---Anfang Attribute der grafischen Oberflaeche---
	private BorderPane borderPane 		= new BorderPane();
	private GridPane gridPane 			= new GridPane();
	private Label lblHaus    	      	= new Label("Bild Haus von Haus mit Plannummer ");
    private ImageView imageView;
    private Image img;
    private boolean fehlerAufgetreten;
    //-------Ende Attribute der grafischen Oberflaeche-------
  
    /**
     * erzeugt ein BildView-Objekt und initialisiert die Steuerelemente der Maske
     * @param bildControl KundeControl, enthaelt das zugehoerige Control
     * @param primaryStage Stage, enthaelt das Stage-Objekt fuer diese View
     * @param bildModel BildModel, enthaelt das zugehoerige Model
    */
    public BildView (BildControl bildControl, Stage primaryStage, 
    	BildModel bildModel){
    	super(primaryStage);
        this.bildControl = bildControl;
        this.bildModel = bildModel;
      
        primaryStage.setTitle(this.bildModel.getUeberschrift());	
	    //Scene scene = new Scene(borderPane, 550, 400);
	    //primaryStage.setScene(scene);
       // primaryStage.show();

	    this.initKomponenten();
	
    }

 
    /* initialisiert die Steuerelemente auf der Maske */
    protected void initKomponenten(){
    	super.initKomponenten();
    	super.getLblSonderwunsch().setText(lblHaus.getText().toString());
    }

 
   /** zeigt ein Fehlermeldungsfenster an
    * @param ueberschrift, Ueberschrift fuer das Fehlermeldungsfenster
    * @param meldung, String, welcher die Fehlermeldung enthaelt
    */
    public void zeigeFehlermeldung(String ueberschrift, String meldung){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Fehlermeldung");
        alert.setHeaderText(ueberschrift);
        alert.setContentText(meldung);
        alert.show();
    }

    /**
	 * macht das BildView-Objekt sichtbar.
	 */
	public void oeffneBildView(int plannummer){ 
	//	System.out.println("fehlerAufgetreten: " + fehlerAufgetreten);
		System.out.println("plannummer in oeffneBildView: " + plannummer);
		//if(!fehlerAufgetreten) {
			img = bildModel.getBild(plannummer);
	        if(img != null) {
	        	imageView = new ImageView(img);
	        	imageView.setFitHeight(300);
	        	imageView.setFitWidth(450);
	        	super.getGridPaneSonderwunsch().add(imageView, 0, 2);
	        	//imageView.fitWidthProperty().bind(primaryStage.widthProperty()); 
	            //borderPane.setCenter(imageView);
	        	super.getLblSonderwunsch().setText(lblHaus.getText().toString() + plannummer);
	        	super.oeffneBasisView();
	        }
	        else {
	        	zeigeFehlermeldung("Tut uns leid", "Zu dem Haus wurde kein Bild gefunden");
	        	fehlerAufgetreten = true;
	        	return;
	        }
	//	}
	//	fehlerAufgetreten = false;
	}
	
	@Override
	protected void berechneUndZeigePreisSonderwuensche() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	protected void speichereSonderwuensche() {
		// TODO Auto-generated method stub
		
	}

}


