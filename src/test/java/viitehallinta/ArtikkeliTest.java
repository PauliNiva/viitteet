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

    /**
     * Testi konstruktorille, jolla on parametreja.
     */
    @Test
    public void ArtikkeliKonstruktoriTest() {
        Artikkeli artikkeli1 = new Artikkeli("Arto Vihavainen", "Ratebeer", "Olutsanomat",
                3, 2013);
        artikkeli1.luoID();
        Artikkeli artikkeli2 = new Artikkeli("Arto Vihavainen", "Ratebeer", "Olutsanomat",
                3, 2013);
        artikkeli2.luoID();

        assertEquals(artikkeli1.getID(), artikkeli2.getID());
        assertNotNull(artikkeli1.getID(), artikkeli2.getID());
    }

    @Test
    public void getTiedostoMuotoTest() {
        Artikkeli artikkeli = new Artikkeli("Arto Vihavainen", "Ratebeer", "Olutsanomat",
                3, 2013);
        artikkeli.luoID();

        assertEquals("Arto2013Ratebeer:Arto Vihavainen:Ratebeer:Olutsanomat:" + 3 + ":0:" + 2013 + ":null\n",
                artikkeli.getTiedostoMuoto());
    }

    @Test
    public void haeKentatToimivat() {
        Artikkeli artikkeli = new Artikkeli("Arto Vihavainen", "Ratebeer", "Olutsanomat",
                3, 2013);
        artikkeli.luoID();
        assertTrue(Artikkeli.haeKentat().get(0).pakollinen());
        assertTrue(Artikkeli.haeKentat().get(1).pakollinen());
        assertTrue(Artikkeli.haeKentat().get(2).pakollinen());
        assertFalse(Artikkeli.haeKentat().get(3).pakollinen());
        assertFalse(Artikkeli.haeKentat().get(4).pakollinen());
        assertFalse(Artikkeli.haeKentat().get(5).pakollinen());
        assertTrue(Artikkeli.haeKentat().get(6).pakollinen());
        assertTrue(Artikkeli.haeKentat().get(7).pakollinen());
        assertFalse(Artikkeli.haeKentat().get(8).pakollinen());
    }
}
