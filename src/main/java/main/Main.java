package main;

/**
 * Luokka jossa main sijaitsee.
 */
public class Main {

    /**
     * KAynnistäjä ohjelman käynnistämiseen.
     */
    private static Kaynnistaja kaynnistaja = new Kaynnistaja();

    /**
     * Main käynnistää ohjelman toiminnan kutsumalla Kaynnistaja-olion
     * käynnistä-metodia.
     * @param args komentoriviargumentit String-taulukon objekteina.
     */
    public static void main(String[] args) {
        kaynnistaja.kaynnista(args);
    }

    /**
     * Asettaa käynnistäjän.
     * @param kaynnistaja
     */
    static void setKaynnistaja(Kaynnistaja kaynnistaja) {
        Main.kaynnistaja = kaynnistaja;
    }
}
