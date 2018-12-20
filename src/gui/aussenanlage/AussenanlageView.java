package gui.aussenanlage;

import gui.basis.BasisView;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu 
 * den Au�enanlagevarianten bereitstellt.
 */
public class AussenanlageView extends BasisView{
 
 	// das Control-Objekt des Au�enanlage-Fensters
	private AussenanlageControl aussenanlageControl;
   
    //---Anfang Attribute der grafischen Oberflaeche---
	//9.1 Abstellraum auf der Terrasse des EG
    private Label lbl91    	     
        = new Label("Abstellraum auf der Terrasse des EG");
    private TextField txt91 	= new TextField();
    private Label lbl91euro 		= new Label("Euro");
    private CheckBox chckBx91 		= new CheckBox();
	//9.2 Vorbereitung f�r elektrische Antriebe Markise EG
    private Label lbl92    	     
        = new Label("Vorbereitung f�r elektrische Antriebe Markise EG");
    private TextField txt92 	= new TextField();
    private Label lbl92euro 		= new Label("Euro");
    private CheckBox chckBx92 		= new CheckBox();
	//9.3 Vorbereitung f�r elektrische Antriebe Markise DG
    private Label lbl93    	     
        = new Label("Vorbereitung f�r elektrische Antriebe Markise DG");
    private TextField txt93 	= new TextField();
    private Label lbl93euro 		= new Label("Euro");
    private CheckBox chckBx93 		= new CheckBox();
	//9.4 Elektrische Markise EG
    private Label lbl94    	     
        = new Label("Elektrische Markise EG");
    private TextField txt94 	= new TextField();
    private Label lbl94euro 		= new Label("Euro");
    private CheckBox chckBx94 		= new CheckBox();
	//9.5 Elektrische Markise DG
    private Label lbl95    	     
        = new Label("Elektrische Markise DG");
    private TextField txt95 	= new TextField();
    private Label lbl95euro 		= new Label("Euro");
    private CheckBox chckBx95 		= new CheckBox();
	//9.6 Elektrischen Antrieb f�r das Garagentor
    private Label lbl96    	     
        = new Label("Elektrischen Antrieb f�r das Garagentor");
    private TextField txt96 	= new TextField();
    private Label lbl96euro 		= new Label("Euro");
    private CheckBox chckBx96 		= new CheckBox();
	//9.7 Sektionaltor anstatt Schwingtor f�r die Garage
    private Label lbl97    	     
        = new Label("Sektionaltor anstatt Schwingtor f�r die Garage");
    private TextField txt97 	= new TextField();
    private Label lbl97euro 		= new Label("Euro");
    private CheckBox chckBx97 		= new CheckBox();
    //-------Ende Attribute der grafischen Oberflaeche-------
  
    /**
     * erzeugt ein Au�enanlageView-Objekt, belegt das zugehoerige Control
     * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
     * @param aussenanlageControl AussenanlageControl, enthaelt das zugehoerige Control
     * @param aussenanlageStage Stage, enthaelt das Stage-Objekt fuer diese View
     */
    public AussenanlageView (AussenanlageControl aussenanlageControl, Stage aussenanlageStage){
    	super(aussenanlageStage);
        this.aussenanlageControl = aussenanlageControl;
        aussenanlageStage.setTitle("Sonderw�nsche zu Au�enanlage-Varianten");
                
	    this.initKomponenten();
	    this.leseAussenanlageSonderwuensche();
    }
  
    /* initialisiert die Steuerelemente auf der Maske */
    protected void initKomponenten(){
    	super.initKomponenten(); 
       	super.getLblSonderwunsch().setText("Au�enanlage-Varianten");

       	//9.1
       	super.getGridPaneSonderwunsch().add(lbl91, 0, 1);
    	super.getGridPaneSonderwunsch().add(txt91, 1, 1);
    	txt91.setText("3.590,-");
    	txt91.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lbl91euro, 2, 1);
    	super.getGridPaneSonderwunsch().add(chckBx91, 3, 1);
    	chckBx91.setOnAction(e -> {
			aussenanlageControl.boxClicked(91, chckBx91.isSelected());
		});
       	//9.2
       	super.getGridPaneSonderwunsch().add(lbl92, 0, 2);
    	super.getGridPaneSonderwunsch().add(txt92, 1, 2);
    	txt92.setText("170,-");
    	txt92.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lbl92euro, 2, 2);
    	super.getGridPaneSonderwunsch().add(chckBx92, 3, 2);
    	chckBx92.setOnAction(e -> {
			aussenanlageControl.boxClicked(92, chckBx92.isSelected());
		});
       	//9.3
       	super.getGridPaneSonderwunsch().add(lbl93, 0, 3);
    	super.getGridPaneSonderwunsch().add(txt93, 1, 3);
    	txt93.setText("170,-");
    	txt93.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lbl93euro, 2, 3);
    	super.getGridPaneSonderwunsch().add(chckBx93, 3, 3);
    	chckBx93.setOnAction(e -> {
			aussenanlageControl.boxClicked(93, chckBx93.isSelected());
		});
       	//9.4
       	super.getGridPaneSonderwunsch().add(lbl94, 0, 4);
    	super.getGridPaneSonderwunsch().add(txt94, 1, 4);
    	txt94.setText("890,-");
    	txt94.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lbl94euro, 2, 4);
    	super.getGridPaneSonderwunsch().add(chckBx94, 3, 4);
    	chckBx94.setOnAction(e -> {
			aussenanlageControl.boxClicked(94, chckBx94.isSelected());
		});
       	//9.5
       	super.getGridPaneSonderwunsch().add(lbl95, 0, 5);
    	super.getGridPaneSonderwunsch().add(txt95, 1, 5);
    	txt95.setText("890,-");
    	txt95.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lbl95euro, 2, 5);
    	super.getGridPaneSonderwunsch().add(chckBx95, 3, 5);
    	chckBx95.setOnAction(e -> {
			aussenanlageControl.boxClicked(95, chckBx95.isSelected());
		});
       	//9.6
       	super.getGridPaneSonderwunsch().add(lbl96, 0, 6);
    	super.getGridPaneSonderwunsch().add(txt96, 1, 6);
    	txt96.setText("990,-");
    	txt96.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lbl96euro, 2, 6);
    	super.getGridPaneSonderwunsch().add(chckBx96, 3, 6);
    	chckBx96.setOnAction(e -> {
			aussenanlageControl.boxClicked(96, chckBx96.isSelected());
		});
       	//9.7
       	super.getGridPaneSonderwunsch().add(lbl97, 0, 7);
    	super.getGridPaneSonderwunsch().add(txt97, 1, 7);
    	txt97.setText("790,-");
    	txt97.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lbl97euro, 2, 7);
    	super.getGridPaneSonderwunsch().add(chckBx97, 3, 7);
    	chckBx97.setOnAction(e -> {
			aussenanlageControl.boxClicked(97, chckBx97.isSelected());
		});
    }  
    
    /**
	 * macht das AussenanlageView-Objekt sichtbar.
	 */
	public void oeffneAussenanlageView(){ 
		super.oeffneBasisView();
	}
    
    private void leseAussenanlageSonderwuensche(){
    	this.aussenanlageControl.leseAussenanlageSonderwuensche();
    }
    
 	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
  	protected void berechneUndZeigePreisSonderwuensche(){
  		aussenanlageControl.berechneUndZeigePreisSonderwuensche();
  	}
  	
   	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
  	protected void speichereSonderwuensche(){
  		aussenanlageControl.speichereSonderwuensche();
  	}
  	
 	
 }


