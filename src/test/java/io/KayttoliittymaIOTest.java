package io;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * JUnit-Testit KayttoliittymaIO-luokalle.
 */
public class KayttoliittymaIOTest {

    private KayttoliittymaIO io;

    @Before
    public void setUp() {
        this.io = new KayttoliittymaIO();
    }

    @Test
    public void tulostaRiviTest() {
        io.tulostaRivi("foo");
        assertNotNull(io);
    }

    @Test
    public void tulostaIlmanRivinvaihtoaTest() {
        io.tulostaIlmanRivinvaihtoa("bar");
        assertNotNull(io);
    }

    @Test
    public void lueRiviTest() {        
        io.asetaLuettavaRivi("illuminati");
        assertEquals("illuminati", io.lueRivi());
    }
    
   
}

