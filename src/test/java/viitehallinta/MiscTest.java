
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
    public void luoKonstruktori() {
    //ublic Misc(String ID, String author, String title, String howpublished, int month, int year, String note) {
    
    }
}
