package viitehallinta;

import java.io.Serializable;

public class Misc extends Viite implements Serializable {

    private static final long serialVersionUID = 4L;
    private String howpublished;
    private int month;
    private String note;

    /**
     * Konstruktori ilman kenttiä.
     */
    public Misc() {}
    
    /**
     * Konstruktori kentillä.
     * @param ID String joka toimii yksilöölisenä (uniikkina) tunnisteena.
     * @param author Sting tekijän nimi.
     * @param title String otsikko.
     * @param howpublished String miten ja missä julkaistu.
     * @param month String kuukausi, jolloin julkaistu.
     * @param year String vuosi, jolloin julkaistu.
     * @param note String lisäosio, esim. url tai tarkempi kuvaus.
     */
    public Misc(String ID, String author, String title, String howpublished, int month, int year, String note) {
        this.setID(ID);
        this.setAuthor(author);
        this.setTitle(title);
        this.setHowPublished(howpublished);
        this.setMonth(month);
        this.setYear(year);
        this.setNote(note);
    }

    public String getHowPublished() {
        return this.howpublished;
    }
    
    public void setHowPublished(String howpublished) {
        this.howpublished = howpublished;
    }
    
    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
    
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
}
