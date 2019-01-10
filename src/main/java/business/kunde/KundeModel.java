package business.kunde;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import db.DBConnector;
import javafx.collections.*;
  
/** 
 * Klasse, welche das Model des Grundfensters mit den Kundendaten enthaelt
 */
public final class KundeModel {
	
	// enthaelt den aktuellen Kunden
	private Kunde kunde;
	
	/* enthaelt die Plannummern der Haeuser, diese muessen vielleicht noch
	   in eine andere Klasse verschoben werden */
	ObservableList<Integer> plannummern = 
	    FXCollections.observableArrayList(
		1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24);
	
	// enthaelt Plannummern der Haeuser, welche kein Dachgeschoss besitzen.
	private Set<Integer> plannummernOhneDG = new HashSet<Integer>(Arrays.asList(new Integer[] {1, 6, 7, 14, 15, 24})); 
		
	// enthaelt das einzige KundeModel-Objekt
	private static KundeModel kundeModel;
	
	// privater Konstruktor zur Realisierung des Singleton-Pattern
	private KundeModel(){
		super();
	}
	
	/**
	 *  Methode zum Erhalt des einzigen KundeModel-Objekts.
	 *  Das Singleton-Pattern wird realisiert.
	 *  @return KundeModel, welches das einzige Objekt dieses
	 *          Typs ist.
	 */
	public static KundeModel getInstance(){
		if(kundeModel == null){
			kundeModel = new KundeModel();
		}
		return kundeModel;	
	}
	
	/**
	 * gibt die Ueberschrift zum Grundfenster mit den Kundendaten heraus
	 * @return String, Ueberschrift zum Grundfenster mit den Kundendaten 
	 */
	public String getUeberschrift(){
		return "Verwaltung der Sonderwunschlisten";
	}
	
	/**
	 * gibt saemtliche Plannummern der Haeuser des Baugebiets heraus.
	 * @return ObservableList<Integer> , enthaelt saemtliche Plannummern der Haeuser
	 */
	public ObservableList<Integer> getPlannummern(){
		return this.plannummern; 
	}
		 	
	/**
	 * gibt saemtliche Plannummern der Haeuser des Baugebiets heraus, 
	 * welche kein Dachgeschoss besitzen.
	 * @return Set<Integer> , enthaelt saemtliche Plannummern der Haeuser ohne Dachgeschoss
	 */
	public Set<Integer> getPlannummernOhneDG() {
		return plannummernOhneDG;
	}
	
	/**
	 * gibt an, ob das Haus mit der uebergebenen Plannummer
	 * ein Dachgeschoss besitzt, oder nicht.
	 * @param plannummer, Plannummer des Hauses
	 * @return boolean , entaehlt false oder true
	 */
	public boolean hatDachgeschoss(int plannummer) {
		if(plannummernOhneDG.contains(plannummer))
			return false;
		else
			return true;
	}  
	
	// ---- Datenbankzugriffe -------------------
	
	/**
	 * speichert ein Kunde-Objekt in die Datenbank
	 * @param kunde, Kunde-Objekt, welches zu speichern ist
	 * @throws SQLException, Fehler beim Speichern in die Datenbank
	 * @throws Exception, unbekannter Fehler
	 */
	public void speichereKunden(Kunde kunde)
	    throws SQLException, Exception{
        // Speicherung des Kunden in der DB
   	    this.kunde = kunde;
		DBConnector db = new DBConnector();
		db.kundenSpeichern(kunde.getVorname(), kunde.getNachname(), kunde.getTelefonnummer(), kunde.getEmail());
	}

	public Kunde getKunde() {
		return kunde;
	}

}
