package io;

import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * JUnit-Testit KayttoliittymaIO-luokalle.
 */
public class KayttoliittymaIOTest {

    private KayttoliittymaIO io;

    public KayttoliittymaIOTest() {
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
        
    }
    
   
}

