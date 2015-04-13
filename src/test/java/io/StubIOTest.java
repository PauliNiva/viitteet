
package io;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


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
       syote = stubi.lueRivi();
       assertEquals("", syote);
   }
   
   @Test
   public void tulostaIlmanRivinVaihtoaTest(){
       assertEquals(0, stubi.getPrints().size());
       stubi.tulostaIlmanRivinvaihtoa("testisyöte");
       assertEquals(1, stubi.getPrints().size());
   }
   
   @Test
   public void tulostaRiviTest(){
       assertEquals(false, stubi.getPrints().contains("testisyöte"));
       stubi.tulostaRivi("testisyöte");
       assertEquals(true, stubi.getPrints().contains("testisyöte"));
   }

    
}
