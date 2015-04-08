package viitehallinta;

import io.KayttoliittymaIO;
import ui.Kayttoliittyma;

/**
 * Luokka ohjelman käynnistämiseen.
 */
public class Main {

    /**
     * Luo tekstipohjaisen käyttöliittymän, jota kautta ohjelmaa käytetään,
     * lisäksi luo viitearkiston joka hoitaa viitteiden lisäämisen ja tallentamisen
     * järjestelmään, sekä olion käyttäjän syötteiden lukemiseen ja ohjelman tulosteiden
     * näyttämiseen. Lopuksi käynnistää käyttöliittymän, joka toimii niin kauan kunnes
     * käyttäjä valitsee ohjelmasta poistumisen.
     * @param args komentoriviargumentit String-taulukon objekteina.
     */
    public static void main(String[] args) {
        KayttoliittymaIO kayttoliittymaIO = new KayttoliittymaIO();
        Viitearkisto viitearkisto = new Viitearkisto();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(kayttoliittymaIO, viitearkisto);
        kayttoliittyma.kaynnista();
    }
}
