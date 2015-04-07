/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import viitehallinta.Viite;

/**
 *
 * @author Sonja
 */
public interface dao {
    void lisaaViite(Viite viite);
    List <Viite> listaaViitteet();
    boolean poistaViite(Viite viite);
}
