package main.java.test;

import main.java.business.kunde.Kunde;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestKundenDatenEingeben {

    @Test
    void kundenDatenEingeben() {
        Kunde kunde = new Kunde();
        kunde.setVorname("Vorname");
        kunde.setNachname("Nachname");
        kunde.setEmail("Email");
        kunde.setTelefonnummer("0123456789");
        kunde.setHausnummer(1);

        assertEquals("Vorname", kunde.getVorname());
        assertEquals("Nachname", kunde.getNachname());
        assertEquals("Email", kunde.getEmail());
        assertEquals("0123456789", kunde.getTelefonnummer());
        assertEquals(1, kunde.getHausnummer());
    }
}
