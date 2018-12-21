package test;

import business.kunde.Kunde;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPlannummerEingeben {

    @Test
    void planNummerEingeben() {
        int plannummer = 1;

        Kunde kunde = new Kunde();
        kunde.setVorname("Vorname");
        kunde.setNachname("Nachname");
        kunde.setEmail("Email");
        kunde.setTelefonnummer("0123456789");
        kunde.setHausnummer(1);

        Kunde kundeZuPlannummer = null;
        if (plannummer == 1) {
            kundeZuPlannummer = kunde;
        }

        assertEquals("Vorname", kundeZuPlannummer.getVorname());
        assertEquals("Nachname", kundeZuPlannummer.getNachname());
        assertEquals("Email", kundeZuPlannummer.getEmail());
        assertEquals("0123456789", kundeZuPlannummer.getTelefonnummer());
        assertEquals(1, kundeZuPlannummer.getHausnummer());
    }
}
