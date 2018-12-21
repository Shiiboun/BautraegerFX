package main.java.gui.fliesen;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.java.gui.MySQLAccess;
import main.java.business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Fliesen-Varianten
 * kontrolliert.
 */

public final class FliesenControl {
	
	// das View-Objekt des Aussenanlage-Fensters
	private FliesenView fliesenView;
	private KundeModel kundeModel;
	private boolean testphase = false; // ----------------------------------------------------------------------------------------- Testschalter
	
	public FliesenControl(KundeModel kundeModel){ 
		this.kundeModel = kundeModel;
	   	Stage stageFliesen = new Stage();
    	stageFliesen.initModality(Modality.APPLICATION_MODAL);
    	this.fliesenView = new FliesenView(this, stageFliesen);
	}
	
	public void oeffneFliesenView(){ 
		this.fliesenView.oeffneFliesenView();
	}

	public List<Integer> leseFliesenSonderwuensche(){
		ArrayList fliese = new ArrayList();
		
		try {
			PreparedStatement ps = MySQLAccess.GetInstance().getConnection().prepareStatement("SELECT * FROM bauplan_sonderwuensche WHERE Plannummer = ?");
			ps.setInt(1, kundeModel.getKunde().getPlannummer());
			ResultSet rs = ps.executeQuery();
	
			 while(rs.next()) {
				 fliese.add(rs.getInt("SonderwunschID"));
		}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fliese;
    } 
	
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		return true;
	}
	
	public void speichereFliesen(List<Integer> wunschFliesen) {
		try {
			PreparedStatement ps1 = MySQLAccess.GetInstance().getConnection().prepareStatement("SELECT * FROM bauplan_sonderwuensche WHERE Plannummer = ?");
			ps1.setInt(1, kundeModel.getKunde().getPlannummer());
			ResultSet rs1 = ps1.executeQuery();

			while (rs1.next()) {
				int swInDB = rs1.getInt("SonderwunschID");
				if(!wunschFliesen.contains(swInDB)) {
					//in Datenbank, aber wunsch soll gelöscht werden
					PreparedStatement ps = MySQLAccess.GetInstance().getConnection().prepareStatement("DELETE FROM bauplan_sonderwuensche WHERE Plannummer = ? AND SonderwunschID = ?");
					ps.setInt(1, kundeModel.getKunde().getPlannummer());
					ps.setInt(2, swInDB);
					ps.executeUpdate();

				}else{
					//in Datenbank und soll auch bestehen!
					wunschFliesen.remove(wunschFliesen.indexOf(swInDB));
				}
			}

			for (int i = 0; i < wunschFliesen.size(); i++) {
				// Alle vebleibenden Wünsche in Datenbank speichern
				PreparedStatement ps = MySQLAccess.GetInstance().getConnection().prepareStatement("INSERT INTO bauplan_sonderwuensche (Plannummer, SonderwunschID, Anzahl) VALUES (?,?,?)");
				ps.setInt(1, kundeModel.getKunde().getPlannummer());
				ps.setInt(2, wunschFliesen.get(i));
				ps.setInt(3, 1);
				ps.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
