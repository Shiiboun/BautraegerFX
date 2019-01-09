package gui.Innentuer;


import gui.basis.BasisView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu
 * den Innentueren bereitstellt.
 */
public class InnentuerView extends BasisView{

 	// das Control-Objekt des Außenanlage-Fensters
	private InnentuerControl innentuerControl;

	//---Anfang Attribute der grafischen Oberflaeche---
		//4.1 Abstellraum auf der Terrasse des EG
	    private Label lbl41
	        = new Label("Mehrpreis für die Ausführung eines Glasausschnitts(Klarglas) in einer Innentür");
	    private TextField txt41 	= new TextField();
	    private Label lbl41Anz 		= new Label("Euro je Tür");

	  //4.2 Abstellraum auf der Terrasse des EG
	    private Label lbl42
	        = new Label("Mehrpreis für die Ausführung eines Glasausschnitts(Milchglas) in einer Innentür");
	    private TextField txt42 	= new TextField();
	    private Label lbl42Anz		= new Label("Euro je Tür");

	  //4.2 Abstellraum auf der Terrasse des EG
	    private Label lbl43
	        = new Label("Innentür zur Garage als Holztür");
	    private TextField txt43 	= new TextField();
	    private Label lbl43Anz		= new Label("Euro je Tür");



	    //-------Ende Attribute der grafischen Oberflaeche-------

	    /**
	     * erzeugt ein InnentuerView-Objekt, belegt das zugehoerige Control
	     * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
	     * @param InnentuerControl InnentuerControl, enthaelt das zugehoerige Control
	     * @param Stage InnentuerStage, enthaelt das Stage-Objekt fuer diese View
	     */
	    public InnentuerView (InnentuerControl InnentuerControl, Stage InnentuerStage){
	    	super(InnentuerStage);
	        this.innentuerControl = InnentuerControl;
	        InnentuerStage.setTitle("Sonderwünsche zu Innentuer-Varianten");

		    this.initKomponenten();
		    this.leseInnentuerSonderwuensche();
	    }

		protected void initKomponenten() {
			// TODO Auto-generated method stub
			super.initKomponenten();
	       	super.getLblSonderwunsch().setText("Anzahl der Innentüren");

	       	//4.1
	       	super.getGridPaneSonderwunsch().add(lbl41, 0, 1);
	    	super.getGridPaneSonderwunsch().add(txt41, 1, 1);
	    	txt41.setText("460");
	    	txt41.setEditable(false);
	    	super.getGridPaneSonderwunsch().add(lbl41Anz, 2, 1);
	       	//4.2
	       	super.getGridPaneSonderwunsch().add(lbl42, 0, 2);
	    	super.getGridPaneSonderwunsch().add(txt42, 1, 2);
	    	txt42.setText("560");
	    	txt42.setEditable(false);
	    	super.getGridPaneSonderwunsch().add(lbl42Anz, 2, 2);
	    	//4.3
	       	super.getGridPaneSonderwunsch().add(lbl43, 0, 3);
	    	super.getGridPaneSonderwunsch().add(txt43, 1, 3);
	    	txt43.setText("660");
	    	txt43.setEditable(false);
	    	super.getGridPaneSonderwunsch().add(lbl43Anz, 2, 3);
		}



		 /**
		 * macht das Innentür-Objekt sichtbar.
		 */
		public void oeffneInnentuerView(){
			super.oeffneBasisView();
		}

	    private void leseInnentuerSonderwuensche(){
	    	this.innentuerControl.leseInnentuerSonderwuensche();
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
