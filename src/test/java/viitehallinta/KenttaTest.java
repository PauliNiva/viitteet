package viitehallinta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KenttaTest {

    Kentta kentta;

    public KenttaTest() {
    }

    @Before
    public void setUp() {
        kentta = new Kentta("Author", "merkkijono", true);
    }

    @Test
    public void luoKonstruktoriTest() {
        assertEquals("Author", kentta.getNimi());
        assertEquals("merkkijono", kentta.getTietotyyppi());
        assertEquals(true, kentta.pakollinen());
    }

    @Test
    public void setNimiTest() {
        kentta.setNimi("New Author");
        assertEquals("New Author", kentta.getNimi());
    }

    @Test
    public void setTietotyyppiTest() {
        kentta.setTietotyyppi("kokonaisluku");
        assertEquals("kokonaisluku", kentta.getTietotyyppi());
    }

    @Test
    public void setPakollisuusTest() {
        kentta.setPakollisuus(false);
        assertEquals(false, kentta.pakollinen());
    }
}
