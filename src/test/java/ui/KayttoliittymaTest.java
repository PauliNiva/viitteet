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
    public void naytaValikkoJaPyydaValintaTest() {
        kayttoliittyma.naytaValikkoJaPyydaValinta();
        verify(mockIo, times(6)).tulostaRivi(anyString());
    }

    @Test
    public void kaynnistaTest() {
        when(mockIo.lueRivi()).thenReturn("5");
        kayttoliittyma.kaynnista();
        verify(mockViitearkisto, times(1)).lueTiedosto();

    }
    @Test
    public void kaynnistaVaarallaNumerolla() {
        when(mockIo.lueRivi()).thenReturn("99");
        verify(mockViitearkisto, never()).lueTiedosto();
        verify(mockViitearkisto, never()).tallenna();
        
        when(mockIo.lueRivi()).thenReturn("5");
        kayttoliittyma.kaynnista();

    }

    @Test
    public void toteutaValikonValintaTest() throws IOException {
        when(mockIo.lueRivi()).thenReturn("1");
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(1));
        when(mockIo.lueRivi()).thenReturn("2");
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(1));
        when(mockIo.lueRivi()).thenReturn("3").thenReturn("5");
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(1));
        when(mockIo.lueRivi()).thenReturn("5");
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(2));
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(3));
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(4));
    }

    @Test
    public void listaaViitteetTest() throws IOException {
        testiDao = new FileDao("tyhjatestiviite.tmp", mockIo);
        viitearkisto = new Viitearkisto(testiDao);
        Kayttoliittyma kali = new Kayttoliittyma(mockIo, viitearkisto);
        viitearkisto.lisaaArtikkeli("1", "Lokki", "lintu", "1", 1, 2, 2015, "1", "1", "katu");
        viitearkisto.lisaaKirja("BK01", "Charles M. Schulz", "Charlie Brown", 1950, "Simon & Schuster", "S street 1");
        kali.listaaViitteet();
        assertEquals(2, viitearkisto.getViitteet().size());
        verify(mockIo, times(24)).tulostaRivi(anyString());
        testiDao.tyhjennaTiedosto();
    }

    @Test
    public void luoArtikkeliTest() {
        when(mockIo.lueRivi()).thenReturn("5");
        kayttoliittyma.luoArtikkeli();
        verify(mockViitearkisto, times(1)).lisaaArtikkeli(anyString(), anyString(), anyString(), anyString(), anyInt(), anyInt(), anyInt(), anyString(), anyString(), anyString());
    }

    @Test
    public void luoKirjaTest() {
        when(mockIo.lueRivi()).thenReturn("5");
        kayttoliittyma.luoKirja();
        verify(mockViitearkisto, times(1)).lisaaKirja(anyString(), anyString(), anyString(), anyInt(), anyString(), anyString());
    }
}
