
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
    public void lueArtikkelitTest() {
        Artikkeli artikkeli = new Artikkeli("1", "author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
        Artikkeli artikkeli2 = new Artikkeli("2", "author2", "title2", "journal2", 2, 2, 2999, "pages2", "publisher2", "address2");
        artikkelit.add(artikkeli);
        artikkelit.add(artikkeli2);
        fileDao.kirjoitaArtikkelit(artikkelit);
        List<Artikkeli> luetutArtikkelit = fileDao.lueArtikkelit();
        
        assertEquals(luetutArtikkelit.get(1).getAuthor(), "author2");
    }
    
    
//    TODO -- tää ei toimi
//    @Test(expected = IOException.class)
//    public void kirjoitaArtikkelitTestaaPoikkeus() {
//        File testiTiedosto = new File("testiviite.txt");
//        testiTiedosto.renameTo(new File("virheellinen.txt"));
//        Artikkeli artikkeli = new Artikkeli("1", "author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
//        artikkelit.add(artikkeli);
//        fileDao.kirjoitaArtikkelit(artikkelit);
//        
//        
//    }
    
    @Test
    public void tyhjennaTiedostoTest() throws IOException {
        Artikkeli artikkeli = new Artikkeli("1", "author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
        Artikkeli artikkeli2 = new Artikkeli("2", "author2", "title2", "journal2", 2, 2, 2999, "pages2", "publisher2", "address2");
        artikkelit.add(artikkeli);
        artikkelit.add(artikkeli2);
        fileDao.tyhjennaTiedosto();
        assertEquals(fileDao.lueArtikkelit().size(), 0);
    }
}
