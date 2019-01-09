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
    
    private Label lblFenster2 = new Label("Anzhal der Fenster");
    private TextField txtPreisFenster2 = new TextField();
    private Label lblEuroFenster2 = new Label("Euro");
    private CheckBox cbEuroFenster2 = new CheckBox();
    
    private Label lblFenster3 = new Label("Anzhal der Fenster");
    private TextField txtPreisFenster3 = new TextField();
    private Label lblEuroFenster3 = new Label("Euro");
    private CheckBox cbEuroFenster3 = new CheckBox();
    
    private Label lblFenster4 = new Label("Anzhal der Fenster");
    private TextField txtPreisFenster4 = new TextField();
    private Label lblEuroFenster4 = new Label("Euro");
    private CheckBox cbEuroFenster4 = new CheckBox();
    
    private Label lblFenster5 = new Label("Anzhal der Fenster");
    private TextField txtPreisFenster5 = new TextField();
    private Label lblEuroFenster5 = new Label("Euro");
    private CheckBox cbEuroFenster5 = new CheckBox();
    
    private Label lblFenster6 = new Label("Anzhal der Fenster");
    private TextField txtPreisFenster6 = new TextField();
    private Label lblEuroFenster6 = new Label("Euro");
    private CheckBox cbEuroFenster6 = new CheckBox();
    
    private Label lblFenster7 = new Label("Anzhal der Fenster");
    private TextField txtPreisFenster7 = new TextField();
    private Label lblEuroFenster7 = new Label("Euro");
    private CheckBox cbEuroFenster7 = new CheckBox();
    
    private Label lblFenster8 = new Label("Anzhal der Fenster");
    private TextField txtPreisFenster8 = new TextField();
    private Label lblEuroFenster8 = new Label("Euro");
    private CheckBox cbEuroFenster8 = new CheckBox();
    
    private Label lblFenster9 = new Label("Anzhal der Fenster");
    private TextField txtPreisFenster9 = new TextField();
    private Label lblEuroFenster9 = new Label("Euro");
    private CheckBox cbEuroFenster9 = new CheckBox();

    private Label lblAussentuer = new Label("Anzhal der Aussentüren");
    private TextField txtPreisAussentuer = new TextField();
    private Label lblEuroAussentuer = new Label("Euro");
    private CheckBox cbEuroAussentuer = new CheckBox();
    
    private Label lblAussentuer2 = new Label("Anzhal der Aussentüren");
    private TextField txtPreisAussentuer2 = new TextField();
    private Label lblEuroAussentuer2 = new Label("Euro");
    private CheckBox cbEuroAussentuer2 = new CheckBox();
    
    private Label lblAussentuer3 = new Label("Anzhal der Aussentüren");
    private TextField txtPreisAussentuer3 = new TextField();
    private Label lblEuroAussentuer3 = new Label("Euro");
    private CheckBox cbEuroAussentuer3 = new CheckBox();
    
    private Label lblAussentuer4 = new Label("Anzhal der Aussentüren");
    private TextField txtPreisAussentuer4 = new TextField();
    private Label lblEuroAussentuer4 = new Label("Euro");
    private CheckBox cbEuroAussentuer4 = new CheckBox();
    
    private Label lblAussentuer5 = new Label("Anzhal der Aussentüren");
    private TextField txtPreisAussentuer5 = new TextField();
    private Label lblEuroAussentuer5 = new Label("Euro");
    private CheckBox cbEuroAussentuer5 = new CheckBox();
    
    private Label lblAussentuer6 = new Label("Anzhal der Aussentüren");
    private TextField txtPreisAussentuer6 = new TextField();
    private Label lblEuroAussentuer6 = new Label("Euro");
    private CheckBox cbEuroAussentuer6 = new CheckBox();
    
    private Label lblAussentuer7 = new Label("Anzhal der Aussentüren");
    private TextField txtPreisAussentuer7 = new TextField();
    private Label lblEuroAussentuer7 = new Label("Euro");
    private CheckBox cbEuroAussentuer7 = new CheckBox();
    
    private Label lblAussentuer8 = new Label("Anzhal der Aussentüren");
    private TextField txtPreisAussentuer8 = new TextField();
    private Label lblEuroAussentuer8 = new Label("Euro");
    private CheckBox cbEuroAussentuer8 = new CheckBox();
    
    private Label lblAussentuer9 = new Label("Anzhal der Aussentüren");
    private TextField txtPreisAussentuer9 = new TextField();
    private Label lblEuroAussentuer9 = new Label("Euro");
    private CheckBox cbEuroAussentuer9 = new CheckBox();

    public FensterUndAussentuerView (FensterUndAussentuerControl fensterUndAussentuerControl, Stage fensterUndAussentuerStage){
    	super(fensterUndAussentuerStage);
        this.fensterUndAussentuerControl = fensterUndAussentuerControl;
        fensterUndAussentuerStage.setTitle("Sonderwünsche zu Fenster und Aussentüren");
                
	    this.initKomponenten();
	    this.leseFensterUndAussentuerViewSonderwuensche();
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
    	
       	super.getGridPaneSonderwunsch().add(lblFenster6, 0, 6);
    	super.getGridPaneSonderwunsch().add(txtPreisFenster6, 1, 6);
    	super.getGridPaneSonderwunsch().add(lblEuroFenster6, 2, 6);
    	super.getGridPaneSonderwunsch().add(cbEuroFenster6, 3, 6);
    	
       	super.getGridPaneSonderwunsch().add(lblFenster7, 0, 7);
    	super.getGridPaneSonderwunsch().add(txtPreisFenster7, 1, 7);
    	super.getGridPaneSonderwunsch().add(lblEuroFenster7, 2, 7);
    	super.getGridPaneSonderwunsch().add(cbEuroFenster7, 3, 7);
    	
       	super.getGridPaneSonderwunsch().add(lblFenster8, 0, 8);
    	super.getGridPaneSonderwunsch().add(txtPreisFenster8, 1, 8);
    	super.getGridPaneSonderwunsch().add(lblEuroFenster8, 2, 8);
    	super.getGridPaneSonderwunsch().add(cbEuroFenster8, 3, 8);
    	
       	super.getGridPaneSonderwunsch().add(lblFenster9, 0, 9);
    	super.getGridPaneSonderwunsch().add(txtPreisFenster9, 1, 9);
    	super.getGridPaneSonderwunsch().add(lblEuroFenster9, 2, 9);
    	super.getGridPaneSonderwunsch().add(cbEuroFenster9, 3, 9);
    	
       	super.getGridPaneSonderwunsch().add(lblAussentuer, 0, 10);
    	super.getGridPaneSonderwunsch().add(txtPreisAussentuer, 1, 10);
    	super.getGridPaneSonderwunsch().add(lblEuroAussentuer, 2, 10);
    	super.getGridPaneSonderwunsch().add(cbEuroAussentuer, 3, 10);
    	
       	super.getGridPaneSonderwunsch().add(lblAussentuer2, 0, 11);
    	super.getGridPaneSonderwunsch().add(txtPreisAussentuer2, 1, 11);
    	super.getGridPaneSonderwunsch().add(lblEuroAussentuer2, 2, 11);
    	super.getGridPaneSonderwunsch().add(cbEuroAussentuer2, 3, 11);
    	
       	super.getGridPaneSonderwunsch().add(lblAussentuer3, 0, 12);
    	super.getGridPaneSonderwunsch().add(txtPreisAussentuer3, 1, 12);
    	super.getGridPaneSonderwunsch().add(lblEuroAussentuer3, 2, 12);
    	super.getGridPaneSonderwunsch().add(cbEuroAussentuer3, 3, 12);
    	
       	super.getGridPaneSonderwunsch().add(lblAussentuer4, 0, 13);
    	super.getGridPaneSonderwunsch().add(txtPreisAussentuer4, 1, 13);
    	super.getGridPaneSonderwunsch().add(lblEuroAussentuer4, 2, 13);
    	super.getGridPaneSonderwunsch().add(cbEuroAussentuer4, 3, 13);
    	
       	super.getGridPaneSonderwunsch().add(lblAussentuer5, 0, 14);
    	super.getGridPaneSonderwunsch().add(txtPreisAussentuer5, 1, 14);
    	super.getGridPaneSonderwunsch().add(lblEuroAussentuer5, 2, 14);
    	super.getGridPaneSonderwunsch().add(cbEuroAussentuer5, 3, 14);
    	
       	super.getGridPaneSonderwunsch().add(lblAussentuer6, 0, 15);
    	super.getGridPaneSonderwunsch().add(txtPreisAussentuer6, 1, 15);
    	super.getGridPaneSonderwunsch().add(lblEuroAussentuer6, 2, 15);
    	super.getGridPaneSonderwunsch().add(cbEuroAussentuer6, 3, 15);
    	
       	super.getGridPaneSonderwunsch().add(lblAussentuer7, 0, 16);
    	super.getGridPaneSonderwunsch().add(txtPreisAussentuer7, 1, 16);
    	super.getGridPaneSonderwunsch().add(lblEuroAussentuer7, 2, 16);
    	super.getGridPaneSonderwunsch().add(cbEuroAussentuer7, 3, 16);
    	
       	super.getGridPaneSonderwunsch().add(lblAussentuer8, 0, 17);
    	super.getGridPaneSonderwunsch().add(txtPreisAussentuer8, 1, 17);
    	super.getGridPaneSonderwunsch().add(lblEuroAussentuer8, 2, 17);
    	super.getGridPaneSonderwunsch().add(cbEuroAussentuer8, 3, 17);
    	
       	super.getGridPaneSonderwunsch().add(lblAussentuer9, 0, 18);
    	super.getGridPaneSonderwunsch().add(txtPreisAussentuer9, 1, 18);
    	super.getGridPaneSonderwunsch().add(lblEuroAussentuer9, 2, 18);
    	super.getGridPaneSonderwunsch().add(cbEuroAussentuer9, 3, 18);
    	
    }  
    
	public void oeffneFensterUndAussentuerViewView(){ 
		super.oeffneBasisView();
	}
    
    private void leseFensterUndAussentuerViewSonderwuensche(){
    	this.fensterUndAussentuerControl.leseGrundrissSonderwuensche();
    }
    
  	protected void berechneUndZeigePreisSonderwuensche(){
  	}
 
  	protected void speichereSonderwuensche(){
  	} 	 	
 }


