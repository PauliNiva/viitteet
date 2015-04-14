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

    /**
     * Hakee tiedostosta kaikki viitteet, tekee niistä Artikkeli-oliot ja lisää
     * ne listalle, jota viitearkisto käyttää.
     * @return lista Artikkeli-olioita.
     */
    public List<Artikkeli> lueArtikkelit();
}
