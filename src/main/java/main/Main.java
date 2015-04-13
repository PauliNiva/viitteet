package main;

/**
 * Luokka ohjelman käynnistämiseen.
 */
public class Main {

    private static Kaynnistaja kaynnistaja = new Kaynnistaja();

    /**
     * Luo tekstipohjaisen käyttöliittymän, jota kautta ohjelmaa käytetään,
     * lisäksi luo viitearkiston joka hoitaa viitteiden lisäämisen ja tallentamisen
     * järjestelmään, sekä olion käyttäjän syötteiden lukemiseen ja ohjelman tulosteiden
     * näyttämiseen. Lopuksi käynnistää käyttöliittymän, joka toimii niin kauan kunnes
     * käyttäjä valitsee ohjelmasta poistumisen.
     * @param args komentoriviargumentit String-taulukon objekteina.
     */
    public static void main(String[] args) {
        kaynnistaja.kaynnista(args);
    }

    static void setKaynnistaja(Kaynnistaja kaynnistaja) {
        Main.kaynnistaja = kaynnistaja;
    }
}
