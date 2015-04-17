package ui;

import io.IO;
import java.util.List;
import viitehallinta.Artikkeli;
import viitehallinta.Kirja;
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
     *
     * @param io IO käyttäjän syötteiden lukemiseen ja ohjelman tulosteiden
     * näyttämiseen.
     * @param viitearkisto Viitearkisto viitteiden lisäämiseen ja
     * tallentamiseen.
     */
    public Kayttoliittyma(IO io, Viitearkisto viitearkisto) {
        this.io = io;
        this.viitearkisto = viitearkisto;
    }

    /**
     * Lukee tiedostosta viitteet ohjelman muistiin ja käynnistää UI:n, sekä
     * pitää ohjelman käynnissä kunnes käyttäjä valitsee valikosta lopetuksen.
     */
    @Override
    public void kaynnista() {
        lueTiedosto();
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
        io.tulostaRivi("(1) Luo viite");
        io.tulostaRivi("(2) Listaa viitteet");
        io.tulostaRivi("(3) Poista Artikkeli");
        io.tulostaRivi("(4) Lopeta");
    }

    /**
     * Hakee käyttäjän valinnan valikosta.
     *
     * @return käyttäjän valinnan.
     */
    private int getKayttajanValinta() {
        String valinta = io.lueRivi();
        return Integer.parseInt(valinta);
    }

    /**
     * Toteuttaa käyttäjän valikkovalinnan.
     *
     * @param kayttajanValinta Kokonaisluku joka ilmaisee käyttäjän valikosta
     * valitseman toiminnon.
     * @return True jos käyttäjä valitsee minkä tahansa muun kuin lopettamisen,
     * tällöin viitteet tallennetaan tiedostoon ja palautetaan false.
     */
    public boolean toteutaValikonValinta(int kayttajanValinta) {
        switch (kayttajanValinta) {
            case 1: {
                naytaViiteValikko();
//                luoArtikkeli(new Artikkeli());
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
                tallennaTiedostoon();
                return false;
            }
        }
        return true;
    }

    private boolean toteutaViitevalikonValinta(int kayttajanValinta) {
        switch (kayttajanValinta) {
            case 1: {
                luoArtikkeli(new Artikkeli());
                break;
            }
            case 2: {
                luoKirja(new Kirja());
                break;
            }
            case 3: {
                do {
                    naytaValikkoJaPyydaValinta();
                } while (toteutaValikonValinta(getKayttajanValinta()));
            }
        }
        return true;
    }

    private void naytaViiteValikko() {
        io.tulostaRivi("Valitse viitetyypi: ");
        io.tulostaRivi("(1) Luo artikkeli-viite");
        io.tulostaRivi("(2) Luo kirja-viite");
        io.tulostaRivi("(3) Palaa päävalikkoon");
        toteutaViitevalikonValinta(getKayttajanValinta());
    }

    /**
     * Luo artikkelin kentät taulukkoon ja ajaa metodit lisaaArtikkeli ja
     * taytaKentat.
     *
     * @param artikkeli Artikkeli-olio joka on tyhjä.
     */
    public void luoArtikkeli(Artikkeli artikkeli) {
        String[] kentat = new String[]{"ID", "Author", "Title", "Journal", "Volume", "Number", "Year",
            "Pages", "Publisher", "Address"};
        lisaaArtikkeli(artikkeli, taytaKentat(kentat));
    }

    private void luoKirja(Kirja kirja) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Lisää artikkelin järjestelmään viitearkisto-luokan lisaaArtikkeli
     * metodilla. Tulostaa lopuksi käyttäjälle viestin lisäyksen onnistumisesta.
     *
     * @param artikkeli
     * @param taytetytKentat String-taulukko, jossa on käyttäjän täyttämät
     * kentät.
     */
    public void lisaaArtikkeli(Artikkeli artikkeli, String[] taytetytKentat) {
        viitearkisto.lisaaArtikkeli(taytetytKentat[0], taytetytKentat[1], taytetytKentat[2], taytetytKentat[3],
                StringLuvuksi(taytetytKentat[4]), StringLuvuksi(taytetytKentat[5]), StringLuvuksi(taytetytKentat[6]),
                taytetytKentat[7], taytetytKentat[8], taytetytKentat[9]);
        io.tulostaRivi("");
        io.tulostaRivi("Artikkeli lisätty onnistuneesti");
        io.tulostaRivi("");
    }

    /**
     * Antaa kentät käyttäjän täytettäviksi riveittäin kenttä kerrallaan.
     *
     * @param kentat String-taulukko, jossa on kenttien nimet, jotka kenttä
     * kerrallaan annetaan käyttäjän täytettäväksi.
     * @return String-taulukko, jossa on kentät täytettynä.
     */
    public String[] taytaKentat(String[] kentat) {
        String[] taytettavatKentat = new String[kentat.length];
        for (int i = 0; i < kentat.length; i++) {
            io.tulostaIlmanRivinvaihtoa(kentat[i] + ": ");
            taytettavatKentat[i] = io.lueRivi();
        }
        return taytettavatKentat;
    }

    /**
     * //TODO!! todennäköiseti poistaa viitteen viitearkiston metodia apuna
     * käyttäen.
     *
     * @return varmaankin poistettavan viitteen jonkinlainen tunniste.
     */
    @Override
    public int poistaViite() {
        return 0;
    }

    /**
     * Listaa järjestelmässä olevat artikkeli-viitteet ihmiselle luettavassa
     * muodossa.
     */
    public void listaaViitteet() {
        List<Artikkeli> artikkelit = viitearkisto.getArtikkelit();
        for (int i = 0; i < artikkelit.size(); i++) {
            Artikkeli artikkeli = artikkelit.get(i);
            io.tulostaRivi("ID: " + artikkeli.getID());
            io.tulostaRivi("Author: " + artikkeli.getAuthor());
            io.tulostaRivi("Title: " + artikkeli.getTitle());
            io.tulostaRivi("Journal: " + artikkeli.getJournal());
            io.tulostaRivi("Volume: " + artikkeli.getVolume());
            io.tulostaRivi("Number: " + artikkeli.getNumber());
            io.tulostaRivi("Year: " + artikkeli.getYear());
            io.tulostaRivi("Pages: " + artikkeli.getPages());
            io.tulostaRivi("Publisher: " + artikkeli.getPublisher());
            io.tulostaRivi("Address: " + artikkeli.getAddress());
            io.tulostaRivi("");
            io.tulostaRivi("====================================");
            io.tulostaRivi("");
        }

        io.tulostaRivi("Viitteitä yhteensä: " + artikkelit.size());
        io.tulostaRivi("");

    }

    /**
     * Muuttaa Stringinä olevan numeron kokonaisluvuksi.
     *
     * @param numeraali Stringinä saatava numero
     * @return int:iksi muutetun kokonaisluvun.
     */
    private int StringLuvuksi(String numeraali) {
        return Integer.parseInt(numeraali);
    }

    /**
     * Lukee tiedoston ohjelman muistiin, eli ohjelman käyttämään listaam.
     */
    private void lueTiedosto() {
        viitearkisto.lueTiedosto();
    }

    /**
     * Tallentaa ohjelman listassa olevat viitteet tiedostoon.
     */
    private void tallennaTiedostoon() {
        viitearkisto.tallenna();
    }

}
