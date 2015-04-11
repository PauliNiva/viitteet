/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import viitehallinta.Artikkeli;
import viitehallinta.Viite;

/**
 *
 * @author Sonja
 */
public class FileDao implements dao {

    private File tiedosto;

    public FileDao() {
        this.tiedosto = new File("viitteet.txt");
    }

    /**
     * Kirjoittaa listassa olevat artikkelit tiedostoon
     *
     * @param artikkelit lista tallennettavia artikkeleita
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
            System.out.println("Tiedostoa ei löytynyt!");
        }

    }

    @Override
    public List<Artikkeli> lueArtikkelit() {
        List<Artikkeli> artikkelit = new ArrayList();
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
            System.out.println("Tiedostoa ei löytynyt!");
        }

        //String ID, String author, String title, String journal, int volume, int number,  int year,
        // String pages, String publisher, String address
        return artikkelit;
    }

}
