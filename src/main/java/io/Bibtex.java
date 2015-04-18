package io;

import dao.BibDao;
import java.io.IOException;
import java.util.List;
import viitehallinta.Artikkeli;
import viitehallinta.Viite;
import viitehallinta.Viitearkisto;

/**
 *
 * Luokka joka luo viitteistä BibTex-muotoisen tiedoston.
 */
public class Bibtex {

    private List<Viite> viitteet;
    private IO io;
    private String tiedosto;
    private BibDao dao;

    /**
     * luonnissa tarvitsemme viitearkiston ja käyttöliittymän sekä oman
     * tiedoston. kä
     *
     * @param viitearkisto
     * @param io
     * @param tiedosto
     */
    public Bibtex(Viitearkisto viitearkisto, IO io, String tiedosto) {
        this.io = io;
        this.tiedosto = tiedosto;
        this.viitteet = viitearkisto.getViitteet();
        this.dao = new BibDao(tiedosto, io);
    }

    /**
     * tyhjentää tiedoston aluksi, jonka jälkeen luo tiedoston kutsumalla eri
     * metodeita erityyppisille Viite-olioille
     *
     * @throws IOException
     */
    public void luoTiedosto() throws IOException {
        dao.tyhjennaTiedosto();
        for (Viite viite : viitteet) {
            if (viite.getClass().getName().equalsIgnoreCase("viitehallinta.Artikkeli")) {
                lisaaArtikkeliTiedostoon(viite);
            }
            if (viite.getClass().getName().equalsIgnoreCase("viitehallinta.Kirja")) {
                lisaaKirjaTiedostoon(viite);
            }
        }

        io.tulostaRivi("");
        io.tulostaRivi("Viitteet lisätty " + tiedosto + " tiedostoon");
        io.tulostaRivi("");
    }

    /**
     * lisää tiedostoon BibTex-muodossa artikkelin tiedot, TODO! ensimmäisen
     * rivin sisältö on hieman mysteeri mutta oletin sen olevan ID TODO!!
     * artikkelin ulos ottaminen objectina, getclassilla luokan haku ja objectin
     * castaaminen oikeaksi luokaksi mahdollista!
     *
     * @param artikkeli
     * @throws IOException
     */
    public void lisaaArtikkeliTiedostoon(Viite artikkeli) throws IOException {
        dao.lisaaRiviTiedostoon("@article{" + tarkastaAakkoset(((Artikkeli) artikkeli).getID()) + ",");
        dao.lisaaRiviTiedostoon("author = {" + tarkastaAakkoset(((Artikkeli) artikkeli).getAuthor()) + "},");
        dao.lisaaRiviTiedostoon("title = {" + tarkastaAakkoset(((Artikkeli) artikkeli).getTitle()) + "},");
        dao.lisaaRiviTiedostoon("journal = {" + tarkastaAakkoset(((Artikkeli) artikkeli).getJournal()) + "},");
        dao.lisaaRiviTiedostoon("volume = {" + ((Artikkeli) artikkeli).getVolume() + "},");
        dao.lisaaRiviTiedostoon("number = {" + ((Artikkeli) artikkeli).getNumber() + "},");
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
     * Käy läpi parametrina annetun merkkijonon ja tarkastaa, sisältääkö
     * merkkijono ä-, å- tai ö-kirjaimia. Jokainen ä, å ja ö muutetaan BibText
     * muotoiseksi.
     *
     * @param rivi Rivi, jonka ä-, å- ja ö-kirjaimet muutetaan BibTex-muotoon
     * @return BibTex-muotoisen merkkijonon
     */
    public String tarkastaAakkoset(String rivi) {
        String korjattuRivi = "";

        for (char kirjain : rivi.toCharArray()) {
            if (kirjain == 'ä') {
                korjattuRivi += "/\"{a}";
            } else if (kirjain == 'ö') {
                korjattuRivi += "/\"{o}";
            } else if (kirjain == 'å') {
                korjattuRivi += "/r{a}";
            } else if (kirjain == 'Ä') {
                korjattuRivi += "/\"{A}";
            } else if (kirjain == 'Ö') {
                korjattuRivi += "/\"{O}";
            } else if (kirjain == 'Å') {
                korjattuRivi += "/r{A}";
            }
            else {
                korjattuRivi += kirjain;
            }
        }
        return korjattuRivi;
    }
}
