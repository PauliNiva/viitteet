package ui;

import dao.FileDao;
import io.IO;
import io.KayttoliittymaIO;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import viitehallinta.Viitearkisto;
import static org.mockito.Mockito.*;
import viitehallinta.Artikkeli;

/**
 * Luokka käyttöliittymän testaamiseen.
 */
public class KayttoliittymaTest {

    IO mockIo;
    FileDao testiDao;
    Viitearkisto mockViitearkisto;
    Kayttoliittyma kayttoliittyma;
    Viitearkisto viitearkisto;

    @Before
    public void setUp() {
        mockIo = mock(KayttoliittymaIO.class);
        testiDao = new FileDao("testiviite.txt", mockIo);
        mockViitearkisto = mock(Viitearkisto.class);
        kayttoliittyma = new Kayttoliittyma(mockIo, mockViitearkisto);
        viitearkisto = new Viitearkisto(testiDao);
    }
    
    @Test
    public void naytaValikkoJaPyydaValintaTest(){
        kayttoliittyma.naytaValikkoJaPyydaValinta();
        verify(mockIo, times(5)).tulostaRivi(anyString());
    }
    

    @Test
    public void kaynnistaTest() {
        when(mockIo.lueRivi()).thenReturn("5");
        kayttoliittyma.kaynnista();

        verify(mockViitearkisto, times(1)).lueTiedosto();

    }

    @Test
    public void toteutaValikonValintaTest() throws IOException {
        when(mockIo.lueRivi()).thenReturn("5");
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(1));
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(2));
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(3));
        assertEquals(false, kayttoliittyma.toteutaValikonValinta(4));
    }

    @Test
    public void listaaViitteetTest() throws IOException {
        testiDao = new FileDao("tyhjatestiviite.tmp", mockIo);
        viitearkisto = new Viitearkisto(testiDao);
        Kayttoliittyma kali = new Kayttoliittyma(mockIo, viitearkisto);
        viitearkisto.lisaaArtikkeli("1", "Lokki", "lintu", "1", 1, 2, 2015, "1", "1", "katu");
        kali.listaaViitteet();
        verify(mockIo, times(15)).tulostaRivi(anyString());
        testiDao.tyhjennaTiedosto();
    }

    @Test
    public void luoArtikkeliTest() {
        when(mockIo.lueRivi()).thenReturn("5");
        kayttoliittyma.luoArtikkeli(new Artikkeli());
        verify(mockViitearkisto, times(1)).lisaaArtikkeli(anyString(), anyString(), anyString() , anyString(), anyInt(), anyInt(), anyInt(), anyString(), anyString(), anyString());
    }
    
    

}
