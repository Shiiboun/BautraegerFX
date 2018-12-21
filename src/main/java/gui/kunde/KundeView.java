package main.java.gui.kunde;

import main.java.business.kunde.*;

import main.java.gui.MySQLAccess;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Klasse, welche das Grundfenster mit den Kundendaten bereitstellt.
 */
public class KundeView{
 
	// das Control-Objekt des Grundfensters mit den Kundendaten
	private KundeControl kundeControl;
	// das Model-Objekt des Grundfensters mit den Kundendaten
	private KundeModel kundeModel;

    //---Anfang Attribute der grafischen Oberflaeche---
	private BorderPane borderPane 		= new BorderPane();
	private GridPane gridPane 			= new GridPane();
	private Label lblKunde    	      	= new Label("Kunde");
    private Label lblNummerHaus     	= new Label("Plannummer des Hauses");
    private ComboBox<Integer> 
         cmbBxNummerHaus                 = new ComboBox<Integer>();
    private Label lblVorname         	= new Label("Vorname");
    private Label lblNachname           = new Label("Nachname");
    private Label lblEmail              = new Label("Email");
    private Label lblTelefonnummer      = new Label("Telefonnummer");
    private TextField txtVorname     	= new TextField();   
    private TextField txtNachname       = new TextField();
    private  TextField txtEmail         = new TextField();
    private TextField txtTelefonnummer  = new TextField();
    private Button btnAnlegen	 	  	= new Button("Anlegen");

    private Button btnSuchen            = new Button("Suchen");  
    private Button btnAendern 	      	= new Button("Ändern");
    private Button btnLoeschen 	 		= new Button("Löschen");
    private MenuBar mnBar 			  	= new MenuBar();
    private Menu mnSonderwuensche    	= new Menu("Sonderwünsche");
    private MenuItem mnItmGrundriss  	= new MenuItem("Grundrissvarianten");
    private MenuItem mnItmParkett  	= new MenuItem("Parkettvarianten");
    private MenuItem mnItmSanitaerinstallation  	= new MenuItem("Sanitaerinstallationvarianten");
    private MenuItem mnItmAussenanlage  	= new MenuItem("Aussenanlagevarianten");
    private MenuItem mnItmInnentuer  	= new MenuItem("Innentuervarianten");
    private MenuItem mnItmFliesen  	= new MenuItem("Fliesenvarianten");
    //-------Ende Attribute der grafischen Oberflaeche-------

    /**
     * erzeugt ein KundeView-Objekt und initialisiert die Steuerelemente der Maske
     * @param kundeControl KundeControl, enthaelt das zugehoerige Control
     * @param primaryStage Stage, enthaelt das Stage-Objekt fuer diese View
     * @param kundeModel KundeModel, enthaelt das zugehoerige Model
    */
    public KundeView (KundeControl kundeControl, Stage primaryStage, 
    	KundeModel kundeModel){
        this.kundeControl = kundeControl;
        this.kundeModel = kundeModel;
        
        primaryStage.setTitle(this.kundeModel.getUeberschrift());	
	    Scene scene = new Scene(borderPane, 550, 400);
	    primaryStage.setScene(scene);
        primaryStage.show();

	    this.initKomponenten();
	    this.initListener();
    }

 
    /* initialisiert die Steuerelemente auf der Maske */
    private void initKomponenten(){
    	borderPane.setCenter(gridPane);
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);
	    gridPane.setPadding(new Insets(25, 25, 25, 25));
       	
	    gridPane.add(lblKunde, 0, 1);
       	lblKunde.setMinSize(150, 40);
	    lblKunde.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	    gridPane.add(lblNummerHaus, 0, 2);
	    gridPane.add(cmbBxNummerHaus, 1, 2);
	    cmbBxNummerHaus.setMinSize(150,  25);
	    cmbBxNummerHaus.setItems(this.kundeModel.getPlannummern());
	    gridPane.add(lblVorname, 0, 3);
	    gridPane.add(txtVorname, 1, 3);
	    gridPane.add(lblNachname, 0,4);
	    gridPane.add(txtNachname, 1,4);
	    gridPane.add(lblEmail,0,5);
	    gridPane.add(txtEmail,1,5);
	    gridPane.add(lblTelefonnummer, 0, 6);
	    gridPane.add(txtTelefonnummer,1,6);

	    // Buttons
	    gridPane.add(btnAnlegen, 0, 7);
	    btnAnlegen.setMinSize(150,  25);
	    gridPane.add(btnAendern, 1, 7);
	    btnAendern.setMinSize(150,  25);
	    gridPane.add(btnLoeschen, 0, 8);
	    btnLoeschen.setMinSize(150,  25);
	    gridPane.add(btnSuchen,1,8);
	    btnSuchen.setMinSize(150,  25);
	    // MenuBar und Menu
	    borderPane.setTop(mnBar);
	    mnBar.getMenus().add(mnSonderwuensche);
	    mnSonderwuensche.getItems().add(mnItmGrundriss);
	    mnSonderwuensche.getItems().add(mnItmParkett);
	    mnSonderwuensche.getItems().add(mnItmSanitaerinstallation);
	    mnSonderwuensche.getItems().add(mnItmAussenanlage);
	    mnSonderwuensche.getItems().add(mnItmInnentuer);
	    mnSonderwuensche.getItems().add(mnItmFliesen);
    }

    /* initialisiert die Listener zu den Steuerelementen auf de Maske */
    private void initListener(){
    	cmbBxNummerHaus.setOnAction(aEvent-> {
    		 holeInfoDachgeschoss();  
    		 leseKunden();
     	});
       	btnAnlegen.setOnAction(aEvent-> {
 	        legeKundenAn();
	    });
    	btnAendern.setOnAction(aEvent-> {
           	aendereKunden();
	    });
       	btnLoeschen.setOnAction(aEvent-> { 
           	loescheKunden();
	    });
        btnSuchen.setOnAction(aEvent-> {
            sucheKunden();
        });
      	mnItmGrundriss.setOnAction(aEvent-> {
 	        kundeControl.oeffneGrundrissControl(); 
	    });

		mnItmAussenanlage.setOnAction(aEvent-> {
			kundeControl.oeffneAussenanlageControl();
		});

      	mnItmSanitaerinstallation.setOnAction(aEvent-> {
 	        kundeControl.oeffneSanitaerinstallationControl(); 
	    });
      	mnItmParkett.setOnAction(aEvent-> {
 	        kundeControl.oeffneParkettControl(); 
	    });
      	mnItmFliesen.setOnAction(aEvent-> {
      		kundeControl.oeffneFliesenControl();
	    });
    }

    private void sucheKunden(){

        //TODO: Datenbankanbindung

        zeigeFehlermeldung("Keine Verbindung", "Es wurde noch keine Verbindung zur Datenbank hergestellt.");

    }

    private void holeInfoDachgeschoss(){ 
    }
    
    private void leseKunden(){
		cleanKundenInput();
		try {
			PreparedStatement ps = MySQLAccess.GetInstance().getConnection().prepareStatement("SELECT * FROM bauplan INNER JOIN kunden USING(Kundennummer) WHERE bauplan.Plannummer = ?");
			ps.setInt(1, cmbBxNummerHaus.getValue());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				txtVorname.setText(rs.getString("Vorname"));
				txtNachname.setText(rs.getString("Nachname"));
				txtEmail.setText(rs.getString("E-Mail-Adresse"));
				txtTelefonnummer.setText(rs.getString("Telefonnummer"));

				Kunde kunde = new Kunde();
				kunde.setKundennummer(rs.getInt("Kundennummer"));
				kunde.setPlannummer(rs.getInt("Plannummer"));
				kunde.setVorname(rs.getString("Vorname"));
				kunde.setNachname(rs.getString("Nachname"));
				kunde.setEmail(rs.getString("E-Mail-Adresse"));
				kunde.setTelefonnummer(rs.getString("Telefonnummer"));
				kundeModel.speichereKunden(kunde);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void legeKundenAn(){
		Kunde kunde = new Kunde();
		kunde.setVorname(txtVorname.getText());
		kunde.setNachname(txtNachname.getText());
		kunde.setEmail(txtEmail.getText());
		kunde.setTelefonnummer(txtTelefonnummer.getText());
		kundeControl.speichereKunden(kunde);
   	}
    
  	private void aendereKunden(){
		try {
			PreparedStatement ps = MySQLAccess.GetInstance().getConnection().prepareStatement("UPDATE kunden SET Vorname=?,Nachname=?,Telefonnummer=?,`E-Mail-Adresse`=? WHERE kundennummer = (SELECT kundennummer FROM bauplan WHERE plannummer = ?)");
			ps.setString(1, txtVorname.getText());
			ps.setString(2, txtNachname.getText());
			ps.setString(3, txtTelefonnummer.getText());
			ps.setString(4, txtEmail.getText());
			ps.setInt(5, cmbBxNummerHaus.getValue());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
   	}
  	
   	private void loescheKunden(){

		try {
			PreparedStatement ps = MySQLAccess.GetInstance().getConnection().prepareStatement("DELETE FROM kunden WHERE kundennummer = (SELECT kundennummer FROM bauplan WHERE plannummer = ?)");
			ps.setInt(1, cmbBxNummerHaus.getValue());
			ps.executeUpdate();

			cleanKundenInput();

		} catch (Exception e) {
			e.printStackTrace();
		}

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

    private void cleanKundenInput() {
		txtVorname.setText("");
		txtNachname.setText("");
		txtEmail.setText("");
		txtTelefonnummer.setText("");
	}

	public int getPlannummer() {
		return cmbBxNummerHaus.getValue();
	}
}


