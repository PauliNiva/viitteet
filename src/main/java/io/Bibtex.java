
package io;

import dao.FileDao;
import java.io.File;
import java.io.IOException;
import java.util.List;
import ui.Kayttoliittyma;
import viitehallinta.Viite;
import viitehallinta.Viitearkisto;

/**
 *
 * Luokka joka luo viitteistä BibTex-muotoisen tiedoston
 */
public class Bibtex {
    private List<Viite> viitteet;
    private IO io;
    private FileDao dao;

    /**
     * luonnissa tarvitsemme viitearkiston ja käyttöliittymän
     * 
     * @param viitearkisto
     * @param io
     * @param tiedosto
     */
    public Bibtex(Viitearkisto viitearkisto, IO io, String tiedosto) {
        this.io = io;
        this.dao = new FileDao(tiedosto, io);
        // this.viitteet = viitearkisto.getViitteet sitten kun refaktorointi on valmis
    }
    
    /**
     *
     * @throws IOException
     */
    public void luoTiedosto() throws IOException{
        dao.tyhjennaTiedosto();
        for (int i = 0; i < viitteet.size(); i++) {
            String viitetyyppi = viitteet.get(i).getViiteTyyppi();
            if (viitetyyppi.equals("Artikkeli")){
                lisaaArtikkeliTiedostoon(viitteet.get(i));
            }
            if (viitetyyppi.equals("Kirja")){
                lisaaKirjaTiedostoon(viitteet.get(i));
            }
        }
    }

    /**
     *
     * @param artikkeli
     * @throws IOException
     */
    public void lisaaArtikkeliTiedostoon(Viite artikkeli) throws IOException {
        dao.lisaaRiviTiedostoon("@article{" + tarkastaAakkoset(artikkeli.getID()) + ",");
    }

    /**
     *
     * @param kirja
     */
    public void lisaaKirjaTiedostoon(Viite kirja) {

    }

    /**
     * tarkastaa ja muuttaa parametrina annetun merkkijonon ääkköset bibitex-muotoon
     * @param rivi
     * @return
     */
    public String tarkastaAakkoset(String rivi) {
        String korjattuRivi = "";
        
        return korjattuRivi;
    }
    
}
