package io;

import org.junit.*;
import static org.junit.Assert.*;

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
}
