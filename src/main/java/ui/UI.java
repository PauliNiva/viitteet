package ui;

import java.util.List;
import viitehallinta.Artikkeli;
import viitehallinta.Viite;

public interface UI {
    String naytaValikkoJaPyydaValinta();
    Artikkeli lisaaArtikkeli();
    void listaaViitteet(List <Viite> viitteet);
    int poistaViite();
    void naytaViesti(String viesti);
}
