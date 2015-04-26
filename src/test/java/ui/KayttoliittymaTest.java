package ui;

import dao.FileDao;
import io.IO;
import io.KayttoliittymaIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import viitehallinta.Viitearkisto;
import static org.mockito.Mockito.*;
import viitehallinta.Artikkeli;
import viitehallinta.Inproceedings;
import viitehallinta.Viite;

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
        verify(mockIo, times(7)).tulostaRivi(anyString());
    }

    @Test
    public void kaynnistaTest() {
        when(mockIo.lueRivi()).thenReturn("0");
        kayttoliittyma.kaynnista();
        verify(mockViitearkisto, times(1)).lueTiedosto();

    }

    @Test
    public void kaynnistaVaarallaNumerolla() {
        when(mockIo.lueRivi()).thenReturn("99");
        verify(mockViitearkisto, never()).lueTiedosto();
        verify(mockViitearkisto, never()).tallenna();

        when(mockIo.lueRivi()).thenReturn("0");
        kayttoliittyma.kaynnista();

    }

    @Test
    public void toteutaValikonValintaTest() throws IOException {
        when(mockIo.lueRivi()).thenReturn("1").thenReturn("0");
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(1));
        when(mockIo.lueRivi()).thenReturn("2").thenReturn("0");
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(1));
        when(mockIo.lueRivi()).thenReturn("0");
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(1));
        when(mockIo.lueRivi()).thenReturn("0");
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(2));
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(3));
        assertEquals(true, kayttoliittyma.toteutaValikonValinta(4));
    }

    @Test
    public void toteutaViiteValikonValintaTest() throws IOException {
        when(mockIo.lueRivi()).thenReturn("0");
        assertEquals(true, kayttoliittyma.toteutaViitevalikonValinta(3));
        assertEquals(true, kayttoliittyma.toteutaViitevalikonValinta(4));
    }

    @Test
    public void listaaViitteetTest() throws IOException {
        testiDao = new FileDao("tyhjatestiviite.tmp", mockIo);
        viitearkisto = new Viitearkisto(testiDao);
        Kayttoliittyma kali = new Kayttoliittyma(mockIo, viitearkisto);
        viitearkisto.lisaaArtikkeli("Lokki", "lintu", "1", 1, 2, 2015, "1", 11, "katu");
        viitearkisto.lisaaKirja("Charles M. Schulz", "Charlie Brown", 1950, "Simon & Schuster",
                "S street 1", 4, "series", "edition", 12, "notes");
        kali.listaaViitteet(viitearkisto.getViitteet());
        assertEquals(2, viitearkisto.getViitteet().size());
        verify(mockIo, times(29)).tulostaRivi(anyString());
        testiDao.tyhjennaTiedosto();
    }

    @Test
    public void listaaViitteetTest2() throws IOException {
        testiDao = new FileDao("tyhjatestiviite.tmp", mockIo);
        viitearkisto = new Viitearkisto(testiDao);
        Kayttoliittyma kali = new Kayttoliittyma(mockIo, viitearkisto);
        viitearkisto.lisaaMisc("Luoja", "Arska", "www.koe.fi", 2, 2013, "luettu 2.1");
        viitearkisto.lisaaInproceedings("author", "title", "booktitle", 2013, "",
                "publisher", "", 5, "", "", "", 3, "");
        kali.listaaViitteet(viitearkisto.getViitteet());
        assertEquals(2, viitearkisto.getViitteet().size());
        verify(mockIo, times(30)).tulostaRivi(anyString());
        testiDao.tyhjennaTiedosto();
    }

    @Test
    public void luoArtikkeliTest() {
        when(mockIo.lueRivi()).thenReturn("0");
        kayttoliittyma.luoArtikkeli();
        verify(mockViitearkisto, times(1)).lisaaArtikkeli(anyString(), anyString(), anyString(), anyInt(), anyInt(), anyInt(), anyString(), anyInt(), anyString());
    }

    @Test
    public void luoKirjaTest() {
        when(mockIo.lueRivi()).thenReturn("0");
        kayttoliittyma.luoKirja();
        verify(mockViitearkisto, times(1)).lisaaKirja(anyString(), anyString(), anyInt(), anyString(), anyString(), anyInt(), anyString(), anyString(), anyInt(), anyString());
    }

    @Test
    public void luoInproceedingsTest() {
        when(mockIo.lueRivi()).thenReturn("0");
        kayttoliittyma.luoInproceedings();
        verify(mockViitearkisto, times(1)).lisaaInproceedings(anyString(), anyString(), anyString(), anyInt(), anyString(), anyString(), anyString(), anyInt(), anyString(), anyString(), anyString(), anyInt(), anyString());
    }

    @Test
    public void luoMiscTest() {
        when(mockIo.lueRivi()).thenReturn("0");
        kayttoliittyma.luoMisc();
        verify(mockViitearkisto, times(1)).lisaaMisc(anyString(), anyString(), anyString(), anyInt(), anyInt(), anyString());
    }

    @Test
    public void virheellinenValikkoSyoteTest() {
        when(mockIo.lueRivi()).thenReturn("x").thenReturn("0");
        kayttoliittyma.kaynnista();
        verify(mockViitearkisto, times(1)).lueTiedosto();
        verify(mockIo, times(2)).lueRivi();
    }

    @Test
    public void naytaEtsiViite() {
        when(mockIo.lueRivi()).thenReturn("5").thenReturn("author").thenReturn("0");
        List<Viite> mockViitteet = new ArrayList<Viite>();
        mockViitteet.add(new Inproceedings("author", "title", "booktitle", 2013));
        when(mockViitearkisto.etsiViite(anyString())).thenReturn(mockViitteet);
        kayttoliittyma.kaynnista();
        verify(mockViitearkisto, times(1)).etsiViite(anyString());
    }
    @Test
    public void naytaEtsiViiteTyhjallaListalla(){
        when(mockIo.lueRivi()).thenReturn("5").thenReturn("author").thenReturn("0");
        List<Viite> mockViitteet = new ArrayList<Viite>();
        when(mockViitearkisto.etsiViite(anyString())).thenReturn(mockViitteet);
        kayttoliittyma.kaynnista();
        verify(mockViitearkisto, times(1)).etsiViite(anyString());
    }

}
