package util;

public class Util {

    /**
     * Muotoile kokonaisluku jolle käyttäjä ei mahdollisesti ole halunnut antaa
     * arvoa tulostukseen sopivaan muotoon.
     *
     * @param luku kokonaisluku joka halutaan tulostaa
     * @return String tulostettava merkkijono
     */
    public static String muotoileNumeroMerkkijonoksi(int luku) {
        String tuloste;

        if (luku == Integer.MIN_VALUE) {
            tuloste = "";
        } else {
            tuloste = Integer.toString(luku);
        }

        return tuloste;
    }
}
