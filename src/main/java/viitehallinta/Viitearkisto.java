package viitehallinta;

/**
 * Luokka viitteiden lisäämiseen ja poistamiseen järjestelmästä.
 */
public class Viitearkisto {

    /**
     * Konstruktori ilman parametreja.
     */
    public Viitearkisto() {}

    /**
     * Lisää uuden artikkelin järjestelmään.
     * @param title String julkaisun otsikko.
     * @param author String julkaisun kirjoittaja.
     * @param journal String lehti jossa julkaisu on ilmestynyt.
     * @param year int Vuosi jolloin lehti, jossa julkaisu on, ilmestyi.
     * @param volume int lehden, jossa julkaisu ilmestyi, numero.
     */
    public void lisaaArtikkeli(String title, String author, String journal, int year, int volume) {
        Artikkeli artikkeli = new Artikkeli();
        artikkeli.setTitle(title);
        artikkeli.setAuthor(author);
        artikkeli.setJournal(journal);
        artikkeli.setYear(year);
        artikkeli.setVolume(volume);
        // Tähän pitää lisätä daon toiminnallisuutta jolla artikkeli lisätään ja tallennetaan toedostoon.
    }


}
