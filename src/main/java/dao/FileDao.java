/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import io.IO;
import io.KayttoliittymaIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import viitehallinta.Artikkeli;
import viitehallinta.Viite;

/**
 * Tiedostoon tallettava DAO, joka toteuttaa rajapinnan dao
 */
public class FileDao implements dao {

    private File tiedosto;
    private List<Artikkeli> artikkelit;
    private IO io;
    /**
     * Konstruktoriin syötetään tiedosto, johon viitteet tallennetaan
     * @param tiedosto
     */
    public FileDao(String tiedosto, IO io) {
        this.tiedosto = new File(tiedosto);
        this.io = io;
    }

    /**
     * Kirjoittaa viitearkistolla listassa olevat artikkelit tiedostoon
     *
     * @param artikkelit tiedostoon tallennettavat artikkelit
     */
    @Override
    public void kirjoitaArtikkelit(List<Artikkeli> artikkelit) {
        try {
            FileWriter kirjoittaja = new FileWriter(tiedosto);
            for (Artikkeli artikkeli : artikkelit) {
                kirjoittaja.write(artikkeli.getTiedostoMuoto());
            }
            kirjoittaja.close();

        } catch (IOException ex) {
            io.tulostaRivi("Tiedostoa ei löytynyt!");
        }

    }

    /**
     * Hakee tiedostosta kaikki viitteet, tekee niistä Artikkeli-oliot ja lisää
     * ne listalle, jota viitearkisto käyttää.
     *
     * @return lista Artikkeli-olioita
     */
    @Override
    public List<Artikkeli> lueArtikkelit() {
        artikkelit = new ArrayList();
        try {
            Scanner lukija = new Scanner(tiedosto);
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] osat = rivi.split(":");
                String id = osat[0];
                String author = osat[1];
                String title = osat[2];
                String journal = osat[3];
                String volume = osat[4];
                String number = osat[5];
                String year = osat[6];
                String pages = osat[7];
                String publisher = osat[8];
                String address = osat[9];

                Artikkeli artikkeli = new Artikkeli(id, author, title, journal, Integer.parseInt(volume),
                        Integer.parseInt(number), Integer.parseInt(year), pages, publisher, address);
                artikkelit.add(artikkeli);
            }

        } catch (FileNotFoundException ex) {
            io.tulostaRivi("Tiedostoa ei löytynyt!");
        }
        return artikkelit;
    }

    /**
     * poistaa tekstitiedoston sisällön
     * @throws FileNotFoundException
     */
    public void tyhjennaTiedosto() throws FileNotFoundException, IOException   {
        FileOutputStream writer = new FileOutputStream(tiedosto);
        writer.close();
    }
   

}
