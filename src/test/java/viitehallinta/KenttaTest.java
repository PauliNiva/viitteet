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

    @Test public void luoKonstruktoriTest() {
        kentta = new Kentta("Author", "merkkijono", true); 
        assertEquals("Author", kentta.getNimi());
        assertEquals("merkkijono", kentta.getTietotyyppi());
        assertTrue(kentta.pakollinen());
    }
}
