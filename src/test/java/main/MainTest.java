package main;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;

/**
 * Luokka mainin testaamiseen.
 */
public class MainTest {

    Kaynnistaja mockKaynnistaja;

    @Before
    public void setUp() {
        mockKaynnistaja = mock(Kaynnistaja.class);
    }

    @Test
    public void mainTest() throws Exception {
        Main.setKaynnistaja(mockKaynnistaja);
        Main.main(new String[]{"test1", "test2"});
        Mockito.verify(mockKaynnistaja, times(1)).kaynnista(new String[]{"test1", "test2"});
    }
}
