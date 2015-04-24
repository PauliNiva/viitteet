package viitehallinta;

import java.lang.reflect.*;
import dao.FileDao;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Luokka viitearkiston testaamiseen.
 */
public class ViitearkistoTest {

    Viitearkisto viitearkisto;
    FileDao mockDao;

    @Before
    public void setUp() {
        mockDao = mock(FileDao.class);
        viitearkisto = new Viitearkisto(mockDao);
    }

    @Test
    public void lisaaArtikkeliTest() {
        viitearkisto.lisaaArtikkeli("author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
        verify(mockDao, times(1)).tallennaViitteet(anyList());
        assertEquals(1, viitearkisto.getViitteet().size());
    }

    @Test
    public void tallennaTest() {
        viitearkisto.tallenna();
        verify(mockDao, times(1)).tallennaViitteet(anyList());
    }

    @Test
    public void lueTiedostoTest() {
        viitearkisto.lueTiedosto();
        verify(mockDao, times(1)).lueViitteetTiedostosta();
    }

    @Test
    public void getArtikkelitTest() {
        assertEquals(0, viitearkisto.getViitteet().size());
        viitearkisto.lisaaArtikkeli("author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
        assertEquals(1, viitearkisto.getViitteet().size());
    }

    @Test
    public void luoOletusViitearkistoOlioTest() {
        viitearkisto = new Viitearkisto();
        
        // Luokan luonti luo ja sijoittaa arvon kahteen private muuttujaan
        // joten tämän testi tarkistaa reflection:n avulla että k.o. muuttujat
        // todella saavat jotkin arvot
        Class viiterarkistoLuokka = Viitearkisto.class;
        
        // getDeclaredField voit heittää poikkeuksen jos k.o. kenttää ei ole olemassa
        try {
            // Hae viite private kenttään ja tarkista että luodussa oliossa sen arvo
            // ei ole null
            Field fileDaoKentta = viiterarkistoLuokka.getDeclaredField("fileDao");
            // Kenttään ei voi tehdä toimintoja ennen kuin sen on merkitty 'käytettäväksi'
            // sillä muuten tulee IllegalAccessException
            fileDaoKentta.setAccessible(true);
            assertNotNull(fileDaoKentta.get(viitearkisto));
            
            Field viitteetKentta = viiterarkistoLuokka.getDeclaredField("viitteet");
            viitteetKentta.setAccessible(true);
            assertNotNull(viitteetKentta.get(viitearkisto));
        }catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
    @Test
    public void lisaaKirjaTest() {
        viitearkisto.lisaaKirja("Charles M. Schulz", "Charlie Brown", 1950, "Simon & Schuster", "S street 1");
        verify(mockDao, times(1)).tallennaViitteet(anyList());
        assertEquals(1, viitearkisto.getViitteet().size());
    }

    @Test
    public void poistaViiteTest() {
        viitearkisto.lisaaKirja("Charles M. Schulz", "Charlie Brown", 1950, "Simon & Schuster", "S street 1");
        viitearkisto.lisaaKirja("Charles M. Schulz", "Charlie Brown strikes back", 1951, "Simon & Schuster", "S street 1");
        assertEquals(2, viitearkisto.getViitteet().size());
        
        viitearkisto.poistaViite("Charles1951Charlie Brown strikes back");
        assertEquals(1, viitearkisto.getViitteet().size());
    }
    
    @Test
    public void lisaaMiscTest() {
        viitearkisto.lisaaMisc("Luoja", "Arska", "www.koe.fi", 2, 2013, "luettu 2.1");
        verify(mockDao, times(1)).tallennaViitteet(anyList());
        assertEquals(1, viitearkisto.getViitteet().size());
    }
}
