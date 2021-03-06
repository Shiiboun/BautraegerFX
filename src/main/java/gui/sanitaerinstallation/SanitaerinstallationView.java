package gui.sanitaerinstallation;

import java.util.ArrayList;
import java.util.List;

import gui.basis.BasisView;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu
 * den Sanitaerinstallationvarianten bereitstellt.
 */
public class SanitaerinstallationView extends BasisView {

	// das Control-Objekt des Sanitaerinstallation-Fensters
	private SanitaerinstallationControl sanitaerinstallationControl;

	// ---Anfang Attribute der grafischen Oberflaeche---
	// 6.1 Größeres Waschbecken im OG
	private Label lbl61 = new Label("Größeres Waschbecken im OG");
	private TextField txt61 = new TextField();
	private Label lbl61euro = new Label("Euro");
	private CheckBox chckBx61 = new CheckBox();
	// 6.2 Größeres Waschbecken im DG
	private Label lbl62 = new Label("Größeres Waschbecken im DG");
	private TextField txt62 = new TextField();
	private Label lbl62euro = new Label("Euro");
	private CheckBox chckBx62 = new CheckBox();
	// 6.3 Bodentiefe Dusche im OG
	private Label lbl63 = new Label("Bodentiefe Dusche im OG");
	private TextField txt63 = new TextField();
	private Label lbl63euro = new Label("Euro");
	private CheckBox chckBx63 = new CheckBox();
	// 6.4 Bodentiefe Dusche im DG
	private Label lbl64 = new Label("Bodentiefe Dusche im DG");
	private TextField txt64 = new TextField();
	private Label lbl64euro = new Label("Euro");
	private CheckBox chckBx64 = new CheckBox();
	// -------Ende Attribute der grafischen Oberflaeche-------

	/**
	 * erzeugt ein SanitaerinstallationView-Objekt, belegt das zugehoerige Control
	 * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
	 * 
	 * @param sanitaerinstallationControl
	 *            SanitaerinstallationControl, enthaelt das zugehoerige Control
	 * @param sanitaerinstallationStage
	 *            Stage, enthaelt das Stage-Objekt fuer diese View
	 */
	public SanitaerinstallationView(SanitaerinstallationControl sanitaerinstallationControl, Stage sanitaerinstallationStage) {
		super(sanitaerinstallationStage);
		this.sanitaerinstallationControl = sanitaerinstallationControl;
		sanitaerinstallationStage.setTitle("Sonderwünsche zu Sanitaerinstallation-Varianten");

		this.initKomponenten();
		this.leseSanitaerinstallationSonderwuensche();
	}

	/* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten() {
		super.initKomponenten();
		super.getLblSonderwunsch().setText("Sanitaerinstallationen");

		// 6.1
		super.getGridPaneSonderwunsch().add(lbl61, 0, 1);
		super.getGridPaneSonderwunsch().add(txt61, 1, 1);
		txt61.setText("160");
		txt61.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl61euro, 2, 1);
		super.getGridPaneSonderwunsch().add(chckBx61, 3, 1);
		// 6.2
		super.getGridPaneSonderwunsch().add(lbl62, 0, 2);
		super.getGridPaneSonderwunsch().add(txt62, 1, 2);
		txt62.setText("160");
		txt62.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl62euro, 2, 2);
		super.getGridPaneSonderwunsch().add(chckBx62, 3, 2);
		// 6.3
		super.getGridPaneSonderwunsch().add(lbl63, 0, 3);
		super.getGridPaneSonderwunsch().add(txt63, 1, 3);
		txt63.setText("560");
		txt63.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl63euro, 2, 3);
		super.getGridPaneSonderwunsch().add(chckBx63, 3, 3);
		// 6.4
		super.getGridPaneSonderwunsch().add(lbl64, 0, 4);
		super.getGridPaneSonderwunsch().add(txt64, 1, 4);
		txt64.setText("560");
		txt64.setEditable(false);
		super.getGridPaneSonderwunsch().add(lbl64euro, 2, 4);
		super.getGridPaneSonderwunsch().add(chckBx64, 3, 4);
	}

	/**
	 * macht das SanitaerinstallationView-Objekt sichtbar.
	 */
	public void oeffneSanitaerinstallationView() {
		super.oeffneBasisView();
	}

	private void leseSanitaerinstallationSonderwuensche() {
		List<Integer> arrayList = sanitaerinstallationControl.leseSanitaerinstallationSonderwuensche();
		for (Integer integer : arrayList) {
			setSonderwunsch(integer);
		}
	}

	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
	protected void berechneUndZeigePreisSonderwuensche() {
		int preis = 0;
		int[] ausgewaehlteWuensche = new int[4];

		if (chckBx61.isSelected()) {
			ausgewaehlteWuensche[0] = 1;
			preis += Integer.parseInt(txt61.getText());
		}
		if (chckBx62.isSelected()) {
			ausgewaehlteWuensche[1] = 1;
			preis += Integer.parseInt(txt62.getText());
		}
		if (chckBx63.isSelected()) {
			ausgewaehlteWuensche[2] = 1;
			preis += Integer.parseInt(txt63.getText());
		}
		if (chckBx64.isSelected()) {
			ausgewaehlteWuensche[3] = 1;
			preis += Integer.parseInt(txt64.getText());
		}
		if (pruefeKonstellationSonderwuensche()) {
			System.out.println("Preis: " + preis);
		} else {
			System.out.println("Fehler, diese Kombination ist nicht Möglich");
		}
	}

	private boolean pruefeKonstellationSonderwuensche() {
		return sanitaerinstallationControl.pruefeKonstellationSonderwuensche(getAusgewaehlteWuensche());
	}

	private List<Integer> getAusgewaehlteWuensche() {
		List<Integer> ausgewaehlteWuensche = new ArrayList<>();

		if (chckBx61.isSelected())
			ausgewaehlteWuensche.add(61);
		if (chckBx62.isSelected())
			ausgewaehlteWuensche.add(62);
		if (chckBx63.isSelected())
			ausgewaehlteWuensche.add(63);
		if (chckBx64.isSelected())
			ausgewaehlteWuensche.add(64);
		return ausgewaehlteWuensche;
	}

	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
	protected void speichereSonderwuensche() {
		if (pruefeKonstellationSonderwuensche()) {
			sanitaerinstallationControl.speichereKonstellation(getAusgewaehlteWuensche());
			System.out.println("");
		} else {
			System.out.println("Fehler, diese Kombination ist nicht Möglich");
		}
	}

	public void setSonderwunsch(int sonderwuensche) {
		switch (sonderwuensche) {
		case 61:
			chckBx61.setSelected(true);
			break;
		case 62:
			chckBx62.setSelected(true);
			break;
		case 63:
			chckBx63.setSelected(true);
			break;
		case 64:
			chckBx64.setSelected(true);
			break;
		default:
			System.out.println("Fehler beim Wunsch setzen!");
		}
	}
}