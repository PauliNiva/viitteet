
package dao;

import io.KayttoliittymaIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import viitehallinta.Viite;


public class BibDaoTest {
    
    BibDao bibDao;
    List<Viite> viitteet;
    KayttoliittymaIO io;
     
    
    @Before
    public void setUp() {
        io = new KayttoliittymaIO();
        bibDao = new BibDao("testibib.bib", io);
        viitteet = new ArrayList<Viite>();
    }
    
   
   @Test
   public void tyhjennaTiedostoTest() throws IOException{
       bibDao.lisaaRiviTiedostoon("poistettava rivi");
       bibDao.tyhjennaTiedosto();
       
   }
   
   @Test
   public void lisaaRiviTiedostoonTest() throws IOException {
       bibDao.lisaaRiviTiedostoon("lisättävä rivi");
   }
   

   
}

