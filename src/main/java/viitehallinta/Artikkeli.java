package viitehallinta;

/**
 * Luokka artikkeliviite-olioille, jonka konstruktori on kuormitettu.
 */
public class Artikkeli {

    private String title;
    private String author;
    private String journal;
    private int year;
    private int volume;

    /**
     * Konstruktori ilman kenttiä.
     */
    public Artikkeli() {
    }

    /**
     * Konstruktori kentillä-
     * @param title String julkaisun otsikko.
     * @param author String julkaisun kirjoittaja.
     * @param journal String lehti jossa julkaisu on ilmestynyt.
     * @param year int Vuosi jolloin lehti, jossa julkaisu on, ilmestyi.
     * @param volume int lehden, jossa julkaisu ilmestyi, numero.
     */
    public Artikkeli(String title, String author, String journal, int year, int volume) {
        this.title = title;
        this.author = author;
        this.journal = journal;
        this.year = year;
        this.volume = volume;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getJournal() {
        return journal;
    }

    public int getYear() {
        return year;
    }

    public int getVolume() {
        return volume;
    }

}
