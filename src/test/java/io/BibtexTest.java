
package io;

import dao.BibDao;
import dao.FileDao;
import io.Bibtex;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import viitehallinta.*;

/**
 * JUnit-Testit Bibtex-luokalle.
 */

public class BibtexTest {
    private Bibtex bib;
    private IO io;
    private BibDao dao;
    private String tiedosto;
    private Viitearkisto viitteet;

    @Before
    public void setUp() {
        this.io = mock(KayttoliittymaIO.class);
        this.tiedosto = "testiviite.txt";
        this.viitteet = mock(Viitearkisto.class);
        
        viitteet.lisaaViiteTestaukseen("9", "lokki", "lintu", 2015, "pubi", "katu1");
        
        this.bib = new Bibtex(viitteet, io, tiedosto);
        this.dao = bib.getBibDao();
    }
    
    @Test
    public void tarkastaAakkosetTest() {
        String haluttuRivi = "/\"{A}/\"{a}/\"{O}/\"{o}/r{A}/r{a}";
        String tulos = bib.tarkastaAakkoset("ÄäÖöÅå");
        assertEquals(haluttuRivi, tulos);
    }
    
//    @Test
//    public void lisaaArtikkeliBibViitteetTiedostoonTest() throws IOException {
//        Viite artikkeli = new Artikkeli("1", "author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
//        bib.lisaaArtikkeliBibViitteetTiedostoon(artikkeli);
//
//        dao.lueViitteetTiedostosta();
//        assertEquals(1, dao.getViitteet().size());
//        
//        dao.tyhjennaTiedosto();
//    }
//    
//    @Test
//    public void lisaaKirjaBibViitteetTiedostoonTest() throws IOException {
//        Viite kirja = new Kirja("9", "lokki", "lintu", 2015, "pubi", "katu1");
//        bib.lisaaKirjaBibViitteetTiedostoon(kirja);
//
//        dao.lueViitteetTiedostosta();
//        assertEquals(1, dao.getViitteet().size());
//        
//        dao.tyhjennaTiedosto();
//    }
}
