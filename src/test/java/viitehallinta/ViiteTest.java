package viitehallinta;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit-testit Viite-luokalle.
 */
public class ViiteTest {

    @Test
    public void setAndGetIDTest() {
        Viite viite = new Viite();
        viite.setID("g3");
        assertEquals("g3", viite.getID());
    }

    @Test
    public void setAndGetAuthor() {
        Viite viite = new Viite();
        viite.setAuthor("Arto Vihavainen");
        assertEquals("Arto Vihavainen", viite.getAuthor());
    }

    @Test
    public void setAndGetTitle() {
        Viite viite = new Viite();
        viite.setTitle("Ratebeer");
        assertEquals("Ratebeer", viite.getTitle());
    }

    @Test
    public void setAndGetYearTest() {
        Viite viite = new Viite();
        viite.setYear(2013);
        assertEquals(2013, viite.getYear());
    }

    @Test
    public void setAndGetMonthTest() {
        Viite viite = new Viite();
        viite.setMonth(12);
        assertEquals(12, viite.getMonth());
    }

    @Test
    public void setAndGetNoteTest() {
        Viite viite = new Viite();
        viite.setNote("Olutsanomat");
        assertEquals("Olutsanomat", viite.getNote());
    }

    @Test
    public void luoViiteSukuEtuValillaTest() {
        Viite viite = new Viite();
        viite.setAuthor("Vihavainen Arto");
        viite.setYear(2015);
        viite.setTitle("Teos");
        viite.luoID();

        assertEquals("Vihavainen2015Teos", viite.getID());
    }

    @Test
    public void luoViiteSukuEtuPilkullaJaValillaTest() {
        Viite viite = new Viite();
        viite.setAuthor("Vihavainen, Arto");
        viite.setYear(2015);
        viite.setTitle("Teos");
        viite.luoID();

        assertEquals("Vihavainen2015Teos", viite.getID());
    }

    @Test
    public void luoViiteSukuEtuPilkullaJaValillaJossaEkstraValiTest() {
        Viite viite = new Viite();
        viite.setAuthor("Vihavainen , Arto");
        viite.setYear(2015);
        viite.setTitle("Teos");
        viite.luoID();

        assertEquals("Vihavainen2015Teos", viite.getID());
    }

    @Test
    public void luoViiteSukuEtuPilkullaIlmanValiaTest() {
        Viite viite = new Viite();
        viite.setAuthor("Vihavainen,Arto");
        viite.setYear(2015);
        viite.setTitle("Teos,Opus");
        viite.luoID();

        assertEquals("Vihavainen2015Teos", viite.getID());
    }

    @Test
    public void luoViiteSukuEtuIlmanValiaJaPilkkuaTest() {
        Viite viite = new Viite();
        viite.setAuthor("Vihavainen");
        viite.setYear(2015);
        viite.setTitle("Teos");
        viite.luoID();

        assertEquals("Vihavainen2015Teos", viite.getID());
    }
}
