package viitehallinta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit-testit Kirja-luokan testaamiseen.
 */
public class KirjaTest {

    Kirja kirja;

    public KirjaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luoTyhjaKirjaOlioTest() {
        kirja = new Kirja();
        assertEquals(null, kirja.getID());
    }

    @Test
    public void luoKirjaTest() {
        kirja = new Kirja("Charles M. Schulz", "Charlie Brown", 1950, "Simon & Schuster");
        kirja.luoID();
        assertEquals("Charles1950Charlie Brown", kirja.getID());
        assertEquals("Charles M. Schulz", kirja.getAuthor());
        assertEquals("Charlie Brown", kirja.getTitle());
        assertEquals(1950, kirja.getYear());
        assertEquals("Simon & Schuster", kirja.getPublisher());
    }

    @Test
    public void testGetAndSetAddress() {
        kirja = new Kirja("Charles M. Schulz", "Charlie Brown", 1950, "Simon & Schuster");
        kirja.luoID();
        kirja.setAddress("S street 1");

        assertEquals("S street 1", kirja.getAddress());
    }

    @Test
    public void haeKentatToimivat() {
        assertTrue(Kirja.haeKentat().get(0).pakollinen());
        assertTrue(Kirja.haeKentat().get(1).pakollinen());
        assertTrue(Kirja.haeKentat().get(2).pakollinen());
        assertFalse(Kirja.haeKentat().get(3).pakollinen());
        assertFalse(Kirja.haeKentat().get(4).pakollinen());
        assertTrue(Kirja.haeKentat().get(5).pakollinen());
        assertFalse(Kirja.haeKentat().get(6).pakollinen());
        assertFalse(Kirja.haeKentat().get(7).pakollinen());
        assertFalse(Kirja.haeKentat().get(8).pakollinen());
        assertFalse(Kirja.haeKentat().get(9).pakollinen());
    }
}
