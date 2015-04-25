package viitehallinta;

import java.io.Serializable;
import java.util.List;

/**
 * Luokka artikkeliviite-olioille, jonka konstruktori on kuormitettu. Perii
 * Viite-luokan ja toteuttaa Serializable rajapinnan.
 */
public class Artikkeli extends Viite implements Serializable {

    static final long serialVersionUID = 1L;
    private String pages;
    private String journal;
    private int volume;
    private int number;

    /**
     * Konstruktori ilman kenttiä.
     */
    public Artikkeli() {
    }

    /**
     * Konstruktori pakollisilla kentillä.
     *
     * @param author String artikkelin kirjoittaja.
     * @param title String artikkelin otsikko.
     * @param journal String julkaisun nimi, jossa artikkeli on ilmestynyt.
     * @param volume int julkaisun osa, jossa artikkeli on ilmestynyt.
     * @param year int vuosiluku jolloin julkaisu, jossa artikkeli on, ilmestyi.
     */
    public Artikkeli(String author, String title, String journal, int volume, int year) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setJournal(journal);
        this.setVolume(volume);
        this.setYear(year);
    }

    public String getTiedostoMuoto() {
        return this.getID() + ":" + this.getAuthor() + ":" + this.getTitle() + ":" + this.getJournal() + ":" + this.getVolume()
                + ":" + this.getNumber() + ":" + this.getYear() + ":" + this.getPages() +"\n";
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    /**
     * Luo listan luokan kentistä tietoineen johon sisältyy myös perityt kentät
     * @return luokan kenttien tiedot
     */
    static public List<Kentta> haeKentat() {
        List<Kentta> kentat = Viite.haeKentat();
        kentat.add(new Kentta("Pages", "merkkijono", false));
        kentat.add(new Kentta("Journal", "merkkijono", true));
        kentat.add(new Kentta("Volume", "kokonaisluku", true));
        kentat.add(new Kentta("Number", "kokonaisluku", false));
        
        return kentat;
    }
}
