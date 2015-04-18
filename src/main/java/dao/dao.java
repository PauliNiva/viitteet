package dao;

import java.util.List;
import viitehallinta.Viite;

/**
 * Rajapinta tallentamaan viitteet tiedostoon.
 */
public interface dao {

    /**
     * Tallentaa viitteet tiedostoon
     *
     * @param viitteet
     */
    public void tallennaViitteet(List<Viite> viitteet);

    /**
     * Hakee tiedostosta kaikki viitteet, tekee niistä Artikkeli-oliot ja lisää
     * ne listalle, jota viitearkisto käyttää.
     *
     * @return lista Artikkeli-olioita.
     */
    public List<Viite> lueViitteetTiedostosta();
}
