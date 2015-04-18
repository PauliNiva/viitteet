package dao;

import io.IO;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import viitehallinta.Viite;

public class BibDao implements dao {

    private IO io;
    private String tiedosto;

    /**
     *
     * @param tiedosto
     * @param io
     */
    public BibDao(String tiedosto, IO io) {
        this.io = io;
        this.tiedosto = tiedosto;
    }

    @Override
    public void tallennaViitteet(List<Viite> viitteet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Viite> lueViitteetTiedostosta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
