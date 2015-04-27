package io;

import dao.BibDao;
import io.Bibtex;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
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
        assertEquals(10, rivit.size());

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
        assertEquals(9, rivit.size());

        dao.tyhjennaTiedosto();
    }

    @Test
    public void lisaaURLMiscBibViitteetTiedostoonTest() throws IOException {
        dao.tyhjennaTiedosto();
        Misc misc = new Misc();
        misc.setHowPublished("http://koe.fi");
        bib.lisaaMiscBibViitteetTiedostoon(misc);
        Scanner lukija = new Scanner(new FileReader(tiedosto));
        ArrayList<String> rivit = new ArrayList<String>();
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            rivit.add(rivi);
        }
        assertEquals(6, rivit.size());
        String haluttuTulos = "howpublished = \"\\url{http://koe.fi},";
        assertEquals(rivit.get(1), haluttuTulos);
        dao.tyhjennaTiedosto();

        rivit.clear();

        Misc misc1 = new Misc();
        misc1.setHowPublished("www.koe.fi");
        bib.lisaaMiscBibViitteetTiedostoon(misc1);
        lukija = new Scanner(new FileReader(tiedosto));
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            rivit.add(rivi);
        }
        assertEquals(6, rivit.size());
        haluttuTulos = "howpublished = \"\\url{www.koe.fi},";
        assertEquals(rivit.get(1), haluttuTulos);
        dao.tyhjennaTiedosto();
    }

    @Test
    public void lisaaMiscBibViitteetTiedostoonTest() throws IOException {
        dao.tyhjennaTiedosto();
        Misc misc = new Misc();
        misc.setHowPublished("Kirja");
        bib.lisaaMiscBibViitteetTiedostoon(misc);
        Scanner lukija = new Scanner(new FileReader(tiedosto));
        ArrayList<String> rivit = new ArrayList<String>();
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            rivit.add(rivi);
        }
        assertEquals(6, rivit.size());
        String haluttuTulos = "howpublished = {Kirja},";
        assertEquals(rivit.get(1), haluttuTulos);
        dao.tyhjennaTiedosto();
    }

    @Test
    public void lisaaInproceedingsBibViitteetTiedostoonTest() throws IOException {
        dao.tyhjennaTiedosto();
        Inproceedings inpro = new Inproceedings("Masa", "Aliostikko", "Otsikko", 2000);
        inpro.setPages("123--234");
        bib.lisaaInproceedingsBibViitteetTiedostoon(inpro);
        Scanner lukija = new Scanner(new FileReader(tiedosto));
        ArrayList<String> rivit = new ArrayList<String>();
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            rivit.add(rivi);
        }
        assertEquals(10, rivit.size());
        assertEquals(rivit.get(5), "pages = {123--234},");
        assertEquals(rivit.get(1), "author = {Masa},");
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
        assertEquals(25, rivit.size());

        dao.tyhjennaTiedosto();
    }

    @Test
    public void luoTiedostoTest2() throws IOException {
        dao.tyhjennaTiedosto();
        viitearkisto.lisaaMisc("Masa", "Otsikko", "Kirja", 4, 2000, "");
        viitearkisto.lisaaInproceedings("author", "title", "booktitle", 2013, "", "publisher", "", 0, "", "", "", 3, "");
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
