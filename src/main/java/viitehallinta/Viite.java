package viitehallinta;

import java.io.Serializable;

/**
 * Yleisluokka viitteille, jolla on attribuuttina kaikille viitteille yhteiset
 * attribuutit. Spesifit viiteluokat perivät tämän yläluokan.
 */
public class Viite implements Serializable {

    private String ID;
    private String author;
    private String title;
    private int year;
    private String pages;
    private String publisher;

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
}
