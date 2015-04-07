/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.List;
import viitehallinta.Artikkeli;
import viitehallinta.Viite;

/**
 *
 * @author Sonja
 */
public interface UI {
    String naytaValikkoJaPyydaValinta();
    Artikkeli lisaaArtikkeli();
    void listaaViitteet(List <Viite> viitteet);
    int poistaViite();
    void naytaViesti(String viesti);
}
