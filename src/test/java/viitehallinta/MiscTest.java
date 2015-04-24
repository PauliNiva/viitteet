
package viitehallinta;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiscTest {
    Misc misc;
    public MiscTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void luoTyhjanKonstruktori() {
       misc = new Misc();
       assertEquals(null, misc.getID());
    }
    
    @Test
    public void luoKonstruktorin() {
        misc = new Misc();
        misc.setAuthor("Make");
        misc.setTitle("Keke");
        misc.setHowPublished("http://koe.fi");
        misc.setMonth(8);
        misc.setYear(2014);
        misc.setNote("");
        misc.luoID();
        assertEquals("Make2014Keke", misc.getID());
        assertEquals("Make", misc.getAuthor());
        assertEquals("Keke", misc.getTitle());
        assertEquals("http://koe.fi", misc.getHowPublished());
        assertEquals(8, misc.getMonth());
        assertEquals(2014, misc.getYear());
        assertEquals("", misc.getNote());  
    }
    
    @Test
    public void setAndTestHowPublishedTest() {
        misc = new Misc();
        misc.setHowPublished("Kirja");
        assertEquals(misc.getHowPublished(), "Kirja");
    }
    
    @Test
    public void setAndGetMonthTest() {
        misc = new Misc();
        misc.setMonth(3);
        assertEquals(misc.getMonth(), 3);
    }
    
    @Test
    public void setAndGetNoteTest() {
        misc = new Misc();
        misc.setNote("Luettu joskus");
        assertEquals(misc.getNote(), "Luettu joskus");
    }
}
