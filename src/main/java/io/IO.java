package io;

/**
 * Rajapinta käyttäjän syötteiden lukemiseen ja ohjelman tulosteiden
 * näyttämiseen.
 */
public interface IO {

    /**
     * Lukee käyttäjän antaman syöterivin.
     *
     * @return Luetun rivin Stringinä.
     */
    String lueRivi();

    /**
     * Tulostaa rivin ilman rivinvaihtoa.
     *
     * @param rivi String tulostettava rivi.
     */
    void tulostaIlmanRivinvaihtoa(String rivi);

    /**
     * Tulostaa rivin rivinvaidolla.
     *
     * @param rivi
     */
    void tulostaRivi(String rivi);
}
