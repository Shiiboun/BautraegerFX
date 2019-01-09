package gui.grundriss;

import java.util.ArrayList;
import java.util.List;

import gui.basis.BasisView;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu
 * den Grundrissvarianten bereitstellt.
 */
public class GrundrissView extends BasisView{

 	// das Control-Objekt des Grundriss-Fensters
	private GrundrissControl grundrissControl;

    //---Anfang Attribute der grafischen Oberflaeche---
	//Grundriss-Variante 1
	private Label lblGr61
    = new Label("Wand zur Abtrennung der Küche von dem Essbereich");
	private TextField txtGr61 	= new TextField();
	private Label lblGr61Euro 		= new Label("Euro");
	private CheckBox chckGr61 		= new CheckBox();
	//Grundriss-Variante 2
	private Label lblGr62
		= new Label("Tür in der Wand zwischen Küche und Essbereich");
	private TextField txtGr62	= new TextField();
	private Label lblGr62Euro 		= new Label("Euro");
	private CheckBox chckGr62		= new CheckBox();
	//Grundriss-Variante 3
	private Label lblGr63
		= new Label("Großes Zimmer im OG statt zwei kleinen Zimmern");
	private TextField txtGr63 	= new TextField();
	private Label lblGr63Euro 		= new Label("Euro");
	private CheckBox chckGr63 		= new CheckBox();
	//Grundriss-Variante 4
	private Label lblGr64
		= new Label("Abgetrennter Treppenraum im DG");
	private TextField txtGr64 	= new TextField();
	private Label lblGr64Euro 		= new Label("Euro");
	private CheckBox chckGr64 		= new CheckBox();
	//Grundriss-Variante 5
	private Label lblGr65
		= new Label("Vorrichtung eines Bades im DG");
	private TextField txtGr65 	= new TextField();
	private Label lblGr65Euro 		= new Label("Euro");
	private CheckBox chckGr65 		= new CheckBox();
	//Grundriss-Variante 6
	private Label lblGr66
		= new Label("Ausführung eines Bades im DG");
	private TextField txtGr66 	= new TextField();
	private Label lblGr66Euro 		= new Label("Euro");
	private CheckBox chckGr66 		= new CheckBox();

    //-------Ende Attribute der grafischen Oberflaeche-------

    /**
     * erzeugt ein GrundrissView-Objekt, belegt das zugehoerige Control
     * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
     * @param grundrissControl GrundrissControl, enthaelt das zugehoerige Control
     * @param grundrissStage Stage, enthaelt das Stage-Objekt fuer diese View
     */
    public GrundrissView (GrundrissControl grundrissControl, Stage grundrissStage){
    	super(grundrissStage);
        this.grundrissControl = grundrissControl;
        grundrissStage.setTitle("Sonderwünsche zu Grundriss-Varianten");

	    this.initKomponenten();
	    this.leseGrundrissSonderwuensche();
    }

    /* initialisiert die Steuerelemente auf der Maske */
    protected void initKomponenten(){
    	super.initKomponenten();
       	super.getLblSonderwunsch().setText("Grundriss-Varianten");
      //Grundriss-Variante 1
       	super.getGridPaneSonderwunsch().add(lblGr61, 0, 1);
    	super.getGridPaneSonderwunsch().add(txtGr61, 1, 1);
    	txtGr61.setText("300");
    	txtGr61.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblGr61Euro, 2, 1);
    	super.getGridPaneSonderwunsch().add(chckGr61, 3, 1);
      //Grundriss-Variante 2
    	super.getGridPaneSonderwunsch().add(lblGr62, 0, 2);
    	super.getGridPaneSonderwunsch().add(txtGr62, 1, 2);
    	txtGr62.setText("300");
    	txtGr62.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblGr62Euro, 2, 2);
    	super.getGridPaneSonderwunsch().add(chckGr62, 3, 2);
      //Grundriss-Variante 3
    	super.getGridPaneSonderwunsch().add(lblGr63, 0, 3);
    	super.getGridPaneSonderwunsch().add(txtGr63, 1, 3);
    	txtGr63.setText("0");
    	txtGr63.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblGr63Euro, 2, 3);
    	super.getGridPaneSonderwunsch().add(chckGr63, 3, 3);
      //Grundriss-Variante 4
    	super.getGridPaneSonderwunsch().add(lblGr64, 0, 4);
    	super.getGridPaneSonderwunsch().add(txtGr64, 1, 4);
    	txtGr64.setText("890");
    	txtGr64.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblGr64Euro, 2, 4);
    	super.getGridPaneSonderwunsch().add(chckGr64, 3, 4);
      //Grundriss-Variante 5
    	super.getGridPaneSonderwunsch().add(lblGr65, 0, 5);
    	super.getGridPaneSonderwunsch().add(txtGr65, 1, 5);
    	txtGr65.setText("990");
    	txtGr65.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblGr65Euro, 2, 5);
    	super.getGridPaneSonderwunsch().add(chckGr65, 3, 5);
      //Grundriss-Variante 6
    	super.getGridPaneSonderwunsch().add(lblGr66, 0, 6);
    	super.getGridPaneSonderwunsch().add(txtGr66, 1, 6);
    	txtGr66.setText("8990");
    	txtGr66.setEditable(false);
    	super.getGridPaneSonderwunsch().add(lblGr66Euro, 2, 6);
    	super.getGridPaneSonderwunsch().add(chckGr66, 3, 6);

    }

    /**
	 * macht das GrundrissView-Objekt sichtbar.
	 */
	public void oeffneGrundrissView(){
		super.oeffneBasisView();
	}

    private void leseGrundrissSonderwuensche(){
    	List<Integer> ar = this.grundrissControl.leseGrundrissSonderwuensche();
    	for (Integer integer : ar) {
           switch(integer){
           case 21:
        	   chckGr61.setSelected(true);
        	   break;
           case 22:
        	   chckGr62.setSelected(true);
        	   break;
           case 23:
        	   chckGr63.setSelected(true);
        	   break;
           case 24:
        	   chckGr64.setSelected(true);
        	   break;
           case 25:
        	   chckGr65.setSelected(true);
        	   break;
           case 26:
        	   chckGr66.setSelected(true);
        	   break;

           }
        }
    }



    private int[] getSelected(){
    	int[] selected = new int[6];
    	if(chckGr61.isSelected()) selected[0] = 21;
    	if(chckGr62.isSelected()) selected[1] = 22;
    	if(chckGr63.isSelected()) selected[2] = 23;
    	if(chckGr64.isSelected()) selected[3] = 24;
    	if(chckGr65.isSelected()) selected[4] = 25;
    	if(chckGr66.isSelected()) selected[5] = 26;
    	return selected;
    }

 	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
  	protected void berechneUndZeigePreisSonderwuensche(){
  		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann der Preis berechnet.

		int preis = 0;
		if(chckGr61.isSelected())
			preis += Integer.parseInt(txtGr61.getText());

		if(chckGr62.isSelected())
			preis += Integer.parseInt(txtGr62.getText());

		if(chckGr63.isSelected())
			preis += Integer.parseInt(txtGr63.getText());

		if(chckGr64.isSelected())
			preis += Integer.parseInt(txtGr64.getText());

		if(chckGr65.isSelected())
			preis += Integer.parseInt(txtGr65.getText());

		if(chckGr66.isSelected())
			preis += Integer.parseInt(txtGr66.getText());



  		if(grundrissControl.pruefeKonstellationSonderwuensche(getSelected())) {
			System.out.println("Keine konstellations Probleme!\nDer Gesamtpreis betraegt " + preis);
		}else{
			System.out.println("Diese Konstellation ist nicht moeglich!");
		}
  	}



   	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
  	protected void speichereSonderwuensche(){
 		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.
  		List<Integer> selected = new ArrayList<>();
  		int[] selectedArray = getSelected();
  		for(int i = 0; i<6; i++) selected.add(selectedArray[i]);

  		if(grundrissControl.pruefeKonstellationSonderwuensche(getSelected())) {
			grundrissControl.speichereSonderwuensche(selected);
		}else{
			System.out.println("Diese Konstellation ist nicht moeglich!");
		}
  	}


 }


