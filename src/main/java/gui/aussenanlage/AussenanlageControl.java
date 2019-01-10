package gui.aussenanlage;

import business.kunde.KundeModel;
import gui.MySQLAccess;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Au�enanlage-Varianten
 * kontrolliert.
 */
public final class AussenanlageControl {

	// das View-Objekt des Aussenanlage-Fensters
	private AussenanlageView aussenanlageView;
	private KundeModel kundeModel;

	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum
	 * Fenster fuer die Sonderwuensche zur Au�enanlage.
	 *
	 * @param aussenanlageStage, Stage fuer das View-Objekt zu den Sonderwuenschen zur Au�enanlage
	 * @param kundeModel
	 */
	public AussenanlageControl(KundeModel kundeModel) {
		this.kundeModel = kundeModel;
		Stage stageAussenanlage = new Stage();
		stageAussenanlage.initModality(Modality.APPLICATION_MODAL);
		this.aussenanlageView = new AussenanlageView(this, stageAussenanlage);
	}

	/**
	 * macht das Au�enanlageView-Objekt sichtbar.
	 */
	public void oeffneAussenanlageView() {
		this.aussenanlageView.oeffneAussenanlageView();
	}

	public List<Integer> leseAussenanlageSonderwuensche() {
		ArrayList ar = new ArrayList();

		try {
			System.out.println("JA: " + kundeModel.getKunde().getPlannummer());
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

	public boolean pruefeKonstellationSonderwuensche(List<Integer> sw) {
		if (sw.contains(91) && sw.contains(92)) {
			return false;
		}
		return true;
	}

	public void speichereKonstellation(List<Integer> ausgewaehlteWuensche) {
		try {
			PreparedStatement ps1 = MySQLAccess.GetInstance().getConnection().prepareStatement("SELECT * FROM bauplan_sonderwuensche WHERE Plannummer = ?");
			ps1.setInt(1, kundeModel.getKunde().getPlannummer());
			ResultSet rs1 = ps1.executeQuery();

			while (rs1.next()) {
				int swInDB = rs1.getInt("SonderwunschID");
				if(!ausgewaehlteWuensche.contains(swInDB)) {
					//in Datenbank, aber wunsch soll gelöscht werden
					PreparedStatement ps = MySQLAccess.GetInstance().getConnection().prepareStatement("DELETE FROM bauplan_sonderwuensche WHERE Plannummer = ? AND SonderwunschID = ?");
					ps.setInt(1, kundeModel.getKunde().getPlannummer());
					ps.setInt(2, swInDB);
					ps.executeUpdate();

				}else{
					//in Datenbank und soll auch bestehen!
					ausgewaehlteWuensche.remove(ausgewaehlteWuensche.indexOf(swInDB));
				}
			}

			for (int i = 0; i < ausgewaehlteWuensche.size(); i++) {
				// Alle vebleibenden Wünsche in Datenbank speichern
				PreparedStatement ps = MySQLAccess.GetInstance().getConnection().prepareStatement("INSERT INTO bauplan_sonderwuensche (Plannummer, SonderwunschID, Anzahl) VALUES (?,?,?)");
				ps.setInt(1, kundeModel.getKunde().getPlannummer());
				ps.setInt(2, ausgewaehlteWuensche.get(i));
				ps.setInt(3, 1);
				ps.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
