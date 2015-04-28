package viitehallinta;

import dao.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Luokka viitteiden lisäämiseen ja poistamiseen järjestelmästä.
 */
public class Viitearkisto {

    /**
     * Lista, jossa viitteitä säilytetään kun ohjelma on käynnissä.
     */
    private List<Viite> viitteet;

    /**
     * Dao tietojen tiedostoon tallentamiseen ja sieltä lukemiseen.
     */
    private dao fileDao;

    public Viitearkisto() {
        this.fileDao = new FileDao();
        this.viitteet = new ArrayList<>();
    }

    /**
     * Konstruktori. Luodaan viite-lista.
     *
     * @param fileDao
     */
    public Viitearkisto(dao fileDao) {
        this.fileDao = fileDao;
        this.viitteet = new ArrayList<>();
    }

    /**
     * Luo uuden artikkelin ja lisää sille attribuutit setterien avulla metodin
     * saamien parametrien mukaan ja lopuksi lisää uuden artikkelin
     * järjestelmään.
     *
     * @param author String artikkelin kirjoittaja.
     * @param title String artikkelin otsikko.
     * @param journal String julkaisun nimi, jossa artikkeli on ilmestynyt.
     * @param volume int julkaisun osa, jossa artikkeli on ilmestynyt.
     * @param number int julkaisun numero, jossa artikkeli on ilmestynyt.
     * @param year int vuosiluku jolloin julkaisu, jossa artikkeli on, ilmestyi.
     * @param pages String sivunumerot, joista artikkeli löytyy julkaisussa.
     * erotetaan toisistaan kahdella viivalla.
     * @param month int kuukausi jolloin julkaisu, jossa artikkeli on, ilmestyi.
     * @param notes String muu mahdollinen tieto
     */
    public void lisaaArtikkeli(String author, String title, String journal, int volume,
            int number, int year, String pages, int month, String notes) {
        Artikkeli artikkeli = new Artikkeli();
        artikkeli.setAuthor(author);
        artikkeli.setTitle(title);
        artikkeli.setJournal(journal);
        artikkeli.setVolume(volume);
        artikkeli.setNumber(number);
        artikkeli.setYear(year);
        artikkeli.setPages(pages);
        artikkeli.setMonth(month);
        artikkeli.setNote(notes);

        artikkeli.luoID();

        this.viitteet.add(artikkeli);
        tallenna();
    }

    /**
     * Tallentaa viitteet tiedostoon.
     */
    public void tallenna() {
        this.fileDao.tallennaViitteet(viitteet);
    }

    /**
     * Hakee viitteet tiedostosta listaan.
     */
    public void lueTiedosto() {
        this.viitteet = this.fileDao.lueViitteetTiedostosta();
    }

    /**
     * Hakee Viitelistan.
     *
     * @return Listan viite-olioita
     */
    public List<Viite> getViitteet() {
        return viitteet;
    }

    /**
     * Luo uuden kirja-olion ja lisää sille attribuutit setterien avulla metodin
     * saamien parametrien mukaan. Lopuksi metodi lisää uuden kirjan
     * järjestelmään.
     *
     * @param author String kirjan kirjoittajan nimi.
     * @param title String kirjan nimi.
     * @param year int kirjan julkaisuvuosi.
     * @param publisher String kirjan julkaisija.
     * @param address String kirjan julkaisijan osoite.
     * @param volume int julkaisun numero
     * @param series String kirjasarjan nimi
     * @param edition String kirjan painos
     * @param month int kuukausi jolloin julkaisu ilmestyi.
     * @param notes String muu mahdollinen tieto
     */
    public void lisaaKirja(String author, String title, int year, String publisher, String address,
            int volume, String series, String edition, int month, String notes) {
        Kirja kirja = new Kirja();
        kirja.setAuthor(author);
        kirja.setTitle(title);
        kirja.setYear(year);
        kirja.setPublisher(publisher);
        kirja.setAddress(address);
        kirja.setVolume(volume);
        kirja.setSeries(series);
        kirja.setEdition(edition);
        kirja.setMonth(month);
        kirja.setNote(notes);

        kirja.luoID();

        this.viitteet.add(kirja);
        tallenna();
    }

    /**
     * Luo uuden konferenssijulkaisu-olion ja lisää sille attribuutit setterien
     * avulla metodin saamien parametrien mukaan ja lisää uuden
     * konferenssijulkaisun järjestelmään.
     *
     * @param author String konferenssijulkaisun tekijän nimi.
     * @param title String konferenssijulkaisun otsikko.
     * @param booktitle String konferenssijulkaisun kirjan nimi, jos haluttu
     * otsikko on vain osa kirjasta.
     * @param year int konferenssijulkaisun julkaisuvuosi.
     * @param pages String sivunumerot, joista artikkeli löytyy julkaisussa.
     * erotetaan toisistaan kahdella viivalla.
     * @param publisher String konferenssijulkaisun julkaisija, jos kirja.
     * @param editor String editorien nimet
     * @param volume int julkaisun numero
     * @param series String kirjasarjan nimi
     * @param address String kirjan julkaisijan osoite
     * @param organization String Konferenssi sponsori
     * @param month int kuukausi jolloin julkaisu ilmestyi.
     * @param notes String muu mahdollinen tieto
     */
    public void lisaaInproceedings(String author, String title, String booktitle, int year,
            String pages, String publisher, String editor, int volume, String series,
            String address, String organization, int month, String notes) {
        Inproceedings inproceedings = new Inproceedings();
        inproceedings.setAuthor(author);
        inproceedings.setTitle(title);
        inproceedings.setBooktitle(booktitle);
        inproceedings.setYear(year);
        inproceedings.setPages(pages);
        inproceedings.setPublisher(publisher);
        inproceedings.setEditor(editor);
        inproceedings.setVolume(volume);
        inproceedings.setSeries(series);
        inproceedings.setAddress(address);
        inproceedings.setOrganization(organization);
        inproceedings.setMonth(month);
        inproceedings.setNote(notes);

        inproceedings.luoID();

        this.viitteet.add(inproceedings);
        tallenna();
    }

    /**
     * Luo uuden misc-olion ja lisää sille attribuutit setterien avulla metodin
     * saamien parametrien mukaan ja lisää lopuksi uuden miscin järjestelmään.
     *
     * @param author Sting tekijän nimi.
     * @param title String otsikko.
     * @param howpublished String miten ja missä julkaistu.
     * @param month String kuukausi, jolloin julkaistu.
     * @param year String vuosi, jolloin julkaistu.
     * @param note String muu mahdollinen tieto
     */
    public void lisaaMisc(String author, String title, String howpublished, int month, int year, String note) {
        Misc misc = new Misc();
        misc.setAuthor(author);
        misc.setTitle(title);
        misc.setHowPublished(howpublished);
        misc.setMonth(month);
        misc.setYear(year);
        misc.setNote(note);

        misc.luoID();

        this.viitteet.add(misc);
        tallenna();
    }

    /**
     * Poistaa viitteen järjestelmästä parametrinaan saadun yksilöllisen ID:n
     * avulla.
     *
     * @param poistettavaViite String käyttäjän syöttämä ID, jolla etsitään
     * oikea poistettava viite.
     */
    public void poistaViite(String poistettavaViite) {
        Iterator<Viite> iteraattori = viitteet.iterator();
        while (iteraattori.hasNext()) {
            if (iteraattori.next().getID().equals(poistettavaViite)) {
                iteraattori.remove();
            }
        }
        tallenna();
    }

    /**
     * Etsii hakusanaa vastaavan viitteen (viitteet) ja palauttaa listan
     * osumista
     *
     * @param hakusana käyttäjän syöttämä merkkijono, jolla etsitään viitteitä
     * @return lista, joka sisältää hakusanan sisältäneet viitteet
     */
    public List<Viite> etsiViite(String hakusana) {
        List<Viite> osumat = new ArrayList<Viite>();
        for (Viite viite : viitteet) {
            if (viite.getAuthor().toLowerCase().contains(hakusana.toLowerCase())) {
                osumat.add(viite);
            } else if (viite.getTitle().toLowerCase().contains(hakusana.toLowerCase())) {
                osumat.add(viite);
            } else if (viite.getID().toLowerCase().contains(hakusana.toLowerCase())){
                osumat.add(viite);
            }

        }
        return osumat;
    }
    
    /**
     * Muokkaa haluttua viitettä, jos viite löytyy. Poistaa samalla vanhan viitteen.
     * @param muokattava muokattavan viitteen ID
     * @return merkkijono, joka on muokattavan viitteen tyyppi
     */
    public String muokkaaViite(String muokattava) {
        String muokattavaViite = "";
        for (Viite viite : viitteet) {
            if (viite.getID().equals(muokattava)) {
                poistaViite(muokattava);
                muokattavaViite = String.valueOf(viite.getClass());
                break;
            }
        }
        if (muokattavaViite.contains("Artikkeli")) {
            return "Artikkeli";
        }
        if (muokattavaViite.contains("Kirja")) {
            return "Kirja";
        }
        if (muokattavaViite.contains("Misc")) {
            return "Misc";
        }
        if (muokattavaViite.contains("Inproceedings")) {
            return "Inproceedings";
        }
        return null;
    }
}
