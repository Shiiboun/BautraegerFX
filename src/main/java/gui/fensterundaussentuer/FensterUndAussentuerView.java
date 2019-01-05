package gui.fensterundaussentuer;

import gui.basis.BasisView;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class FensterUndAussentuerView extends BasisView{

	private FensterUndAussentuerControl fensterUndAussentuerControl;

    private Label lblFenster = new Label("Anzhal der Fenster");
    private TextField txtPreisFenster = new TextField();
    private Label lblEuroFenster = new Label("Euro");
    private CheckBox cbEuroFenster = new CheckBox();

    private Label lblAussentuer = new Label("Anzhal der Aussentüren");
    private TextField txtPreisAussentuer = new TextField();
    private Label lblEuroAussentuer = new Label("Euro");
    private CheckBox cbEuroAussentuer = new CheckBox();

    public FensterUndAussentuerView (FensterUndAussentuerControl fensterUndAussentuerControl, Stage fensterUndAussentuerStage){
    	super(fensterUndAussentuerStage);
        this.fensterUndAussentuerControl = fensterUndAussentuerControl;
        fensterUndAussentuerStage.setTitle("Sonderwünsche zu Fenster und Aussentüren");
                
	    this.initKomponenten();
	    this.leseGrundrissSonderwuensche();
    }
  
    protected void initKomponenten(){
    	super.initKomponenten(); 
       	super.getLblSonderwunsch().setText("Fenster und Aussentüren");
       	super.getGridPaneSonderwunsch().add(lblFenster, 0, 1);
    	super.getGridPaneSonderwunsch().add(txtPreisFenster, 1, 1);
    	super.getGridPaneSonderwunsch().add(lblEuroFenster, 2, 1);
    	super.getGridPaneSonderwunsch().add(cbEuroFenster, 3, 1);
    	
       	super.getGridPaneSonderwunsch().add(lblAussentuer, 0, 2);
    	super.getGridPaneSonderwunsch().add(txtPreisAussentuer, 1, 2);
    	super.getGridPaneSonderwunsch().add(lblEuroAussentuer, 2, 2);
    	super.getGridPaneSonderwunsch().add(cbEuroAussentuer, 3, 2);
    }  
    
	public void oeffneGrundrissView(){ 
		super.oeffneBasisView();
	}
    
    private void leseGrundrissSonderwuensche(){
    	this.fensterUndAussentuerControl.leseGrundrissSonderwuensche();
    }
    
  	protected void berechneUndZeigePreisSonderwuensche(){
  	}
 
  	protected void speichereSonderwuensche(){
  	} 	 	
 }


