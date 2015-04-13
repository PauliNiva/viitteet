package viitehallinta;

import dao.FileDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
        viitearkisto.lisaaArtikkeli("1", "author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
        verify(mockDao, times(1)).kirjoitaArtikkelit(anyList());
        assertEquals(1, viitearkisto.getArtikkelit().size());
    }

    @Test
    public void tallennaTest() {
        viitearkisto.tallenna();
        verify(mockDao, times(1)).kirjoitaArtikkelit(anyList());
    }

    @Test
    public void lueTiedostoTest() {
        viitearkisto.lueTiedosto();
        verify(mockDao, times(1)).lueArtikkelit();
    }

    @Test
    public void getArtikkelitTest() {
        assertEquals(0, viitearkisto.getArtikkelit().size());
        viitearkisto.lisaaArtikkeli("1", "author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
        assertEquals(1, viitearkisto.getArtikkelit().size());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
