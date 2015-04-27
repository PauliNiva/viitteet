package viitehallinta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Yleisluokka viitteille, jolla on attribuuttina kaikille viitteille yhteiset
 * attribuutit. Spesifit viiteluokat perivät tämän yläluokan. Toteuttaa
 * rajapinnan Serializable.
 */
public class Viite implements Serializable {

    private String ID;
    private String author;
    private String title;
    private int year;
    private int month;
    private String note;

    /**
     * Luo viitteen tunnisteen tekijän 1. nimen osan, julkaisuvuoden ja otsikon
     * perusteella.
     */
    public void luoID() {
        StringBuilder viiteID = new StringBuilder();

        int tekijanAlkuosa = etsiAlkuosa(author);
        viiteID.append(author.substring(0, tekijanAlkuosa));
        if (year != Integer.MIN_VALUE) {
            viiteID.append(year);
        }
        int otsikonAlkuosa = etsiAlkuosa(title);
        viiteID.append(title.substring(0, otsikonAlkuosa));

        ID = viiteID.toString();
    }

    /**
     * Etsii annetusta merkkijonosta 1. välin tai pilkun ja palauttaa sen kohdan
     * tai ellei kumpaakaan löydy niin koko merkkijonon pituuden.
     *
     * @param merkkijono josta kohtaa haetaan
     * @return indeksi merkkijonon etsittyyn kohtaan
     */
    protected int etsiAlkuosa(String merkkijono) {
        int indeksi = merkkijono.length();

        int ekaVali = merkkijono.indexOf(" ");
        int ekaPilkku = merkkijono.indexOf(",");

        if (ekaVali >= 0 && ekaPilkku >= 0) {
            indeksi = ekaVali < ekaPilkku ? ekaVali : ekaPilkku;
        } else if (ekaPilkku < 0 && ekaVali >= 0) {
            indeksi = ekaVali;
        } else if (ekaPilkku >= 0 && ekaVali < 0) {
            indeksi = ekaPilkku;
        }

        return indeksi;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Luo listan luokan kentistä tietoineen
     *
     * @return luokan kenttien tiedot
     */
    static protected List<Kentta> haeKentat() {
        List<Kentta> kentat = new ArrayList<Kentta>();
        kentat.add(new Kentta("Author", "merkkijono", true));
        kentat.add(new Kentta("Title", "merkkijono", true));
        kentat.add(new Kentta("Year", "kokonaisluku", true));
        kentat.add(new Kentta("Month", "kokonaisluku", false));
        kentat.add(new Kentta("Note", "merkkijono", false));

        return kentat;
    }
}
