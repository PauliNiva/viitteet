package viitehallinta;

import java.io.Serializable;

/**
 * Luokka kirjaviitte-oliolle, jonka konstruktori on kuormitettu.
 * Perii viite luokan ja toteuttaa Serializable rajapinnan.
 */
public class Kirja extends Viite implements Serializable {

    private static final long serialVersionUID = 2L;
    private String address;

    /**
     * Parametritön konstruktori.
     */
    public Kirja() {}

    /**
     * Kontruktori parametreilla.
     * @param id String joka toimii yksillöllisenä (uniikkina)tunnisteena;
     * @param author String kirjan kirjoittaja.
     * @param title String kirjan nimi.
     * @param year int kiirjan julkaisuvuosi
     * @param publisher String kustanjan nimi
     * @param address String kustantajan osoite.
     */
    public Kirja(String id, String author, String title, int year, String publisher, String address) {
        this.setID(id);
        this.setAuthor(author);
        this.setTitle(title);
        this.setYear(year);
        this.setPublisher(publisher);
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

