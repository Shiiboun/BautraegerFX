package main.java.gui.fliesen;

	import main.java.gui.basis.BasisView;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

	/**
	 * Klasse, welche das Fenster mit den Sonderwuenschen zu 
	 * den Fliesen bereitstellt.
	 */
	public class FliesenView extends BasisView{
	 
	 	// das Control-Objekt des Fliesen-Fensters
		private FliesenControl fliesenControl;
	   
	    //---Anfang Attribute der grafischen Oberflaeche---
		//7.1 Keine Fliesen im Küchenbereich des EG
	    private Label lbl91    	     
	        = new Label("Keine Fliesen im Küchenbereich des EG");
	    private TextField txt91 	= new TextField();
	    private Label lbl91euro 		= new Label("Euro");
	    private CheckBox chckBx91 		= new CheckBox();
		//7.2 Keine Fliesen im Bad des OG
	    private Label lbl92    	     
	        = new Label("Keine Fliesen im Bad des OG");
	    private TextField txt92 	= new TextField();
	    private Label lbl92euro 		= new Label("Euro");
	    private CheckBox chckBx92 		= new CheckBox();
		//7.3 Mehrpreis bei großformatigen Fliesen im Küchenbereich des EG
	    private Label lbl93    	     
	        = new Label("Mehrpreis Großformatfliesen Küche EG");
	    private TextField txt93 	= new TextField();
	    private Label lbl93euro 		= new Label("Euro");
	    private CheckBox chckBx93 		= new CheckBox();
		//7.4 Mehrpreis bei großformatigen Fliesen im Bad des OG
	    private Label lbl94    	     
	        = new Label("Mehrpreis Großformatfliesen Bad OG");
	    private TextField txt94 	= new TextField();
	    private Label lbl94euro 		= new Label("Euro");
	    private CheckBox chckBx94 		= new CheckBox();
		//7.5 Fliesen im Bad des DG
	    private Label lbl95    	     
	        = new Label("Fliesen im Bad DG");
	    private TextField txt95 	= new TextField();
	    private Label lbl95euro 		= new Label("Euro");
	    private CheckBox chckBx95 		= new CheckBox();
		//7.6 Mehrpreis bei großformatigen Fliesen im Bad des DG
	    private Label lbl96    	     
	        = new Label("Mehrpreis Großformatfliesen Bad DG");
	    private TextField txt96 	= new TextField();
	    private Label lbl96euro 		= new Label("Euro");
	    private CheckBox chckBx96 		= new CheckBox();
	    //-------Ende Attribute der grafischen Oberflaeche-------
	  
	    
	    public FliesenView (FliesenControl fliesenControl, Stage fliesenStage){
	    	super(fliesenStage);
	        this.fliesenControl = fliesenControl;
	       fliesenStage.setTitle("Sonderwünsche zu Fliesen-Varianten");
	                
		    this.initKomponenten();
		    this.leseFliesenSonderwuensche();
	    }
	  
	    /* initialisiert die Steuerelemente auf der Maske */
	    protected void initKomponenten(){
	    	super.initKomponenten(); 
	       	super.getLblSonderwunsch().setText("Fliesen-Varianten");

	       	//7.1
	       	super.getGridPaneSonderwunsch().add(lbl91, 0, 1);
	    	super.getGridPaneSonderwunsch().add(txt91, 1, 1);
	    	txt91.setText("590");
	    	txt91.setEditable(false);
	    	super.getGridPaneSonderwunsch().add(lbl91euro, 2, 1);
	    	super.getGridPaneSonderwunsch().add(chckBx91, 3, 1);
	       	//7.2
	       	super.getGridPaneSonderwunsch().add(lbl92, 0, 2);
	    	super.getGridPaneSonderwunsch().add(txt92, 1, 2);
	    	txt92.setText("1870");
	    	txt92.setEditable(false);
	    	super.getGridPaneSonderwunsch().add(lbl92euro, 2, 2);
	    	super.getGridPaneSonderwunsch().add(chckBx92, 3, 2);
	       	//7.3
	       	super.getGridPaneSonderwunsch().add(lbl93, 0, 3);
	    	super.getGridPaneSonderwunsch().add(txt93, 1, 3);
	    	txt93.setText("170");
	    	txt93.setEditable(false);
	    	super.getGridPaneSonderwunsch().add(lbl93euro, 2, 3);
	    	super.getGridPaneSonderwunsch().add(chckBx93, 3, 3);
	       	//7.4
	       	super.getGridPaneSonderwunsch().add(lbl94, 0, 4);
	    	super.getGridPaneSonderwunsch().add(txt94, 1, 4);
	    	txt94.setText("190");
	    	txt94.setEditable(false);
	    	super.getGridPaneSonderwunsch().add(lbl94euro, 2, 4);
	    	super.getGridPaneSonderwunsch().add(chckBx94, 3, 4);
	       	//7.5
	       	super.getGridPaneSonderwunsch().add(lbl95, 0, 5);
	    	super.getGridPaneSonderwunsch().add(txt95, 1, 5);
	    	txt95.setText("2190");
	    	txt95.setEditable(false);
	    	super.getGridPaneSonderwunsch().add(lbl95euro, 2, 5);
	    	super.getGridPaneSonderwunsch().add(chckBx95, 3, 5);
	       	//7.6
	       	super.getGridPaneSonderwunsch().add(lbl96, 0, 6);
	    	super.getGridPaneSonderwunsch().add(txt96, 1, 6);
	    	txt96.setText("190");
	    	txt96.setEditable(false);
	    	super.getGridPaneSonderwunsch().add(lbl96euro, 2, 6);
	    	super.getGridPaneSonderwunsch().add(chckBx96, 3, 6);
	    }  
	    
	    /**
		 * macht das AussenanlageView-Objekt sichtbar.
		 */
		public void oeffneFliesenView(){ 
			super.oeffneBasisView();
		}
	    
	    private void leseFliesenSonderwuensche(){
	    	List<Integer> fliesenauswahl = this.fliesenControl.leseFliesenSonderwuensche();
		
	    	for (Integer integer : fliesenauswahl) {
				setFliesen(integer);
			}
	    }
	    
	    // setzt die Checkboxen je nach Sonderwünschen
	    public void setFliesen(int fnr) {
			switch(fnr) {
				case 71: chckBx91.setSelected(true); break;
				case 72: chckBx92.setSelected(true); break;
				case 73: chckBx93.setSelected(true); break;
				case 74: chckBx94.setSelected(true); break;
				case 75: chckBx95.setSelected(true); break;
				case 76: chckBx96.setSelected(true); break;
			}
		}
	    
	 	/* berechnet den Preis der ausgesuchten Fliesen und zeigt diesen an */
	  	protected void berechneUndZeigePreisSonderwuensche(){
	  		int dg = this.fliesenControl.dachgeschoss();
	  		
	  		if ((dg == 0)&&((chckBx95.isSelected()||(chckBx96.isSelected())))){
	  			Alert alert = new Alert(AlertType.ERROR);
	  	        alert.setTitle("Fliesen Preise");
	  	        alert.setHeaderText("Fehler!");
	  	        alert.setContentText("Sie haben gar kein Dachgeschoss!");
	  	        alert.show();
	  		} else {
	  			int preis = 0;
				int[] wunsch = new int[6];

		  		if (chckBx91.isSelected())
				{
		  			wunsch[0] = 1;
					preis += Integer.parseInt(txt91.getText());
				}
				if (chckBx92.isSelected())
				{
					wunsch[1] = 1;
					preis += Integer.parseInt(txt92.getText());
				}
				if (chckBx93.isSelected())
				{
					wunsch[2] = 1;
					preis += Integer.parseInt(txt93.getText());
				}
				if (chckBx94.isSelected())
				{
					wunsch[3] = 1;
					preis += Integer.parseInt(txt94.getText());
				}
				if (chckBx95.isSelected())
				{
					wunsch[4] = 1;
					preis += Integer.parseInt(txt95.getText());
				}
				if (chckBx96.isSelected())
				{
					wunsch[5] = 1;
					preis += Integer.parseInt(txt96.getText());
				}
				
		  		
	  			Alert alert = new Alert(AlertType.INFORMATION);
	  	        alert.setTitle("Fliesen Preise");
	  	        alert.setHeaderText("Der Preis Ihrer Wunschfliesen wurde berechnet");
	  	        alert.setContentText("Preis: "  + preis+ "€");
	  	        alert.show();
	  		}
	  		
	  		
			
	  	}
	  	
	   	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
	  	protected void speichereSonderwuensche(){
	  		int dg = this.fliesenControl.dachgeschoss();
	  		
	  		if ((dg == 0)&&((chckBx95.isSelected()||(chckBx96.isSelected())))){
	  			Alert alert = new Alert(AlertType.ERROR);
	  	        alert.setTitle("Fliesen Preise");
	  	        alert.setHeaderText("Fehler!");
	  	        alert.setContentText("Sie haben gar kein Dachgeschoss!");
	  	        alert.show();
	  		} else {
	  			fliesenControl.speichereFliesen(getWunschFliesen());
	  		}
	  	}
	  	
	  	private List<Integer> getWunschFliesen() {
			List<Integer> wunschFliesen = new ArrayList<>();

			if (chckBx91.isSelected()) wunschFliesen.add(71);
			if (chckBx92.isSelected()) wunschFliesen.add(72);
			if (chckBx93.isSelected()) wunschFliesen.add(73);
			if (chckBx94.isSelected()) wunschFliesen.add(74);
			if (chckBx95.isSelected()) wunschFliesen.add(75);
			if (chckBx96.isSelected()) wunschFliesen.add(76);
			return wunschFliesen;
		}
	  	
	 	
	 }


