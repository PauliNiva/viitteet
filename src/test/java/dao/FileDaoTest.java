
package dao;

import io.KayttoliittymaIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

import org.junit.rules.ExpectedException;
import viitehallinta.Artikkeli;


public class FileDaoTest {

    FileDao fileDao;
    List<Artikkeli> artikkelit;
    KayttoliittymaIO io;

    @Before
    public void setUp() {
        io = new KayttoliittymaIO();
        fileDao = new FileDao("testiviite.txt", io);
        artikkelit = new ArrayList<Artikkeli>();
    }

    @Test
    public void kirjoitaArtikkelitTest() throws Exception {
        Artikkeli artikkeli = new Artikkeli("1", "author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
        artikkelit.add(artikkeli);
        fileDao.kirjoitaArtikkelit(artikkelit);
        assertEquals(artikkelit.size(), fileDao.lueArtikkelit().size());
    }
    
    @Test
    public void tyhjennaTiedostoTest() throws IOException {
        Artikkeli artikkeli = new Artikkeli("1", "author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
        artikkelit.add(artikkeli);
        fileDao.tyhjennaTiedosto();
        assertEquals(fileDao.lueArtikkelit().size(), 0);
    }
}
