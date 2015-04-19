package dao;

import io.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import viitehallinta.Viite;

/**
 * Tiedostoon tallettava DAO, joka toteuttaa rajapinnan dao
 */
public class FileDao implements Dao {

    /**
     * Tiedosto jota ohjelma käyttää tietojen tallentamiseen ja säilyttämiseen.
     */
    private String viitetiedosto = "viitetiedosto.tmp";

    private File tiedosto;

    /**
     * Lista, jossa Artikkelit säilytetään kun ohjelma on käynnissä.
     */
    private List<Viite> viitteet;

    /**
     * IO käyttäjän syötteiden lukemiseen ja ohjelman tulosteiden näyttämiseen.
     */
    private IO io;

    public FileDao() {
    }

    /**
     * Konstruktoriin syötetään IO-olio jota käytetään. Tämä konstruktori käyttää
     * oletustiedostoa, joka on viitetiedosto.tmp
     *
     * @param io
     */
    public FileDao(IO io) {
        this.io = io;
    }

    /**
     * Konstruktori, jos tarvitsee spesifioida mitä tiedostoa halutaan käytettävän.
     *
     * @param tiedosto String tiedosto, jos ei haluta käyttää oletus tiedostoa.
     * @param io
     */
    public FileDao(String tiedosto, IO io) {
        this.io = io;
    }

    /**
     * Kirjoittaa viitearkistolla listassa olevat artikkelit tiedostoon Heittää
     * poikkeuksen jos tieodostoa ei löydy.
     *
     * @param viitteet tiedostoon tallennettavat artikkelit
     */
    @Override
    public void tallennaViitteet(List<Viite> viitteet) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(viitetiedosto);
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(viitteet);
            }
        } catch (IOException ex) {
            io.tulostaRivi("Tiedostoa ei löytynyt!");
        }
    }

    /**
     * Hakee tiedostosta kaikki viitteet, tekee niistä Artikkeli-oliot ja lisää
     * ne listalle, jota viitearkisto käyttää. Heittää poikkeuksen jos tiedostoa
     * ei löydy.
     *
     * @return lista Artikkeli-olioita
     */
    @Override
    public List<Viite> lueViitteetTiedostosta() {
        ArrayList<Viite> viitteet = new ArrayList<Viite>();
        try {
            FileInputStream fileInputStream = new FileInputStream(viitetiedosto);
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                viitteet = (ArrayList<Viite>) objectInputStream.readObject();
            }
            return viitteet;
        } catch (ClassNotFoundException e) {
            return viitteet;
        } catch (IOException e) {
            return viitteet;
        }
    }

    /**
     * Poistaa tekstitiedoston sisällön.
     *
     * @throws IOException
     */
    public void tyhjennaTiedosto() throws IOException {
        FileOutputStream writer = new FileOutputStream(viitetiedosto);
        writer.close();
    }
}
