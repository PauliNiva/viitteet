package dao;

import io.IO;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import viitehallinta.Viite;

/**
 *
 * Dao bibtex tiedoston hallintaan
 */
public class BibDao  {

    private IO io;
    private String tiedosto;
    private List<Viite> viitteet;

    /**
     * Konstruktori, jolle annetaan haluttu tiedosto ja IO jota
     * käytetään.
     * @param tiedosto
     * @param io
     */
    public BibDao(String tiedosto, IO io) {
        this.io = io;
        this.tiedosto = tiedosto;
    }

    /**
     * tyhjentää tiedoston
     *
     * @throws IOException
     */
    public void tyhjennaTiedosto() throws IOException {
        FileOutputStream writer = new FileOutputStream(tiedosto);
        writer.close();
    }

    /**
     * lisää tiedoston loppuun parametrina annetun merkkijono
     *
     * @param rivi
     * @throws IOException
     */
    public void lisaaRiviTiedostoon(String rivi) throws IOException {
        FileWriter kirjoittaja = new FileWriter(tiedosto, true);

        kirjoittaja.write(rivi + "\n");
        kirjoittaja.close();
    }

    
}
