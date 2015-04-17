package io;

import dao.FileDao;
import java.io.File;
import java.io.IOException;
import java.util.List;
import ui.Kayttoliittyma;
import viitehallinta.Viite;
import viitehallinta.Viitearkisto;

/**
 *
 * Luokka joka luo viitteistä BibTex-muotoisen tiedoston
 */
public class Bibtex {

    private List<Viite> viitteet;
    private IO io;
    private FileDao dao;
    private String tiedosto;

    /**
     * luonnissa tarvitsemme viitearkiston ja käyttöliittymän sekä tiedoston,
     * tiedoston nimeä voisi kysyä käyttäjältä tiedoston luonnin valinnan
     * yhteydessä
     *
     * @param viitearkisto
     * @param io
     * @param tiedosto
     */
    public Bibtex(Viitearkisto viitearkisto, IO io, String tiedosto) {
        this.io = io;
        this.dao = new FileDao(tiedosto, io);
        this.tiedosto = tiedosto;
        // this.viitteet = viitearkisto.getViitteet sitten kun refaktorointi on valmis
    }

    /**
     * tyhjentää tiedoston aluksi, jonka jälkeen luo tiedoston kutsumalla eri
     * metodeita erityyppisille Viite-olioille
     *
     * @throws IOException
     */
    public void luoTiedosto() throws IOException {
        dao.tyhjennaTiedosto();
        for (int i = 0; i < viitteet.size(); i++) {
            String viitetyyppi = viitteet.get(i).getViiteTyyppi();
            if (viitetyyppi.equals("Artikkeli")) {
                lisaaArtikkeliTiedostoon(viitteet.get(i));
            }
            if (viitetyyppi.equals("Kirja")) {
                lisaaKirjaTiedostoon(viitteet.get(i));
            }
        }

        io.tulostaRivi("Viitteet lisätty " + tiedosto + " tiedostoon");
    }

    /**
     * lisää tiedostoon BibTex-muodossa artikkelin tiedot, 
     * TODO!
     * ensimmäisen
     * rivin sisältö on hieman mysteeri mutta oletin sen olevan ID 
     * TODO!!
     * artikkelin ulos ottaminen objectina, getclassilla luokan haku ja objectin
     * castaaminen oikeaksi luokaksi mahdollista!
     *
     * @param artikkeli
     * @throws IOException
     */
    public void lisaaArtikkeliTiedostoon(Viite artikkeli) throws IOException {
        dao.lisaaRiviTiedostoon("@article{" + tarkastaAakkoset(artikkeli.getID()) + ",");
        dao.lisaaRiviTiedostoon("author = {" + tarkastaAakkoset(artikkeli.getAuthor()) + "},");
        dao.lisaaRiviTiedostoon("title = {" + tarkastaAakkoset(artikkeli.getTitle()) + "},");
        //dao.lisaaRiviTiedostoon("journal = {" + tarkastaAakkoset(artikkeli.getJournal()) + "},");
        //dao.lisaaRiviTiedostoon("volume = {" + tarkastaAakkoset(artikkeli.getVolume()) + "},");
        //dao.lisaaRiviTiedostoon("number = {" + tarkastaAakkoset(artikkeli.getNumber()) + "},");
        dao.lisaaRiviTiedostoon("year = {" + artikkeli.getYear() + "},");
        dao.lisaaRiviTiedostoon("pages = {" + tarkastaAakkoset(artikkeli.getPages()) + "},");
        dao.lisaaRiviTiedostoon("publisher = {" + tarkastaAakkoset(artikkeli.getPublisher()) + "},");
        dao.lisaaRiviTiedostoon("}");
        dao.lisaaRiviTiedostoon("");
    }

    /**
     * TODO! samaan tyyliin kuin artikkelin lisäys
     *
     * @param kirja
     */
    public void lisaaKirjaTiedostoon(Viite kirja) {

    }

    /**
     * TODO!! tarkastaa ja muuttaa parametrina annetun merkkijonon ääkköset
     * bibitex-muotoon
     *
     * @param rivi
     * @return
     */
    public String tarkastaAakkoset(String rivi) {
        String korjattuRivi = rivi;

        return korjattuRivi;
    }

}
