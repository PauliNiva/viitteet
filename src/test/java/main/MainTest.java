package main;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Luokka mainin testaamiseen.
 */
public class MainTest {

    @Test
    public void mainTest() {
        Kaynnistaja kaynnistaja = Mockito.mock(Kaynnistaja.class);
        Main.setKaynnistaja(kaynnistaja);
        Main.main(new String[]{"test1", "test2"});
        Mockito.verify(kaynnistaja).kaynnista(new String[] {"test1", "test2"});
    }
}
