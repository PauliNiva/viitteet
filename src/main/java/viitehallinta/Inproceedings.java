package viitehallinta;

import java.io.Serializable;

public class Inproceedings extends Viite implements Serializable {

    private static final long serialVersionUID = 3L;
    private String booktitle;

    public Inproceedings() {}

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
