package business.kunde;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import db.DBConnector;

class hatDGTest {

	@Test
	void test() {
		// Test der Ueberpruefung auf Dachgeschoss ohne Datenbankabfrage:
		KundeModel kundeModel = KundeModel.getInstance();
		boolean hatDG = kundeModel.hatDachgeschoss(6);
		assertEquals(false, hatDG);	
		hatDG = kundeModel.hatDachgeschoss(5);
		assertEquals(true, hatDG);
		
		// Test der Ueberpruefung auf Dachgeschoss mit Datenbankabfrage
		DBConnector dbC = new DBConnector();
	    hatDG = dbC.hatDachgeschoss(6);
		assertEquals(false, hatDG);	
		hatDG = dbC.hatDachgeschoss(5);
		assertEquals(true, hatDG);
	}

}
