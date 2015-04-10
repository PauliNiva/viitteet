package viitehallinta;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit-testit Artikkeli-luokalle.
 */
public class ArtikkeliTest {

    @Test
    public void SetAndGetJournalTest() {
        Artikkeli artikkeli = new Artikkeli();
        artikkeli.setJournal("testilehti");
        assertEquals("testilehti", artikkeli.getJournal());
    }

    @Test
    public void SetAndGetVolumeTest() {
        Artikkeli artikkeli = new Artikkeli();
        artikkeli.setVolume(42);
        assertEquals(42, artikkeli.getVolume());
    }

    @Test
    public void SetAndGetNumberTest() {
        Artikkeli artikkeli = new Artikkeli();
        artikkeli.setNumber(69);
        assertEquals(69, artikkeli.getNumber());
    }

    @Test
    public void SetAndGetAddressTest() {
        Artikkeli artikkeli = new Artikkeli();
        artikkeli.setAddress("foobarintie 1");
        assertEquals("foobarintie 1", artikkeli.getAddress());
    }

    /**
     * Testi konstruktorille, jolla on parametreja.
     */
    @Test
    public void ArtikkeliKonstruktoriTest() {
        Artikkeli artikkeli1 = new Artikkeli("g3", "Arto Vihavainen", "Ratebeer", "Olutsanomat",
                2, 3, 2013, "69--96", "Oluen ystavat", "Foobarintie 1");
        Artikkeli artikkeli2 = new Artikkeli("g3", "Arto Vihavainen", "Ratebeer", "Olutsanomat",
                2, 3, 2013, "69--96", "Oluen ystavat", "Foobarintie 1");
        assertEquals(artikkeli1.getID(), artikkeli2.getID());
        assertNotNull(artikkeli1.getID(), artikkeli2.getID());
    }
}
