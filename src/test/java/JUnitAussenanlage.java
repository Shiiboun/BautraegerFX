package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import business.kunde.KundeModel;
import gui.aussenanlage.AussenanlageControl;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

class JUnitAussenanlage {	
	// das Model-Objekt des Grundfensters mit den Kundendaten
	private static KundeModel kundeModel;

	// das AussenanlageControl-Objekt fuer die Sonderwuensche zur Aussenanlage zu
	// dem Kunden
	private static AussenanlageControl aussenanlageControl;
	
	@Test
    void test() throws InterruptedException {
		assertTrue(true);
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                    	JUnitAussenanlage.kundeModel = KundeModel.getInstance();

                    	JUnitAussenanlage.aussenanlageControl = new AussenanlageControl(kundeModel);
                    	//JUnitAussenanlage.aussenanlageControl.oeffneAussenanlageView();
                    }
                });
            }
        });
        thread.start();			// Initialize the thread
        Thread.sleep(1000); 
        
        //Tests
    	int[] erwartet1 = {91, 92};
    	aussenanlageControl.boxClicked(91, true);
    	aussenanlageControl.boxClicked(92, true);
    	assertArrayEquals(aussenanlageControl.ausgewaehlteSw, erwartet1);
    	int[] erwartet2 = {91, 92, 95};
    	aussenanlageControl.boxClicked(95, true);
    	aussenanlageControl.boxClicked(92, false);
    	aussenanlageControl.boxClicked(92, true);
    	assertArrayEquals(aussenanlageControl.ausgewaehlteSw, erwartet2);
    	int[] erwartet3 = {95, 97};
    	aussenanlageControl.boxClicked(97, true);
    	aussenanlageControl.boxClicked(91, false);
    	aussenanlageControl.boxClicked(92, false);
    	assertArrayEquals(aussenanlageControl.ausgewaehlteSw, erwartet3);
        
        
        Thread.sleep(1000); 	// Time to use the app, with out this, the thread
                                // will be killed before you can tell.
    }
}
