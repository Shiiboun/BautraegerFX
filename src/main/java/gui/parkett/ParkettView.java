package gui.parkett;

import java.util.ArrayList;
import java.util.List;

import gui.basis.BasisView;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu
 * den Parkettvarianten bereitstellt.
 */
public class ParkettView extends BasisView {

	// das Control-Objekt des Parkett-Fensters
	private ParkettControl parkettControl;

	// ---Anfang Attribute der grafischen Oberflaeche---
	// 8.1 Landhausdielen massiv im Essbereich des EG
	private Label lbl81 = new Label("Landhausdielen massiv im Essbereich des EG");
	private TextField txt81 = new TextField();
	private Label lbl81euro = new Label("Euro");
	private CheckBox chckBx81 = new CheckBox();
	// 8.2 Landhausdielen massiv im K�chenbereich des EG
	private Label lbl82 = new Label("Landhausdielen massiv im K�chenbereich des EG");
	private TextField txt82 = new TextField();
	private Label lbl82euro = new Label("Euro");
	private CheckBox chckBx82 = new CheckBox();
	// 8.3 St�bchenparkett im Essbereich des EG
	private Label lbl83 = new Label("St�bchenparkett im Essbereich des EG");
	private TextField txt83 = new TextField();
	private Label lbl83euro = new Label("Euro");
	private CheckBox chckBx83 = new CheckBox();
	// 8.4 St�bchenparkett im K�chenbereich des EG
	private Label lbl84 = new Label("St�bchenparkett im K�chenbereich des EG");
	private TextField txt84 = new TextField();
	private Label lbl84euro = new Label("Euro");
	private CheckBox chckBx84 = new CheckBox();
	// 8.5 Landhausdielen massiv im OG
	private Label lbl85 = new Label("Landhausdielen massiv im OG");
	private TextField txt85 = new TextField();
	private Label lbl85euro = new Label("Euro");
	private CheckBox chckBx85 = new CheckBox();
	// 8.6 St�bchenparkett im OG
	private Label lbl86 = new Label("St�bchenparkett im OG");
	private TextField txt86 = new TextField();
	private Label lbl86euro = new Label("Euro");
	private CheckBox chckBx86 = new CheckBox();
	// 8.7 Landhausdielen massiv komplett im DG
	private Label lbl87 = new Label("Landhausdielen massiv komplett im DG");
	private TextField txt87 = new TextField();
	private Label lbl87euro = new Label("Euro");
	private CheckBox chckBx87 = new CheckBox();
	// 8.8 Landhausdielen massiv ohne Badbereich im DG
	private Label lbl88 = new Label("Landhausdielen massiv ohne Badbereich im DG");
	private TextField txt88 = new TextField();
	private Label lbl88euro = new Label("Euro");
	private CheckBox chckBx88 = new CheckBox();
	// 8.9 St�bchenparkett im DG komplett im DG
	private Label lbl89 = new Label("St�bchenparkett im DG komplett im DG");
	private TextField txt89 = new TextField();
	private Label lbl89euro = new Label("Euro");
	private CheckBox chckBx89 = new CheckBox();
	// 8.10 St�bchenparkett ohne Badbereich im DG
	private Label lbl810 = new Label("St�bchenparkett ohne Badbereich im DG");
	private TextField txt810 = new TextField();
	private Label lbl810euro = new Label("Euro");
	private CheckBox chckBx810 = new CheckBox();
	// -------Ende Attribute der grafischen Oberflaeche-------

	/**
	 * erzeugt ein ParkettView-Objekt, belegt das zugehoerige Control
	 * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
	 * 
	 * @param parkettControl
	 *            ParkettControl, enthaelt das zugehoerige Control
	 * @param parkettStage
	 *            Stage, enthaelt das Stage-Objekt fuer diese View
	 */
	public ParkettView(ParkettControl parkettControl, Stage parkettStage) {
		super(parkettStage);
		this.parkettControl = parkettControl;
		parkettStage.setTitle("Sonderw�nsche zu Parkett-Varianten");

		this.initKomponenten();
		this.leseParkettSonderwuensche();
	}

	/* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten() {
		super.initKomponenten();
		super.getLblSonderwunsch().setText("Parkett-Varianten");

		// Vergroessere das Fenster damit alles reinpasst
		super.setStageHeight(550);

		// 8.1
		super.getGridPaneSonderwunsch().add(lbl81, 0, 1);
		super.getGridPaneSonderwunsch().add(txt81, 1, 1);
		txt81.setText("2890");
		txt81.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl81euro, 2, 1);
		super.getGridPaneSonderwunsch().add(chckBx81, 3, 1);
		// 8.2
		super.getGridPaneSonderwunsch().add(lbl82, 0, 2);
		super.getGridPaneSonderwunsch().add(txt82, 1, 2);
		txt82.setText("2090");
		txt82.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl82euro, 2, 2);
		super.getGridPaneSonderwunsch().add(chckBx82, 3, 2);
		// 8.3
		super.getGridPaneSonderwunsch().add(lbl83, 0, 3);
		super.getGridPaneSonderwunsch().add(txt83, 1, 3);
		txt83.setText("2090");
		txt83.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl83euro, 2, 3);
		super.getGridPaneSonderwunsch().add(chckBx83, 3, 3);
		// 8.4
		super.getGridPaneSonderwunsch().add(lbl84, 0, 4);
		super.getGridPaneSonderwunsch().add(txt84, 1, 4);
		txt84.setText("1790");
		txt84.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl84euro, 2, 4);
		super.getGridPaneSonderwunsch().add(chckBx84, 3, 4);
		// 8.5
		super.getGridPaneSonderwunsch().add(lbl85, 0, 5);
		super.getGridPaneSonderwunsch().add(txt85, 1, 5);
		txt85.setText("2490");
		txt85.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl85euro, 2, 5);
		super.getGridPaneSonderwunsch().add(chckBx85, 3, 5);
		// 8.6
		super.getGridPaneSonderwunsch().add(lbl86, 0, 6);
		super.getGridPaneSonderwunsch().add(txt86, 1, 6);
		txt86.setText("1690");
		txt86.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl86euro, 2, 6);
		super.getGridPaneSonderwunsch().add(chckBx86, 3, 6);
		// 8.7
		super.getGridPaneSonderwunsch().add(lbl87, 0, 7);
		super.getGridPaneSonderwunsch().add(txt87, 1, 7);
		txt87.setText("2490");
		txt87.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl87euro, 2, 7);
		super.getGridPaneSonderwunsch().add(chckBx87, 3, 7);
		// 8.8
		super.getGridPaneSonderwunsch().add(lbl88, 0, 8);
		super.getGridPaneSonderwunsch().add(txt88, 1, 8);
		txt88.setText("2090");
		txt88.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl88euro, 2, 8);
		super.getGridPaneSonderwunsch().add(chckBx88, 3, 8);
		// 8.9
		super.getGridPaneSonderwunsch().add(lbl89, 0, 9);
		super.getGridPaneSonderwunsch().add(txt89, 1, 9);
		txt89.setText("1690");
		txt89.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl89euro, 2, 9);
		super.getGridPaneSonderwunsch().add(chckBx89, 3, 9);
		// 8.10
		super.getGridPaneSonderwunsch().add(lbl810, 0, 10);
		super.getGridPaneSonderwunsch().add(txt810, 1, 10);
		txt810.setText("1690");
		txt810.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl810euro, 2, 10);
		super.getGridPaneSonderwunsch().add(chckBx810, 3, 10);
	}

	/**
	 * macht das ParkettView-Objekt sichtbar.
	 */
	public void oeffneParkettView() {
		super.oeffneBasisView();
	}

	private void leseParkettSonderwuensche() {
		List<Integer> arrayList = parkettControl.leseParkettSonderwuensche();
		for (Integer integer : arrayList) {
			setSonderwunsch(integer);
		}
	}

	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
	protected void berechneUndZeigePreisSonderwuensche() {
		int preis = 0;
		int[] ausgewaehlteWuensche = new int[10];

		if (chckBx81.isSelected()) {
			ausgewaehlteWuensche[0] = 1;
			preis += Integer.parseInt(txt81.getText());
		}
		if (chckBx82.isSelected()) {
			ausgewaehlteWuensche[1] = 1;
			preis += Integer.parseInt(txt82.getText());
		}
		if (chckBx83.isSelected()) {
			ausgewaehlteWuensche[2] = 1;
			preis += Integer.parseInt(txt83.getText());
		}
		if (chckBx84.isSelected()) {
			ausgewaehlteWuensche[3] = 1;
			preis += Integer.parseInt(txt84.getText());
		}
		if (chckBx85.isSelected()) {
			ausgewaehlteWuensche[4] = 1;
			preis += Integer.parseInt(txt85.getText());
		}
		if (chckBx86.isSelected()) {
			ausgewaehlteWuensche[5] = 1;
			preis += Integer.parseInt(txt86.getText());
		}
		if (chckBx87.isSelected()) {
			ausgewaehlteWuensche[6] = 1;
			preis += Integer.parseInt(txt87.getText());
		}
		if (chckBx88.isSelected()) {
			ausgewaehlteWuensche[7] = 1;
			preis += Integer.parseInt(txt88.getText());
		}
		if (chckBx89.isSelected()) {
			ausgewaehlteWuensche[8] = 1;
			preis += Integer.parseInt(txt89.getText());
		}
		if (chckBx810.isSelected()) {
			ausgewaehlteWuensche[9] = 1;
			preis += Integer.parseInt(txt810.getText());
		}
		if (pruefeKonstellationSonderwuensche()) {
			System.out.println("Preis: " + preis);
		} else {
			System.out.println("Fehler, diese Kombination ist nicht M�glich");
		}
	}

	private boolean pruefeKonstellationSonderwuensche() {
		return parkettControl.pruefeKonstellationSonderwuensche(getAusgewaehlteWuensche());
	}

	private List<Integer> getAusgewaehlteWuensche() {
		List<Integer> ausgewaehlteWuensche = new ArrayList<>();

		if (chckBx81.isSelected())
			ausgewaehlteWuensche.add(81);
		if (chckBx82.isSelected())
			ausgewaehlteWuensche.add(82);
		if (chckBx83.isSelected())
			ausgewaehlteWuensche.add(83);
		if (chckBx84.isSelected())
			ausgewaehlteWuensche.add(84);
		if (chckBx85.isSelected())
			ausgewaehlteWuensche.add(85);
		if (chckBx86.isSelected())
			ausgewaehlteWuensche.add(86);
		if (chckBx87.isSelected())
			ausgewaehlteWuensche.add(87);
		if (chckBx88.isSelected())
			ausgewaehlteWuensche.add(88);
		if (chckBx89.isSelected())
			ausgewaehlteWuensche.add(89);
		if (chckBx810.isSelected())
			ausgewaehlteWuensche.add(810);
		return ausgewaehlteWuensche;
	}

	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
	protected void speichereSonderwuensche() {
		if (pruefeKonstellationSonderwuensche()) {
			parkettControl.speichereKonstellation(getAusgewaehlteWuensche());
			System.out.println("");
		} else {
			System.out.println("Fehler, diese Kombination ist nicht M�glich");
		}
	}

	public void setSonderwunsch(int sonderwuensche) {
		switch (sonderwuensche) {
		case 81:
			chckBx81.setSelected(true);
			break;
		case 82:
			chckBx82.setSelected(true);
			break;
		case 83:
			chckBx83.setSelected(true);
			break;
		case 84:
			chckBx84.setSelected(true);
			break;
		case 85:
			chckBx85.setSelected(true);
			break;
		case 86:
			chckBx86.setSelected(true);
			break;
		case 87:
			chckBx87.setSelected(true);
			break;
		case 88:
			chckBx88.setSelected(true);
			break;
		case 89:
			chckBx89.setSelected(true);
			break;
		case 810:
			chckBx810.setSelected(true);
			break;
		default:
			System.out.println("Fehler beim Wunsch setzen!");
		}
	}
}
