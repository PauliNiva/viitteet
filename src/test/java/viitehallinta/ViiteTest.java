package viitehallinta;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit-testit Viite-luokalle.
 */
public class ViiteTest {

    @Test
    public void setAndGetIDTest() {
        Viite viite = new Viite();
        viite.setID("g3");
        assertEquals("g3", viite.getID());
    }

    @Test
    public void setAndGetAuthor() {
        Viite viite = new Viite();
        viite.setAuthor("Arto Vihavainen");
        assertEquals("Arto Vihavainen", viite.getAuthor());
    }

    @Test
    public void setAndGetTitle() {
        Viite viite = new Viite();
        viite.setTitle("Ratebeer");
        assertEquals("Ratebeer", viite.getTitle());
    }

    @Test
    public void setAndGetYearTest() {
        Viite viite = new Viite();
        viite.setYear(2013);
        assertEquals(2013, viite.getYear());
    }

    @Test
    public void setAndGetPagesTest() {
        Viite viite = new Viite();
        viite.setPages("69--96");
        assertEquals("69--96", viite.getPages());
    }

    @Test
    public void setAndGetPublisherTest() {
        Viite viite = new Viite();
        viite.setPublisher("Olutsanomat");
        assertEquals("Olutsanomat", viite.getPublisher());
    }
}
