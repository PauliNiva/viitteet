package dao;

import java.util.List;
import viitehallinta.Viite;

/**
 * Rajapinta tallentamaan viitteet tiedostoon.
 */
public interface Dao {

    /**
     * Tallentaa viitteet tiedostoon
     *
     * @param viitteet
     */
    public void tallennaViitteet(List<Viite> viitteet);

    /**
     * Hakee tiedostosta viitelistan.
     *
     * @return lista Viite-olioita.
     */
    public List<Viite> lueViitteetTiedostosta();
}
