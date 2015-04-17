package main;

import dao.FileDao;
import io.KayttoliittymaIO;
import ui.Kayttoliittyma;
import viitehallinta.Viitearkisto;

/**
 *  Luokka ohjelman käynnistämiseen
 */
public class Kaynnistaja {

    /**
     * Luo IO:n käyttäjän syötteiden lukemiseen ja ohjelman tulosteiden näyttämiseen, sekä
     * Daon tiedostojen tallentamiseen ja lukemiseen. Dao saa parametreikseen
     * käytettävän tiedoston ja luodun IO olion.
     * Lisäksi luo viitearkiston joka hoitaa viitteiden lisäämisen ja tallentamisen
     * järjestelmään parametrinaan saadun Daon avulla. Lopuksi luo teksitopohjaisen käyttöliittymän,
     * joka saa parametreikseen IO:n ja viitearkiston, sekä käynnistää tämän.
     * Ohjelma on käynnissä niin kauan kunnes käyttäjä valitsee ohjelmasta poistumisen.
     * @param args komentoriviargumentit String-taulukon objekteina.
     */
    public void kaynnista(String[] args) {
        KayttoliittymaIO kayttoliittymaIO = new KayttoliittymaIO();
        Viitearkisto viitearkisto = new Viitearkisto();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(kayttoliittymaIO, viitearkisto);
        kayttoliittyma.kaynnista();
    }
}