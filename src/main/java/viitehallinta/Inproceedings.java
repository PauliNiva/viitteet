package viitehallinta;

import java.io.Serializable;
import java.util.List;

/**
 * Luokka inproceedingsviite-olioille, jonka konstruktori on kuormitettu. Perii
 * Viite-luokan ja toteuttaa Serializable rajapinnan.
 */
public class Inproceedings extends Viite implements Serializable {

    private static final long serialVersionUID = 3L;
    private String pages;
    private String publisher;
    private String booktitle;
    private String editor;
    private int volume;
    private String series;
    private String address;
    private String organization;

    /**
     * Parametriton konstruktori.
     */
    public Inproceedings() {}

    /**
     * Konstrukori pakollisilla kentillä
     * @param author String inproceedingisn kirjoittaja.
     * @param title String inproceedingsin otsikko.
     * @param booktitle String julkaisun, jossa inproceedings on julkaistu, nimi.
     * @param year int vuosiluku jolloim julkaisu ilmestyi.
     */
    public Inproceedings(String author, String title, String booktitle, int year) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setBooktitle(booktitle);
        this.setYear(year);
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
    
    /**
     * Luo listan luokan kentistä tietoineen johon sisältyy myös perityt kentät
     * @return luokan kenttien tiedot
     */
    static public List<Kentta> haeKentat() {
        List<Kentta> kentat = Viite.haeKentat();
        kentat.add(new Kentta("Publisher", "merkkijono", false));
        kentat.add(new Kentta("Editor", "merkkijono", false));
        kentat.add(new Kentta("Book title", "merkkijono", true));
        kentat.add(new Kentta("Volume", "kokonaisluku", false));
        kentat.add(new Kentta("Series", "merkkijono", false));
        kentat.add(new Kentta("Pages", "merkkijono", false));
        kentat.add(new Kentta("Address", "merkkijono", false));
        kentat.add(new Kentta("Organization", "merkkijono", false));
        
        return kentat;
    }
}
