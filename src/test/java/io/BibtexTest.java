package io;

import dao.BibDao;
import dao.FileDao;
import io.Bibtex;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import viitehallinta.*;

/**
 * JUnit-Testit Bibtex-luokalle.
 */
public class BibtexTest {

    private List<Viite> viitteet;
    private Bibtex bib;
    private IO io;
    private BibDao dao;
    private String tiedosto;
    private Viitearkisto viitearkisto;

    @Before
    public void setUp() {
        tiedosto = "bibtest.txt";
        viitearkisto = new Viitearkisto();
        io = new KayttoliittymaIO();
        dao = new BibDao(tiedosto, io);
        this.bib = new Bibtex(viitearkisto, io, tiedosto);

    }

    @Test
    public void tarkastaAakkosetTest() {
        String haluttuRivi = "\\\"{A}\\\"{a}\\\"{O}\\\"{o}\\AA \\aa a";
        String tulos = bib.tarkastaAakkoset("ÄäÖöÅåa");
        assertEquals(haluttuRivi, tulos);
    }
    
    @Test
    public void tarkastaAakkosetVaarillaKirjaimillaTest() {
        String haluttuRivi = "AASSkdkd";
        String tulos = bib.tarkastaAakkoset("AASSkdkd");
        assertEquals(haluttuRivi, tulos);
    }

    @Test
    public void lisaaArtikkeliBibViitteetTiedostoonTest() throws IOException {
        dao.tyhjennaTiedosto();
        Viite artikkeli = new Artikkeli("1", "author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
        bib.lisaaArtikkeliBibViitteetTiedostoon(artikkeli);
        Scanner lukija = new Scanner(new FileReader(tiedosto));
        ArrayList<String> rivit = new ArrayList<String>();
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            rivit.add(rivi);
        }
        assertEquals(11, rivit.size());

        dao.tyhjennaTiedosto();
    }

    @Test
    public void lisaaKirjaBibViitteetTiedostoonTest() throws IOException {
        dao.tyhjennaTiedosto();
        Viite kirja = new Kirja("9", "lokki", "lintu", 2015, "pubi", "katu1");
        bib.lisaaKirjaBibViitteetTiedostoon(kirja);
        Scanner lukija = new Scanner(new FileReader(tiedosto));
        ArrayList<String> rivit = new ArrayList<String>();
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            rivit.add(rivi);
        }
        assertEquals(7, rivit.size());

        dao.tyhjennaTiedosto();
    }

    @Test
    public void luoTiedostoTest() throws IOException {
        dao.tyhjennaTiedosto();
        Viite kirja = new Kirja();
        viitearkisto.lisaaKirja("9", "lokki", "lintu", 2015, "pubi", "katu1");
        viitearkisto.lisaaArtikkeli("1", "author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
        bib.luoTiedosto();

        Scanner lukija = new Scanner(new FileReader(tiedosto));
        ArrayList<String> rivit = new ArrayList<String>();
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            rivit.add(rivi);
            System.out.println(rivi);
        }
        assertEquals(18, rivit.size());

        dao.tyhjennaTiedosto();

    }
}
