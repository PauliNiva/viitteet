package ui;

import io.IO;
import viitehallinta.Artikkeli;
import viitehallinta.Viitearkisto;

/**
 * Tekstipohjainen käyttöliittymä, joka toteuttaa UI-rajapinnan.
 */
public class Kayttoliittyma implements UI {

    /**
     * IO käyttäjän syötteille ja ohjelman tulosteille.
     */
    private IO io;

    /**
     * Viitearkisto viitteiden tallentamiseen ja lisäämiseen.
     */
    private Viitearkisto viitearkisto;

    /**
     * Konstruktori.
     * @param io IO käyttäjän syötteiden lukemiseen ja ohjelman tulosteiden näyttämiseen.
     * @param viitearkisto Viitearkisto viitteiden lisäämiseen ja tallentamiseen.
     */
    public Kayttoliittyma(IO io, Viitearkisto viitearkisto) {
        this.io = io;
        this.viitearkisto = viitearkisto;
    }

    /**
     * Käynnistää UI:n ja pitää ohjelman käynnissä kunnes käyttäjä valitsee valikosta lopetuksen.
     */
    @Override
    public void kaynnista() {
        do {
            naytaValikkoJaPyydaValinta();
        } while (toteutaValikonValinta(getKayttajanValinta()));
    }

    /**
     * Näyttää valikon konsolissa.
     */
    @Override
    public void naytaValikkoJaPyydaValinta() {
        io.tulostaRivi("Valitse toiminto: ");
        io.tulostaRivi("(1) Luo Artikkeli");
        io.tulostaRivi("(2) Listaa viitteet");
        io.tulostaRivi("(3) Poista Artikkeli");
        io.tulostaRivi("(4) Lopeta");
    }

    /**
     * Hakee käyttäjän valinnan valikosta.
     * @return käyttäjän valinnan.
     */
    private int getKayttajanValinta() {
        String valinta = io.lueRivi();
        return Integer.parseInt(valinta);
    }

    /**
     * Toteuttaa käyttäjän valikkovalinnan.
     * @param kayttajanValinta Kokonaisluku joka ilmaisee käyttäjän valikosta valitseman toiminnon.
     * @return True jos käyttäjä valitsee minkä tahansa muun kuin lopettamisen, tällöin palautetaan false.
     */
    private boolean toteutaValikonValinta(int kayttajanValinta) {
        switch (kayttajanValinta) {
            case 1: {
                luoArtikkeli(new Artikkeli());
                break;
            }
            case 2: {
                listaaViitteet();
                break;
            }
            case 3: {
                poistaViite();
                break;
            }
            case 4: {
                return false;
            }
        }
        return true;
    }

    /**
     * Luo artikkelin kentät taulukkoon ja ajaa metodit lisaaArtikkeli ja taytaKentat.
     * @param artikkeli Artikkeli-olio joka on tyhjä.
     */
    private void luoArtikkeli(Artikkeli artikkeli) {
        String[] kentat = new String[] {"Title", "Author", "Journal", "Year", "Volume"};
        lisaaArtikkeli(artikkeli, taytaKentat(kentat));
    }

    /**
     * Lisää artikkelin järjestelmään viitearkisto-luokan lisaaArtikkeli metodilla.
     * @param artikkeli
     * @param taytetytKentat String-taulukko, jossa on käyttäjän täyttämät kentät.
     */
    private void lisaaArtikkeli(Artikkeli artikkeli, String[] taytetytKentat) {
        viitearkisto.lisaaArtikkeli(taytetytKentat[0], taytetytKentat[1], taytetytKentat[2], StringLuvuksi(taytetytKentat[3]), StringLuvuksi(taytetytKentat[4]));
    }

    /**
     * Antaa kentät käyttäjän täytettäviksi riveittäin kenttä kerrallaan.
     * @param kentat String-taulukko, jossa on kenttien nimet, jotka kenttä kerrallaan annetaan käyttäjän täytettäväksi.
     * @return String-taulukko, jossa on kentät täytettynä.
     */
    private String[] taytaKentat(String[] kentat) {
        String[] taytettavatKentat = new String[kentat.length];
        for (int i = 0; i < kentat.length; i++) {
            io.tulostaIlmanRivinvaihtoa(kentat[i] + ": ");
            taytettavatKentat[i] = io.lueRivi();
        }
        return taytettavatKentat;
    }

    /**
     * //TODO!!
     * todennäköiseti poistaa viitteen viitearkiston metodia apuna käyttäen.
     * @return varmaankin poistettavan viitteen jonkinlainen tunniste.
     */
    @Override
    public int poistaViite() {
        return 0;
    }

    /**
     * //TODO!!
     * Listaa järjestelmässä olevat kaikki viitteet riveittäin.
     */
    public void listaaViitteet() {

    }

    /**
     * Muuttaa Stringinä olevan numeron kokonaisluvuksi.
     * @param numeraali Stringinä saatava numero
     * @return int:iksi muutetun kokonaisluvun.
     */
    private int StringLuvuksi(String numeraali) {
        return Integer.parseInt(numeraali);
    }

}