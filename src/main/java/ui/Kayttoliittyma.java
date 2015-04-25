package ui;

import io.Bibtex;
import io.IO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import viitehallinta.*;

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
        try {
            lueTiedosto();
            do {
                naytaValikkoJaPyydaValinta();
            } while (toteutaValikonValinta(getKayttajanValinta()));
        } catch (IOException ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Näyttää valikon konsolissa.
     */
    @Override
    public void naytaValikkoJaPyydaValinta() {
        io.tulostaRivi("Valitse toiminto: ");
        io.tulostaRivi("(1) Luo viite");
        io.tulostaRivi("(2) Listaa viitteet");
        io.tulostaRivi("(3) Poista Viite");
        io.tulostaRivi("(4) Luo BibTex-tiedosto");
        io.tulostaRivi("(5) Etsi viite");
        io.tulostaRivi("(0) Lopeta");
    }

    /**
     * Hakee käyttäjän valinnan valikosta.
     *
     * @return käyttäjän valinnan.
     */
    private int getKayttajanValinta() {
        String valintaMkiJono = io.lueRivi();

        int valinta;
        try {
            valinta = Integer.parseInt(valintaMkiJono);
        } catch (NumberFormatException e) {
            valinta = -1;
        }

        return valinta;
    }

    /**
     * Toteuttaa käyttäjän tekemän päävalikon valinnan.
     *
     * @param kayttajanValinta Kokonaisluku joka ilmaisee käyttäjän valikosta
     * valitseman toiminnon.
     * @return True jos käyttäjä valitsee minkä tahansa muun kuin lopettamisen,
     * tällöin viitteet tallennetaan tiedostoon ja palautetaan false.
     * @throws IOException
     */
    public boolean toteutaValikonValinta(int kayttajanValinta) throws IOException {
        switch (kayttajanValinta) {
            case 1: {
                naytaViiteValikko();
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
                luoBibtex();
                break;
            }
            case 5: {
                naytaEtsiViite();
                break;
            }
            case 0: {
                tallennaTiedostoon();
                return false;
            }
        }
        return true;
    }

    /**
     * Toteuttaa käyttäjän valinnan viitteiden lisäys valikossa.
     *
     * @param kayttajanValinta kokonaisluku, joka ilmaisee käyttäjän valikosta
     * valitseman toiminnon.
     * @return True, jos käyttäjä valitsee muun kuin palaamisen päävalikkoon.
     * @throws IOException
     */
    private boolean toteutaViitevalikonValinta(int kayttajanValinta) throws IOException {
        switch (kayttajanValinta) {
            case 1: {
                luoArtikkeli();
                break;
            }
            case 2: {
                luoKirja();
                break;
            }
            case 3: {
                luoInproceedings();
                break;
            }
            case 4: {
                luoMisc();
                break;
            }
            case 0: {
                return false;
            }
        }
        return true;
    }

    /**
     * Näyttää konsolissa valikon viitteiden lisäämiselle ja lopuksi kutsuu
     * metodia, joka toteuttaa halutun toiminnon.
     *
     * @throws IOException
     */
    private void naytaViiteValikko() throws IOException {
        boolean valintaJatkuu = false;
        do {
            io.tulostaRivi("Valitse viitetyypi: ");
            io.tulostaRivi("(1) Luo artikkeli-viite");
            io.tulostaRivi("(2) Luo kirja-viite");
            io.tulostaRivi("(3) Luo inproceedings-viite");
            io.tulostaRivi("(4) Luo misc-viite");
            io.tulostaRivi("(0) Palaa päävalikkoon");
            valintaJatkuu = toteutaViitevalikonValinta(getKayttajanValinta());
        } while (valintaJatkuu == true);
    }

    /**
     * Lisää artikkelin järjestelmään viitearkisto-luokan lisaaArtikkeli
     * metodilla. Tulostaa lopuksi käyttäjälle viestin lisäyksen onnistumisesta.
     */
    public void luoArtikkeli() {
        String[] kentat = taytaKentat(Artikkeli.haeKentat());
        viitearkisto.lisaaArtikkeli(kentat[0], kentat[1], kentat[6], merkkijonoNumeroksi(kentat[7]),
                merkkijonoNumeroksi(kentat[8]), merkkijonoNumeroksi(kentat[2]), kentat[5],
                merkkijonoNumeroksi(kentat[3]), kentat[4]);
        io.tulostaRivi("");
        io.tulostaRivi("Artikkeli lisatty onnistuneesti");
        io.tulostaRivi("");
    }

    /**
     * Lisää kirjan järjestelmään viitearkisto-luokan lisaaKirja metodilla.
     * Tulostaa lopuksi käyttäjälle viestin lisäyksen onnistumisesta.
     */
    public void luoKirja() {
        String[] kentat = taytaKentat(Kirja.haeKentat());
        viitearkisto.lisaaKirja(kentat[0], kentat[1], merkkijonoNumeroksi(kentat[2]),
                kentat[5], kentat[6], merkkijonoNumeroksi(kentat[7]), kentat[8],
                kentat[9], merkkijonoNumeroksi(kentat[3]), kentat[4]);
        io.tulostaRivi("");
        io.tulostaRivi("Kirja lisatty onnistuneesti");
        io.tulostaRivi("");
    }

    /**
     * Lisää inproceedingsin järjestelmään viitearkisto-luokan lisaaKirja
     * metodilla. Tulostaa lopuksi käyttäjälle viestin lisäyksen onnistumisesta.
     */
    public void luoInproceedings() {
        String[] kentat = taytaKentat(Inproceedings.haeKentat());
        viitearkisto.lisaaInproceedings(kentat[0], kentat[1], kentat[7],
                merkkijonoNumeroksi(kentat[2]), kentat[10], kentat[5], kentat[6],
                merkkijonoNumeroksi(kentat[8]), kentat[9], kentat[11], kentat[12],
                merkkijonoNumeroksi(kentat[3]), kentat[4]);
        io.tulostaRivi("");
        io.tulostaRivi("Inproceedings lisatty onnistuneesti");
        io.tulostaRivi("");
    }

    /**
     * Lisää misc:in järjestelmään viitearkisto-luokan lisaaKirja metodilla.
     * Tulostaa lopuksi käyttäjälle viestin lisäyksen onnistumisesta.
     */
    public void luoMisc() {
        String[] kentat = taytaKentat(Inproceedings.haeKentat());
        viitearkisto.lisaaMisc(kentat[0], kentat[1], kentat[5],
                merkkijonoNumeroksi(kentat[3]), merkkijonoNumeroksi(kentat[2]), kentat[4]);
        io.tulostaRivi("");
        io.tulostaRivi("Misc lisatty onnistuneesti");
        io.tulostaRivi("");
    }

    /**
     * Antaa kentät käyttäjän täytettäviksi riveittäin kenttä kerrallaan.
     *
     * @param kentat String-taulukko, jossa on kenttien nimet, jotka kenttä
     * kerrallaan annetaan käyttäjän täytettäväksi.
     * @return String-taulukko, jossa on kentät täytettynä.
     */
    public String[] taytaKentat(List<Kentta> kentat) {
        String[] taytettavatKentat = new String[kentat.size()];

        for (int i = 0; i < kentat.size(); i++) {
            Kentta kentta = kentat.get(i);

            StringBuilder kehote = new StringBuilder(kentta.getNimi());
            if (kentta.pakollinen() == true) {
                kehote.append("*");
            }
            kehote.append((": "));

            boolean syoteOk = true;
            do {
                io.tulostaIlmanRivinvaihtoa(kehote.toString());
                taytettavatKentat[i] = io.lueRivi();

                if (kentta.pakollinen() == true && taytettavatKentat[i].isEmpty()) {
                    syoteOk = false;
                } else {
                    syoteOk = true;
                }
            } while (syoteOk == false);
        }

        return taytettavatKentat;
    }

    /**
     * Poístaa viitteen järjestelmästä kysymälle ensin käyttäjältä ID:tä, jonka
     * avulla poistettava viite tunnistetaan ja lopuksi pyytää
     * viitearkisto-luokan metodia poistaViite poistamaan kyseisen viitteen.
     */
    @Override
    public void poistaViite() {
        System.out.println("Anna poistettavan viitteen ID: ");
        String poistettavaViite = io.lueRivi();
        viitearkisto.poistaViite(poistettavaViite);
    }

    /**
     * Etsii viitteen järjestelmästä kysymällä ensin käyttäjältä hakusanaa,
     * jonka avulla etsittävä viite tunnistetaan. Luo viite-listan, johon talletetaan
     * viitearkisto-luokalta etsittävät viitteet. Lopuksi kutsutaan naytaOsumat-
     * metodia, joka näyttää hakutuloksen.
     */
    private void naytaEtsiViite() {
        System.out.println("Anna hakusana:");
        String hakusana = io.lueRivi();
        List<Viite> osumat = viitearkisto.etsiViite(hakusana);
        naytaOsumat(osumat);
    }

    /**
     * Näyttää etsintä-toiminnolla haetut viitteet
     * @param osumat lista osumista, jotka näytetään
     */
    // TODO !!!!!
    private void naytaOsumat(List<Viite> osumat) {
        if (osumat.isEmpty()) {
            System.out.println("Hakusanallasi ei löytynyt yhtään viitettä");
        } else {
            
        }
    }

    /**
     * Listaa järjestelmässä olevat viitteet ihmiselle luettavassa muodossa.
     */
    public void listaaViitteet() {
        System.out.println("Viitteet: \n");
        List<Viite> viitteet = viitearkisto.getViitteet();
        for (Object viite : viitteet) {
            if (viite instanceof Artikkeli) {
                io.tulostaRivi("ID: " + ((Artikkeli) viite).getID());
                io.tulostaRivi("Author: " + ((Artikkeli) viite).getAuthor());
                io.tulostaRivi("Title: " + ((Artikkeli) viite).getTitle());
                io.tulostaRivi("Journal: " + ((Artikkeli) viite).getJournal());
                io.tulostaRivi("Volume: " + ((Artikkeli) viite).getVolume());
                io.tulostaRivi("Number: " + ((Artikkeli) viite).getNumber());
                io.tulostaRivi("Year: " + ((Artikkeli) viite).getYear());
                io.tulostaRivi("Pages: " + ((Artikkeli) viite).getPages());
                io.tulostaRivi("Month: " + ((Artikkeli) viite).getMonth());
                io.tulostaRivi("Note: " + ((Artikkeli) viite).getNote());
                io.tulostaRivi("");
                io.tulostaRivi("====================================");
                io.tulostaRivi("");
            } else if (viite instanceof Kirja) {
                io.tulostaRivi("ID: " + ((Kirja) viite).getID());
                io.tulostaRivi("Author: " + ((Kirja) viite).getAuthor());
                io.tulostaRivi("Title: " + ((Kirja) viite).getTitle());
                io.tulostaRivi("Year: " + ((Kirja) viite).getYear());
                io.tulostaRivi("Publisher: " + ((Kirja) viite).getPublisher());
                io.tulostaRivi("Address: " + ((Kirja) viite).getAddress());
                io.tulostaRivi("Volume: " + ((Kirja) viite).getVolume());
                io.tulostaRivi("Series: " + ((Kirja) viite).getSeries());
                io.tulostaRivi("Edition: " + ((Kirja) viite).getEdition());
                io.tulostaRivi("Month: " + ((Kirja) viite).getMonth());
                io.tulostaRivi("Note: " + ((Kirja) viite).getNote());
                io.tulostaRivi("");
                io.tulostaRivi("====================================");
                io.tulostaRivi("");
            } else if (viite instanceof Inproceedings) {
                io.tulostaRivi("ID: " + ((Inproceedings) viite).getID());
                io.tulostaRivi("Author: " + ((Inproceedings) viite).getAuthor());
                io.tulostaRivi("Title: " + ((Inproceedings) viite).getTitle());
                io.tulostaRivi("Booktitle: " + ((Inproceedings) viite).getBooktitle());
                io.tulostaRivi("Year: " + ((Inproceedings) viite).getYear());
                io.tulostaRivi("Pages: " + ((Inproceedings) viite).getPages());
                io.tulostaRivi("Publisher: " + ((Inproceedings) viite).getPublisher());
                io.tulostaRivi("Editor: " + ((Inproceedings) viite).getEditor());
                io.tulostaRivi("Volume: " + ((Inproceedings) viite).getVolume());
                io.tulostaRivi("Series: " + ((Inproceedings) viite).getSeries());
                io.tulostaRivi("Pages: " + ((Inproceedings) viite).getPages());
                io.tulostaRivi("Address: " + ((Inproceedings) viite).getAddress());
                io.tulostaRivi("Organization: " + ((Inproceedings) viite).getOrganization());
                io.tulostaRivi("Month: " + ((Inproceedings) viite).getMonth());
                io.tulostaRivi("Note: " + ((Inproceedings) viite).getNote());
                io.tulostaRivi("");
                io.tulostaRivi("====================================");
                io.tulostaRivi("");
            } else if (viite instanceof Misc) {
                io.tulostaRivi("ID: " + ((Misc) viite).getID());
                io.tulostaRivi("Author: " + ((Misc) viite).getAuthor());
                io.tulostaRivi("Title: " + ((Misc) viite).getTitle());
                io.tulostaRivi("How Published: " + ((Misc) viite).getHowPublished());
                io.tulostaRivi("Month: " + ((Misc) viite).getMonth());
                io.tulostaRivi("Year: " + ((Misc) viite).getYear());
                io.tulostaRivi("Note: " + ((Misc) viite).getNote());
                io.tulostaRivi("");
                io.tulostaRivi("====================================");
                io.tulostaRivi("");
            }
        }
        io.tulostaRivi("Viitteitä yhteensä: " + viitteet.size());
        io.tulostaRivi("");
    }

    /**
     * Muuttaa merkkijonona olevan numeron kokonaisluvuksi. Jos merkkijono ei
     * ole numero, niin metodia antaa arvoksi -1.
     *
     * @param numeraali Stringinä saatava numero
     * @return int:iksi muutetun kokonaisluvun.
     */
    private int merkkijonoNumeroksi(String numeraali) {
        int arvo;
        try {
            arvo = Integer.parseInt(numeraali);
        } catch (NumberFormatException e) {
            arvo = -1;
        }
        return arvo;
    }

    /**
     * Lukee tiedoston ohjelman muistiin, eli ohjelman käyttämän viitelistan.
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

    /**
     * Luo bibtex-muotoisen tiedoston.
     *
     * @throws IOException
     */
    private void luoBibtex() throws IOException {
        Bibtex bibtex = new Bibtex(viitearkisto, io, "bibViitteet.bib");
        bibtex.luoTiedosto();
    }

}
