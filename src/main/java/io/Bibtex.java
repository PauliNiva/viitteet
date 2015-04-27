package io;

import dao.BibDao;
import java.io.IOException;
import java.util.List;
import static util.Util.*;

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
            if (viite instanceof Artikkeli) {
                lisaaArtikkeliBibViitteetTiedostoon(viite);
            }
            if (viite instanceof Kirja) {
                lisaaKirjaBibViitteetTiedostoon(viite);
            }
            if (viite instanceof Inproceedings) {
                lisaaInproceedingsBibViitteetTiedostoon(viite);
            }
            if (viite instanceof Misc) {
                lisaaMiscBibViitteetTiedostoon(viite);
            }
        }

        io.tulostaRivi("");
        io.tulostaRivi("Viitteet lisätty " + tiedosto + " tiedostoon");
        io.tulostaRivi("");
    }

    /**
     * Lisää tiedostoon BibTex-muodossa artikkelin tiedot.
     *
     * @param viite lisättävä artikkeli-olio
     * @throws IOException
     */
    public void lisaaArtikkeliBibViitteetTiedostoon(Viite viite) throws IOException {
        Artikkeli artikkeli = (Artikkeli) viite;
        dao.lisaaRiviTiedostoon("@article{" + tarkastaAakkoset(artikkeli.getID()) + ",");
        dao.lisaaRiviTiedostoon("author = {" + tarkastaAakkoset(artikkeli.getAuthor()) + "},");
        dao.lisaaRiviTiedostoon("title = {" + tarkastaAakkoset(artikkeli.getTitle()) + "},");
        dao.lisaaRiviTiedostoon("journal = {" + tarkastaAakkoset(artikkeli.getJournal()) + "},");
        dao.lisaaRiviTiedostoon("volume = {" + artikkeli.getVolume() + "},");
        if (!muotoileNumeroMerkkijonoksi(artikkeli.getNumber()).isEmpty()) {
            dao.lisaaRiviTiedostoon("number = {" + muotoileNumeroMerkkijonoksi(artikkeli.getNumber()) + "},");
        }
        dao.lisaaRiviTiedostoon("year = {" + artikkeli.getYear() + "},");
        if (!muotoileNumeroMerkkijonoksi(artikkeli.getMonth()).isEmpty()) {
            dao.lisaaRiviTiedostoon("month = {" + muotoileNumeroMerkkijonoksi(artikkeli.getMonth()) + "},");
        }
        if (artikkeli.getPages() != null && !artikkeli.getPages().isEmpty()) {
            dao.lisaaRiviTiedostoon("pages = {" + artikkeli.getPages() + "},");
        }
        if (artikkeli.getNote() != null && !artikkeli.getNote().isEmpty()) {
            dao.lisaaRiviTiedostoon("note = {" + tarkastaAakkoset(artikkeli.getNote()) + "},");
        }
        dao.lisaaRiviTiedostoon("}");
        dao.lisaaRiviTiedostoon("");
    }

    /**
     * Lisää tiedostoon BibTex-muodossa kirjan tiedot
     *
     * @param viite Lisättävä kirja-olio
     * @throws IOException
     */
    public void lisaaKirjaBibViitteetTiedostoon(Viite viite) throws IOException {
        Kirja kirja = (Kirja) viite;
        dao.lisaaRiviTiedostoon("@book{" + tarkastaAakkoset(kirja.getID()) + ",");
        dao.lisaaRiviTiedostoon("author = {" + tarkastaAakkoset(kirja.getAuthor()) + "},");
        dao.lisaaRiviTiedostoon("title = {" + tarkastaAakkoset(kirja.getTitle()) + "},");
        dao.lisaaRiviTiedostoon("year = {" + kirja.getYear() + "},");
        dao.lisaaRiviTiedostoon("publisher = {" + tarkastaAakkoset(kirja.getPublisher()) + "},");
        if (kirja.getAddress() != null && !kirja.getAddress().isEmpty()) {
            dao.lisaaRiviTiedostoon("address = {" + tarkastaAakkoset(kirja.getAddress()) + "},");
        }
        if (!muotoileNumeroMerkkijonoksi(kirja.getVolume()).isEmpty()) {
            dao.lisaaRiviTiedostoon("volume = {" + muotoileNumeroMerkkijonoksi(kirja.getVolume()) + "},");
        }
        if (kirja.getSeries() != null && !kirja.getSeries().isEmpty()) {
            dao.lisaaRiviTiedostoon("series = {" + tarkastaAakkoset(kirja.getSeries()) + "},");
        }
        if (kirja.getEdition() != null && !kirja.getEdition().isEmpty()) {
            dao.lisaaRiviTiedostoon("edition = {" + tarkastaAakkoset(kirja.getEdition()) + "},");
        }
        if (!muotoileNumeroMerkkijonoksi(kirja.getMonth()).isEmpty()) {
            dao.lisaaRiviTiedostoon("month = {" + muotoileNumeroMerkkijonoksi(kirja.getMonth()) + "},");
        }
        if (kirja.getNote() != null && !kirja.getNote().isEmpty()) {
            dao.lisaaRiviTiedostoon("note = {" + tarkastaAakkoset(kirja.getNote()) + "},");
        }
        dao.lisaaRiviTiedostoon("}");
        dao.lisaaRiviTiedostoon("");
    }

    /**
     * Lisää tiedostoon BibTex-muodossa inproceedingsin tiedot
     *
     * @param viite lisättävä inproceedings-olio
     * @throws IOException
     */
    public void lisaaInproceedingsBibViitteetTiedostoon(Viite viite) throws IOException {
        Inproceedings inproceedings = (Inproceedings) viite;
        dao.lisaaRiviTiedostoon("@inproceedings{" + tarkastaAakkoset(inproceedings.getID()) + ",");
        dao.lisaaRiviTiedostoon("author = {" + tarkastaAakkoset(inproceedings.getAuthor()) + "},");
        dao.lisaaRiviTiedostoon("title = {" + tarkastaAakkoset(inproceedings.getTitle()) + "},");
        dao.lisaaRiviTiedostoon("booktitle = {" + tarkastaAakkoset(inproceedings.getBooktitle()) + "},");
        dao.lisaaRiviTiedostoon("year = {" + inproceedings.getYear() + "},");
        if (inproceedings.getPages() != null && !inproceedings.getPages().isEmpty()) {
            dao.lisaaRiviTiedostoon("pages = {" + tarkastaAakkoset(inproceedings.getPages()) + "},");
        }
        if (inproceedings.getPublisher() != null && !inproceedings.getPublisher().isEmpty()) {
            dao.lisaaRiviTiedostoon("publisher = {" + tarkastaAakkoset(inproceedings.getPublisher()) + "},");
        }
        if (inproceedings.getEditor() != null && !inproceedings.getEditor().isEmpty()) {
            dao.lisaaRiviTiedostoon("editor = {" + tarkastaAakkoset(inproceedings.getEditor()) + "},");
        }
        if (!muotoileNumeroMerkkijonoksi(inproceedings.getVolume()).isEmpty()) {
            dao.lisaaRiviTiedostoon("volume = {" + muotoileNumeroMerkkijonoksi(inproceedings.getVolume()) + "},");
        }
        if (inproceedings.getSeries() != null && !inproceedings.getSeries().isEmpty()) {
            dao.lisaaRiviTiedostoon("series = {" + tarkastaAakkoset(inproceedings.getSeries()) + "},");
        }
        if (inproceedings.getAddress() != null && !inproceedings.getAddress().isEmpty()) {
            dao.lisaaRiviTiedostoon("address = {" + tarkastaAakkoset(inproceedings.getAddress()) + "},");
        }
        if (inproceedings.getOrganization() != null && !inproceedings.getOrganization().isEmpty()) {
            dao.lisaaRiviTiedostoon("organization = {" + tarkastaAakkoset(inproceedings.getOrganization()) + "},");
        }
        if (!muotoileNumeroMerkkijonoksi(inproceedings.getMonth()).isEmpty()) {
            dao.lisaaRiviTiedostoon("month = {" + muotoileNumeroMerkkijonoksi(inproceedings.getMonth()) + "},");
        }
        if (inproceedings.getNote() != null && !inproceedings.getNote().isEmpty()) {
            dao.lisaaRiviTiedostoon("note = {" + tarkastaAakkoset(inproceedings.getNote()) + "},");
        }
        dao.lisaaRiviTiedostoon("}");
        dao.lisaaRiviTiedostoon("");
    }

    /**
     * Lisää tiedostoon BibTex-muodossa misc-viitteen tiedot
     *
     * @param viite lisättävä misc-olio
     * @throws IOException
     */
    public void lisaaMiscBibViitteetTiedostoon(Viite viite) throws IOException {
        Misc misc = (Misc) viite;
        dao.lisaaRiviTiedostoon("@misc{" + tarkastaAakkoset(((Misc) misc).getID()) + ",");
        if (misc.getAuthor() != null && !misc.getAuthor().isEmpty()) {
            dao.lisaaRiviTiedostoon("author = {" + tarkastaAakkoset(((Misc) misc).getAuthor()) + "},");
        }
        if (misc.getTitle() != null && !misc.getTitle().isEmpty()) {
            dao.lisaaRiviTiedostoon("title = {" + tarkastaAakkoset(((Misc) misc).getTitle()) + "},");
        }
        if (misc.getHowPublished() != null && !misc.getHowPublished().isEmpty()) {
            dao.lisaaRiviTiedostoon("howpublished = " + tarkastaURL(((Misc) misc)) + "{" + tarkastaAakkoset(((Misc) misc).getHowPublished()) + "},");
        }
        if (!muotoileNumeroMerkkijonoksi(misc.getMonth()).isEmpty()) {
            dao.lisaaRiviTiedostoon("month = {" + muotoileNumeroMerkkijonoksi(((Misc) misc).getMonth()) + "},");
        }
        if (!muotoileNumeroMerkkijonoksi(misc.getYear()).isEmpty()) {
            dao.lisaaRiviTiedostoon("year = {" + muotoileNumeroMerkkijonoksi(((Misc) misc).getYear()) + "},");
        }
        if (misc.getNote() != null && !misc.getNote().isEmpty()) {
            dao.lisaaRiviTiedostoon("note = {" + tarkastaAakkoset(((Misc) misc).getNote()) + "},");
        }
        dao.lisaaRiviTiedostoon("}");
        dao.lisaaRiviTiedostoon("");
    }

    /**
     * Tarkastaa onko misc-viiteen howpublished URL
     *
     * @param misc tarkastettava misc-olio
     * @return URL lisän, jos howpublished on URL, jos ei, niin ei palauta
     * mitään
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

        // Syöte voi olla myös null jos kenttä on valinnainen
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
