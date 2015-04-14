package viitehallinta;

import dao.dao;
import java.util.ArrayList;
import java.util.List;

/**
 * Luokka viitteiden lisäämiseen ja poistamiseen järjestelmästä.
 */
public class Viitearkisto {

    /**
     * Lista, jossa Artikkelit säilytetään kun ohjelma on käynnissä.
     */
    private List<Artikkeli> artikkelit;

    /**
     * Dao tietojen tiedostoon tallentamiseen ja sieltä lukemiseen.
     */
    private dao fileDao;

    /**
     * Konstruktori ilman parametreja.
     * Luodaan viite-lista. 
     * @param fileDao 
     */
    public Viitearkisto(dao fileDao) {        
        this.fileDao = fileDao;
        this.artikkelit = new ArrayList<Artikkeli>();
    }

    /**
     * Luo uuden artikkelin ja lisää sille attribuuttit setterien avulla
     * metodin saamien parametrien mukaan ja lopuksi lisää uuden artikkelin
     * järjestelmään.
     * @param ID String joka toimii yksillöllisenä (uniikkina)tunnisteena;
     * @param author String artikkelin kirjoittaja.
     * @param title String artikkelin otsikko.
     * @param journal String julkaisun nimi, jossa artikkeli on ilmestynyt.
     * @param volume int julkaisun osa, jossa artikkeli on ilmestynyt.
     * @param number int julkaisun numeri, jossa artikkeli on ilmestynyt.
     * @param year int vuosiluku jolloin julkaisu, jossa artikkeli on, ilmestyi.
     * @param pages String sivunumerot, joista artikkeli löytyy julkaisussa.
     *               erotetaan toisistaan kahdella viivalla.
     * @param publisher String julkaisijan nimi;
     * @param address String julkaisijan osoite;
     */
    public void lisaaArtikkeli(String ID, String author, String title, String journal, int volume,
                               int number, int year, String pages, String publisher, String address) {
        Artikkeli artikkeli = new Artikkeli();
        artikkeli.setID(ID);
        artikkeli.setAuthor(author);
        artikkeli.setTitle(title);
        artikkeli.setJournal(journal);
        artikkeli.setVolume(volume);
        artikkeli.setNumber(number);
        artikkeli.setYear(year);
        artikkeli.setPages(pages);
        artikkeli.setPublisher(publisher);
        artikkeli.setAddress(address);
        this.artikkelit.add(artikkeli);
        tallenna();
    }

    /**
     * Tallentaa artikkelit tiedostoon.
     */
    public void tallenna() {
        this.fileDao.kirjoitaArtikkelit(artikkelit);
    }

    /**
     * Hakee artikkelit tiedostosta listaan.
     */
    public void lueTiedosto() {
        this.artikkelit = this.fileDao.lueArtikkelit();
    }

    /**
     * Hakee artikkeli listan.
     * @return Artikkeli-olio listan
     */
    public List<Artikkeli> getArtikkelit(){
        return artikkelit;
    }
}
