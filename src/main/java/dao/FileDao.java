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
     * @param artikkelit lista tallennettavia artikkeleita
     */
    @Override
    public void kirjoitaArtikkelit(List<Artikkeli> artikkelit) {
        try {
            FileWriter kirjoittaja = new FileWriter(tiedosto);
            for(Artikkeli artikkeli : artikkelit) {
                kirjoittaja.write(artikkeli.getTiedostoMuoto());
            }
            kirjoittaja.close();
            
        } catch (IOException ex) {
            System.out.println("Tiedostoa ei löytynyt!");
        }
        
    }

    @Override
    public List<Artikkeli> lueArtikelit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
