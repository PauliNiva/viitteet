package viitehallinta;

public class Artikkeli extends Viite{
    
    private String author;
    private String journal;
    private int year;
    private int volume;

    public Artikkeli(String title, String author, String journal, int year, int volume) {
        super(title);
        this.author = author;
        this.journal = journal;
        this.year = year;
        this.volume = volume;
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
