package dao;

import java.util.List;
import viitehallinta.Artikkeli;



/**
 * Rajapinta tallentamaan viitteet tiedostoon.
 */
public interface dao {

    /**
     * Tallentaa viitteet tiedostoon
     * @param artikkelit
     */
    public void kirjoitaArtikkelit(List<Artikkeli> artikkelit);
    
    public List<Artikkeli> lueArtikkelit();
}
