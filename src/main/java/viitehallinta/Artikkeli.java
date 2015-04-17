package viitehallinta;

import java.io.Serializable;

/**
 * Luokka artikkeliviite-olioille, jonka konstruktori on kuormitettu.
 * Perii Viite-luokan.
 */
public class Artikkeli extends Viite implements Serializable {

    static final long serialVersionUID = 1L;
    private String journal;
    private int volume;
    private int number;
    private String address;

    /**
     * Konstruktori ilman kenttiä.
     */
    public Artikkeli() {
    }

    /**
     * Konstruktori kentillä.
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
     * asettaa viitetyypiksi artikkelin
     */
    public Artikkeli(String ID, String author, String title, String journal, int volume, int number,  int year,
                     String pages, String publisher, String address) {
        this.setID(ID);
        this.setAuthor(author);
        this.setTitle(title);
        this.setJournal(journal);
        this.setVolume(volume);
        this.setNumber(number);
        this.setYear(year);
        this.setPages(pages);
        this.setPublisher(publisher);
        this.setAddress(address);
        this.setViiteTyyppi("Artikkeli");
    }
    
    /**
     *
     * @return
     */
    public String getTiedostoMuoto() {
        return this.getID()+":"+this.getAuthor()+":"+this.getTitle()+":"+this.getJournal()+":"+this.getVolume()+
                ":"+this.getNumber()+":"+this.getYear()+":"+this.getPages()+":"+this.getPublisher()+":"+this.getAddress()+"\n";
    }

    /**
     *
     * @return
     */
    public String getJournal() {
        return journal;
    }

    /**
     *
     * @param journal
     */
    public void setJournal(String journal) {
        this.journal = journal;
    }

    /**
     *
     * @return
     */
    public int getVolume() {
        return volume;
    }

    /**
     *
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     *
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
