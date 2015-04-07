/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.util.List;
import viitehallinta.Viite;

/**
 *
 * @author Sonja
 */
public interface IOtallennus {
    boolean kirjoita(List<Viite> viitteet);
    List <Viite> lue();
}
