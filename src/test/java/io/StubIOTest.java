/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tijas
 */
public class StubIOTest {
    StubIO stubi;
    
    public StubIOTest() {
        stubi = new StubIO("1");
    }
    
    @Test
    public void getPrintsTest(){
        ArrayList<String> tulosteet = stubi.getPrints();
        assertEquals(0, tulosteet.size());
        stubi.tulostaRivi("testisyöte");
        tulosteet = stubi.getPrints();
        assertEquals(true, tulosteet.contains("testisyöte"));
    }
    
   @Test
   public void lueRiviTest(){
       String syote = stubi.lueRivi();
       assertEquals("1", syote);
       assertEquals("", stubi.lueRivi());
   }
   
   @Test
   public void tulostaIlmanRivinVaihtoaTest(){
       stubi.tulostaIlmanRivinvaihtoa("testisyöte");
       assertEquals(1, stubi.getPrints().size());
   }
   
   @Test
   public void tulostaRiviTest(){
       stubi.tulostaRivi("testisyöte");
       assertEquals(1, stubi.getPrints().size());
   }

    
}
