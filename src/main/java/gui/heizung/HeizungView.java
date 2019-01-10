package gui.heizung;

import gui.basis.BasisView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HeizungView extends BasisView{
	
	private HeizungControl heizungControl;

    private Label lblFenster = new Label("Heizung 1");
    private TextField txtPreisFenster = new TextField();
    private Label lblEuroFenster = new Label("Euro");
    private CheckBox cbEuroFenster = new CheckBox();
    
    private Label lblFenster2 = new Label("Heizung 2");
    private TextField txtPreisFenster2 = new TextField();
    private Label lblEuroFenster2 = new Label("Euro");
    private CheckBox cbEuroFenster2 = new CheckBox();
    
    private Label lblFenster3 = new Label("Heizung 3");
    private TextField txtPreisFenster3 = new TextField();
    private Label lblEuroFenster3 = new Label("Euro");
    private CheckBox cbEuroFenster3 = new CheckBox();
    
    private Label lblFenster4 = new Label("Heizung 4");
    private TextField txtPreisFenster4 = new TextField();
    private Label lblEuroFenster4 = new Label("Euro");
    private CheckBox cbEuroFenster4 = new CheckBox();
    
    private Label lblFenster5 = new Label("Heizung 5");
    private TextField txtPreisFenster5 = new TextField();
    private Label lblEuroFenster5 = new Label("Euro");
    private CheckBox cbEuroFenster5 = new CheckBox();

    public HeizungView (HeizungControl heizungControl, Stage heizungStage){
    	super(heizungStage);
        this.heizungControl = heizungControl;
        heizungStage.setTitle("Sonderwünsche zu Fenster und Aussentüren");
                
	    this.initKomponenten();
	    this.leseHeizungSonderwuensche();
    }
  
    protected void initKomponenten(){
    	super.initKomponenten();   	
       	super.getLblSonderwunsch().setText("Fenster und Aussentüren");
       	super.getGridPaneSonderwunsch().add(lblFenster, 0, 1);
    	super.getGridPaneSonderwunsch().add(txtPreisFenster, 1, 1);
    	super.getGridPaneSonderwunsch().add(lblEuroFenster, 2, 1);
    	super.getGridPaneSonderwunsch().add(cbEuroFenster, 3, 1);
    	
       	super.getGridPaneSonderwunsch().add(lblFenster2, 0, 2);
    	super.getGridPaneSonderwunsch().add(txtPreisFenster2, 1, 2);
    	super.getGridPaneSonderwunsch().add(lblEuroFenster2, 2, 2);
    	super.getGridPaneSonderwunsch().add(cbEuroFenster2, 3, 2);
    	
       	super.getGridPaneSonderwunsch().add(lblFenster3, 0, 3);
    	super.getGridPaneSonderwunsch().add(txtPreisFenster3, 1, 3);
    	super.getGridPaneSonderwunsch().add(lblEuroFenster3, 2, 3);
    	super.getGridPaneSonderwunsch().add(cbEuroFenster3, 3, 3);
    	
       	super.getGridPaneSonderwunsch().add(lblFenster4, 0, 4);
    	super.getGridPaneSonderwunsch().add(txtPreisFenster4, 1, 4);
    	super.getGridPaneSonderwunsch().add(lblEuroFenster4, 2, 4);
    	super.getGridPaneSonderwunsch().add(cbEuroFenster4, 3, 4);
    	
    	super.getGridPaneSonderwunsch().add(lblFenster5, 0, 5);
    	super.getGridPaneSonderwunsch().add(txtPreisFenster5, 1, 5);
    	super.getGridPaneSonderwunsch().add(lblEuroFenster5, 2, 5);
    	super.getGridPaneSonderwunsch().add(cbEuroFenster5, 3, 5);
    	
    }  
    
	public void oeffneHeizungView(){ 
		super.oeffneBasisView();
	}
    
    private void leseHeizungSonderwuensche(){
    	this.heizungControl.leseHeizungSonderwuensche();
    }
    
  	protected void berechneUndZeigePreisSonderwuensche(){
  	}
 
  	protected void speichereSonderwuensche(){
  	} 	 	
}
