package viitehallinta;

import java.io.Serializable;

/**
 * Luokka inproceedingsviite-olioille, jonka konstruktori on kuormitettu. Perii
 * Viite-luokan ja toteuttaa Serializable rajapinnan.
 */
public class Inproceedings extends Viite implements Serializable {

    private static final long serialVersionUID = 3L;
    private String booktitle;

    /**
     * Parametriton konstruktori.
     */
    public Inproceedings() {}

    /**
     * Konstrukori kentillä
     * @param ID String joka toimii yksilöllisenä (uniikkina) tunnisteena.
     * @param author String inproceedingisn kirjoittaja.
     * @param title String inproceedingsin otsikko.
     * @param booktitle String julkaisun, jossa inproceedings on julkaistu, nimi.
     * @param year int vuosiluku jolloim julkaisu ilmestyi.
     * @param pages String sivut joilta inproceedongs löytyy julkaisussa.
     * @param publisher String julkaisun julkaisija.
     */
    public Inproceedings(String ID, String author, String title, String booktitle, int year, String pages, String publisher) {
        this.setID(ID);
        this.setAuthor(author);
        this.setTitle(title);
        this.setBooktitle(booktitle);
        this.setYear(year);
        this.setPages(pages);
        this.setPublisher(publisher);
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }
}
