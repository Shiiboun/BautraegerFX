package business.bild;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import business.kunde.KundeModel;
import db.DBConnector;
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
		int anzahlPlannummern = KundeModel.getInstance().getPlannummern().size();
		DBConnector dbC = new DBConnector();
		bilder.put(bilder.size(), null);  // Plannummer 0 gibt es nicht
		for(int plannummer = 1; plannummer <= anzahlPlannummern; plannummer++) {
			try {
				String pfad = dbC.getBildVonHaus(plannummer);
				Image img = new Image(new File(pfad).toURI().toString());
				bilder.put(bilder.size(), img);
			}
			catch(NullPointerException ne) {
				bilder.put(bilder.size(), null);
			}
			catch(Exception e) {
				System.out.println("e: " + e);
			}
		
		}
		
//		File folder = new File("BilderVonHaeusern/");
//		File[] listOfFiles = folder.listFiles();
//
//		if (listOfFiles != null && listOfFiles.length > 1) {
//			Arrays.sort(listOfFiles, new Comparator<File>() {
//			    @Override
//			    public int compare(File f1, File f2) {
//			        String name1 = f1.getName();
//			        String name2 = f2.getName();
//			        Integer num1 = Integer.valueOf(name1.substring(0, name1.indexOf(".")));
//			        Integer num2 = Integer.valueOf(name2.substring(0, name2.indexOf(".")));
//			        return num1.compareTo(num2);
//			    }
//			});
//		}
//		
//		for (File file : listOfFiles) {
//		    if (file.isFile()) {
//		    	Image img = new Image(file.toURI().toString());
//		    	bilder.put(bilder.size(), img);
//		    }
//		}

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
