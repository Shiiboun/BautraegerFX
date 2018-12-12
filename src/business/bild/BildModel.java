package business.bild;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;

/** 
 * Klasse, welche das Model des Fensters mit den Bildern der Haeuser enthaelt.
 */
public final class BildModel{
	
	// enthaelt das aktuelle Bild
	private Image bild;
	
	/* enthaelt die Bilder der Haeuser */
    private Map<Integer, Image> bilder = new HashMap<>();
    
	// enthaelt das einzige Bild-Objekt
	private static BildModel bildModel;
	
	// privater Konstruktor zur Realisierung des Singleton-Pattern
	private BildModel(){
		super();		
		File folder = new File("BilderVonHaeusern/");
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	System.out.println(file.toURI().toString());
		    	Image img = new Image(file.toURI().toString());
		    	bilder.put(bilder.size(), img);
		    }
		}

	}
	
	/**
	 *  Methode zum Erhalt des einzigen KundeModel-Objekts.
	 *  Das Singleton-Pattern wird realisiert.
	 *  @return BildModel, welches das einzige Objekt dieses
	 *          Typs ist.
	 */
	public static BildModel getInstance(){
		if(bildModel == null){
			bildModel = new BildModel();
		}
		return bildModel;	
	}
	
	/**
	 * gibt die Ueberschrift zum Fenster mit den Bildern der Haeusern heraus
	 * @return String, Ueberschrift zum Fenster mit den Bildern der Haeusern 
	 */
	public String getUeberschrift(){
		return "Bild vom Haus";
	}
	
	/**
	 * gibt saemtliche Bilder der Haeuser des Baugebiets heraus.
	 * @return ObservableList<Integer> , enthaelt saemtlich Bilder der Haeuser
	 */
	public Map<Integer, Image> getBilder(){
		return this.bilder; 
	}
	
	/**
	 * gibt Bild des Hauses mit der uebergebenen Plannummer heraus.
	 * @return Image , Bild mit der uebergebenen Plannummer
	 */
	public Image getBild(int plannummer){
		if(bilder.containsKey(plannummer)) {
			System.out.println("bilder.get(plannummer).toString(): " + bilder.get(plannummer).toString());
			return this.bilder.get(plannummer);
		}
		else
			return null;
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
}
