package viitehallinta;

import java.io.Serializable;
import java.util.List;

/**
 * Luokka kirjaviitte-oliolle, jonka konstruktori on kuormitettu. Perii viite
 * luokan ja toteuttaa Serializable rajapinnan.
 */
public class Kirja extends Viite implements Serializable {

    private static final long serialVersionUID = 2L;
    private String publisher;
    private String address;
    private int volume;
    private String series;
    private String edition;

    /**
     * Parametriton konstruktori.
     */
    public Kirja() {
    }

    /**
     * Kontruktori pakollisilla kentillä.
     *
     * @param author String kirjan kirjoittaja.
     * @param title String kirjan nimi.
     * @param year int kiirjan julkaisuvuosi
     * @param publisher String kustanjan nimi
     */
    public Kirja(String author, String title, int year, String publisher) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setYear(year);
        this.setPublisher(publisher);
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * Luo listan luokan kentistä tietoineen johon sisältyy myös perityt kentät
     * @return luokan kenttien tiedot
     */
    static public List<Kentta> haeKentat() {
        List<Kentta> kentat = Viite.haeKentat();
        kentat.add(new Kentta("Publisher", "merkkijono", true));
        kentat.add(new Kentta("Address", "merkkijono", false));
        kentat.add(new Kentta("Volume", "kokonaisluku", false));
        kentat.add(new Kentta("Series", "merkkijono", false));
        kentat.add(new Kentta("Edition", "merkkijono", false));

        return kentat;
    }
}
