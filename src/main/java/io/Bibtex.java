package io;

import dao.BibDao;
import java.io.IOException;
import java.util.List;

import viitehallinta.*;

/**
 * Luokka joka luo viitteistä BibTex-muotoisen tiedoston.
 */
public class Bibtex {

    private List<Viite> viitteet;
    private IO io;
    private String tiedosto;
    private BibDao dao;

    /**
     * Konstruktori parametreilla.
     *
     * @param viitearkisto Viitearkisto, josta viitteet haetaan.
     * @param io IO syötteiden ja tulosteiden toiminnallisuuteen.
     * @param tiedosto String käytettävä tiedosto.
     */
    public Bibtex(Viitearkisto viitearkisto, IO io, String tiedosto) {
        this.io = io;
        this.tiedosto = tiedosto;
        this.viitteet = viitearkisto.getViitteet();
        this.dao = new BibDao(tiedosto, io);
    }

    /**
     * Tyhjentää tiedoston aluksi, jonka jälkeen luo tiedoston kutsumalla eri
     * metodeita erityyppisille Viite-olioille
     *
     * @throws IOException
     */
    public void luoTiedosto() throws IOException {
        dao.tyhjennaTiedosto();
        for (Viite viite : viitteet) {
            if (viite.getClass().getName().equalsIgnoreCase("viitehallinta.Artikkeli")) {
                lisaaArtikkeliBibViitteetTiedostoon(viite);
            }
            if (viite.getClass().getName().equalsIgnoreCase("viitehallinta.Kirja")) {
                lisaaKirjaBibViitteetTiedostoon(viite);
            }
            if (viite.getClass().getName().equalsIgnoreCase("viitehallinta.Inproceedings")) {
                lisaaInproceedingsBibViitteetTiedostoon(viite);
            }
            if (viite.getClass().getName().equalsIgnoreCase("viitehallinta.Misc")) {
                lisaaMiscBibViitteetTiedostoon(viite);
            }
        }

        io.tulostaRivi("");
        io.tulostaRivi("Viitteet lisatty " + tiedosto + " tiedostoon");
        io.tulostaRivi("");
    }

    /**
     * Lisää tiedostoon BibTex-muodossa artikkelin tiedot.
     *
     * @param artikkeli lisättävä artikkeli-olio
     * @throws IOException
     */
    public void lisaaArtikkeliBibViitteetTiedostoon(Viite artikkeli) throws IOException {
        dao.lisaaRiviTiedostoon("@article{" + tarkastaAakkoset(((Artikkeli) artikkeli).getID()) + ",");
        dao.lisaaRiviTiedostoon("author = {" + tarkastaAakkoset(((Artikkeli) artikkeli).getAuthor()) + "},");
        dao.lisaaRiviTiedostoon("title = {" + tarkastaAakkoset(((Artikkeli) artikkeli).getTitle()) + "},");
        dao.lisaaRiviTiedostoon("journal = {" + tarkastaAakkoset(((Artikkeli) artikkeli).getJournal()) + "},");
        dao.lisaaRiviTiedostoon("volume = {" + ((Artikkeli) artikkeli).getVolume() + "},");
        dao.lisaaRiviTiedostoon("number = {" + ((Artikkeli) artikkeli).getNumber() + "},");
        dao.lisaaRiviTiedostoon("year = {" + artikkeli.getYear() + "},");
        dao.lisaaRiviTiedostoon("month = {" + artikkeli.getMonth() + "},");
        dao.lisaaRiviTiedostoon("note = {" + tarkastaAakkoset(artikkeli.getNote()) + "},");
        dao.lisaaRiviTiedostoon("}");
        dao.lisaaRiviTiedostoon("");
    }

    /**
     * Lisää tiedostoon BibTex-muodossa kirjan tiedot
     *
     * @param kirja Lisättävä kirja-olio
     * @throws IOException
     */
    public void lisaaKirjaBibViitteetTiedostoon(Viite kirja) throws IOException {
        dao.lisaaRiviTiedostoon("@book{" + tarkastaAakkoset(((Kirja) kirja).getID()) + ",");
        dao.lisaaRiviTiedostoon("author = {" + tarkastaAakkoset(((Kirja) kirja).getAuthor()) + "},");
        dao.lisaaRiviTiedostoon("title = {" + tarkastaAakkoset(((Kirja) kirja).getTitle()) + "},");
        dao.lisaaRiviTiedostoon("year = {" + ((Kirja) kirja).getYear() + "},");
        dao.lisaaRiviTiedostoon("publisher = {" + tarkastaAakkoset(((Kirja) kirja).getPublisher()) + "},");
        dao.lisaaRiviTiedostoon("address = {" + tarkastaAakkoset(((Kirja) kirja).getAddress()) + "},");
        dao.lisaaRiviTiedostoon("volume = {" + ((Kirja) kirja).getVolume() + "},");
        dao.lisaaRiviTiedostoon("series = {" + tarkastaAakkoset(((Kirja) kirja).getSeries()) + "},");
        dao.lisaaRiviTiedostoon("edition = {" + tarkastaAakkoset(((Kirja) kirja).getEdition()) + "},");
        dao.lisaaRiviTiedostoon("month = {" + kirja.getMonth() + "},");
        dao.lisaaRiviTiedostoon("note = {" + tarkastaAakkoset(kirja.getNote()) + "},");
        dao.lisaaRiviTiedostoon("}");
        dao.lisaaRiviTiedostoon("");
    }

    /**
     * Lisää tiedostoon BibTex-muodossa inproceedingsin tiedot
     *
     * @param inproceedings lisättävä inproceedings-olio
     * @throws IOException
     */
    public void lisaaInproceedingsBibViitteetTiedostoon(Viite inproceedings) throws IOException {
        dao.lisaaRiviTiedostoon("@inproceedings{" + tarkastaAakkoset(((Inproceedings) inproceedings).getID()) + ",");
        dao.lisaaRiviTiedostoon("author = {" + tarkastaAakkoset(((Inproceedings) inproceedings).getAuthor()) + "},");
        dao.lisaaRiviTiedostoon("title = {" + tarkastaAakkoset(((Inproceedings) inproceedings).getTitle()) + "},");
        dao.lisaaRiviTiedostoon("booktitle = {" + tarkastaAakkoset(((Inproceedings) inproceedings).getBooktitle()) + "},");
        dao.lisaaRiviTiedostoon("year = {" + ((Inproceedings) inproceedings).getYear() + "},");
        dao.lisaaRiviTiedostoon("pages = {" + tarkastaAakkoset(((Inproceedings) inproceedings).getPages()) + "},");
        dao.lisaaRiviTiedostoon("publisher = {" + tarkastaAakkoset(((Inproceedings) inproceedings).getPublisher()) + "},");
        dao.lisaaRiviTiedostoon("editor = {" + tarkastaAakkoset(((Inproceedings) inproceedings).getEditor()) + "},");
        dao.lisaaRiviTiedostoon("volume = {" + ((Inproceedings) inproceedings).getVolume() + "},");
        dao.lisaaRiviTiedostoon("series = {" + tarkastaAakkoset(((Inproceedings) inproceedings).getSeries()) + "},");
        dao.lisaaRiviTiedostoon("address = {" + tarkastaAakkoset(((Inproceedings) inproceedings).getAddress()) + "},");
        dao.lisaaRiviTiedostoon("organization = {" + tarkastaAakkoset(((Inproceedings) inproceedings).getOrganization()) + "},");
        dao.lisaaRiviTiedostoon("month = {" + inproceedings.getMonth() + "},");
        dao.lisaaRiviTiedostoon("note = {" + tarkastaAakkoset(inproceedings.getNote()) + "},");
        dao.lisaaRiviTiedostoon("}");
        dao.lisaaRiviTiedostoon("");
    }

    /**
     * Lisää tiedostoon BibTex-muodossa misc-viitteen tiedot
     *
     * @param misc lisättävä misc-olio
     * @throws IOException
     */
    public void lisaaMiscBibViitteetTiedostoon(Viite misc) throws IOException {
        dao.lisaaRiviTiedostoon("@misc{" + tarkastaAakkoset(((Misc) misc).getID()) + ",");
        dao.lisaaRiviTiedostoon("author = {" + tarkastaAakkoset(((Misc) misc).getAuthor()) + "},");
        dao.lisaaRiviTiedostoon("title = {" + tarkastaAakkoset(((Misc) misc).getTitle()) + "},");
        dao.lisaaRiviTiedostoon("howpublished= " + tarkastaURL(((Misc) misc)) + "{" + tarkastaAakkoset(((Misc) misc).getHowPublished()) + "},");
        dao.lisaaRiviTiedostoon("month = {" + ((Misc) misc).getMonth() + "},");
        dao.lisaaRiviTiedostoon("year = {" + ((Misc) misc).getYear() + "},");
        dao.lisaaRiviTiedostoon("note = {" + tarkastaAakkoset(((Misc) misc).getNote()) + "},");
        dao.lisaaRiviTiedostoon("}");
        dao.lisaaRiviTiedostoon("");
    }

    /**
     * Tarkastaa onko misc-viiteen howpublished URL
     * @param misc tarkastettava misc-olio
     * @return URL lisän, jos howpublished on URL, jos ei, niin ei palauta mitään
     */
    public String tarkastaURL(Misc misc) {
        if (misc.getHowPublished().startsWith("http") || misc.getHowPublished().startsWith("www")) {
            return "\"\\url";
        }
        return "";
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

        if (rivi != null) {
            for (char kirjain : rivi.toCharArray()) {
                if (kirjain == 'ä') {
                    korjattuRivi += "\\\"{a}";
                } else if (kirjain == 'ö') {
                    korjattuRivi += "\\\"{o}";
                } else if (kirjain == 'å') {
                    korjattuRivi += "\\aa ";
                } else if (kirjain == 'Ä') {
                    korjattuRivi += "\\\"{A}";
                } else if (kirjain == 'Ö') {
                    korjattuRivi += "\\\"{O}";
                } else if (kirjain == 'Å') {
                    korjattuRivi += "\\AA ";
                } else {
                    korjattuRivi += kirjain;
                }
            }
        }
        return korjattuRivi;
    }
}
