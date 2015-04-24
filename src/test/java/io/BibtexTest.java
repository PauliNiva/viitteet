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
        Viite artikkeli = new Artikkeli("author", "title", "journal", 2, 1999);
        artikkeli.luoID();
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
        Viite kirja = new Kirja("lokki", "lintu", 2015, "publisher");
        bib.lisaaKirjaBibViitteetTiedostoon(kirja);
        Scanner lukija = new Scanner(new FileReader(tiedosto));
        ArrayList<String> rivit = new ArrayList<String>();
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            rivit.add(rivi);
        }
        assertEquals(13, rivit.size());

        dao.tyhjennaTiedosto();
    }

    @Test
    public void luoTiedostoTest() throws IOException {
        dao.tyhjennaTiedosto();
        Viite kirja = new Kirja();
        viitearkisto.lisaaKirja("lokki", "lintu", 2015, "pubi", "address", 10, "series", "edition", 12, "notes");
        viitearkisto.lisaaArtikkeli("author", "title", "journal", 1, 2, 1999, "pages", 12, "notes");
        bib.luoTiedosto();

        Scanner lukija = new Scanner(new FileReader(tiedosto));
        ArrayList<String> rivit = new ArrayList<String>();
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            rivit.add(rivi);
            System.out.println(rivi);
        }
        assertEquals(24, rivit.size());

        dao.tyhjennaTiedosto();

    }
}
