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
        kirja = new Kirja("BK01", "Charles M. Schulz", "Charlie Brown", 1950, "Simon & Schuster", "S street 1");
        assertEquals("BK01", kirja.getID());
        assertEquals("Charles M. Schulz", kirja.getAuthor());
        assertEquals("Charlie Brown", kirja.getTitle());
        assertEquals(1950, kirja.getYear());
        assertEquals("Simon & Schuster", kirja.getPublisher());
        assertEquals("S street 1", kirja.getAddress());
    }

    @Test
    public void testGetAddress() {
        kirja = new Kirja("BK01", "Charles M. Schulz", "Charlie Brown", 1950, "Simon & Schuster", "S street 1");
        assertEquals("S street 1", kirja.getAddress());
    }

    @Test
    public void testSetAddress() {
        kirja = new Kirja("BK01", "Charles M. Schulz", "Charlie Brown", 1950, "Simon & Schuster", "S street 1");
        kirja.setAddress("Brown street 7");
        assertEquals("Brown street 7", kirja.getAddress());
    }

}
