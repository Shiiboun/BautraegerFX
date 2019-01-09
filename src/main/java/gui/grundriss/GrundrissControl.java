package gui.grundriss;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import business.kunde.KundeModel;
import gui.MySQLAccess;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Grundriss-Varianten
 * kontrolliert.
 */
public final class GrundrissControl {

	// das View-Objekt des Grundriss-Fensters
	private GrundrissView grundrissView;
	private KundeModel kundeModel;

	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum
	 * Fenster fuer die Sonderwuensche zum Grundriss.
	 * @param grundrissStage, Stage fuer das View-Objekt zu den Sonderwuenschen zum Grundriss
	 */
	public GrundrissControl(KundeModel kundeModel){
		this.kundeModel = kundeModel;
	   	Stage stageGrundriss = new Stage();
    	stageGrundriss.initModality(Modality.APPLICATION_MODAL);
    	this.grundrissView = new GrundrissView(this, stageGrundriss);

	}

	/**
	 * macht das GrundrissView-Objekt sichtbar.
	 */
	public void oeffneGrundrissView(){
		this.grundrissView.oeffneGrundrissView();
	}

	public List<Integer> leseGrundrissSonderwuensche(){
		ArrayList ar = new ArrayList();
		try {
			PreparedStatement ps = MySQLAccess.GetInstance().getConnection().prepareStatement("SELECT * FROM bauplan_sonderwuensche WHERE Plannummer = ?");
			ps.setInt(1, kundeModel.getKunde().getPlannummer());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ar.add(rs.getInt("SonderwunschID"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
    }

	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		return true;
	}

	public void speichereSonderwuensche(List<Integer> selected){
		try{
			PreparedStatement ps1 = MySQLAccess.GetInstance().getConnection().prepareStatement("SELECT * FROM bauplan_sonderwuensche WHERE Plannummer = ?");
			ps1.setInt(1, kundeModel.getKunde().getPlannummer());
			ResultSet rs1 = ps1.executeQuery();

			while(rs1.next()){
				int swInDB = rs1.getInt("SonderwunschID");
				if(!selected.contains(swInDB)) {
					PreparedStatement ps = MySQLAccess.GetInstance().getConnection().prepareStatement("DELETE FROM bauplan_sonderwuensche WHERE Plannummer = ? AND SonderwunschID = ?");
					ps.setInt(1, kundeModel.getKunde().getPlannummer());
					ps.setInt(2, swInDB);
					ps.executeUpdate();

				}else{
					selected.remove(selected.indexOf(swInDB));
				}
			}
			for (int i = 0; i < selected.size(); i++) {
						if(selected.get(i)!=0){
							PreparedStatement ps = MySQLAccess.GetInstance().getConnection().prepareStatement("INSERT INTO bauplan_sonderwuensche (Plannummer, SonderwunschID, Anzahl) VALUES (?,?,?)");
							ps.setInt(1, kundeModel.getKunde().getPlannummer());
							ps.setInt(2, selected.get(i));
							ps.setInt(3, 1);
							ps.executeUpdate();
						}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
