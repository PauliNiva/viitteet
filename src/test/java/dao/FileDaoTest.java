package dao;

import java.lang.reflect.*;
import io.KayttoliittymaIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

import viitehallinta.Artikkeli;
import viitehallinta.Viite;

/**
 * JUnit-testit Daon testaamiseen.
 */
public class FileDaoTest {

    FileDao fileDao;
    List<Viite> viitteet;
    KayttoliittymaIO io;

    @Before
    public void setUp() {
        io = new KayttoliittymaIO();
        fileDao = new FileDao("testiviite.txt", io);
        viitteet = new ArrayList<Viite>();
    }

    @Test
    public void luoOlioIlmanTiedostonimiParamteria() {
        io = new KayttoliittymaIO();
        fileDao = new FileDao(io);
        
        Class fileDaoLuokka = FileDao.class;
        try {
            Field ioKentta = fileDaoLuokka.getDeclaredField("io");
            ioKentta.setAccessible(true);
            assertNotNull(ioKentta);
        } catch (Exception e){
            System.out.println(e.toString());
        }   
    }
    
    @Test
    public void kirjoitaArtikkelitTest() throws Exception {
        Artikkeli artikkeli = new Artikkeli("author", "title", "journal", 1, 1999);
        viitteet.add(artikkeli);
        fileDao.tallennaViitteet(viitteet);
        assertEquals(viitteet.size(), fileDao.lueViitteetTiedostosta().size());
    }

    @Test
    public void lueArtikkelitTest() {
        Artikkeli artikkeli = new Artikkeli("author", "title", "journal", 1, 1999);
        Artikkeli artikkeli2 = new Artikkeli("author2", "title2", "journal2", 2, 2999);
        viitteet.add(artikkeli);
        viitteet.add(artikkeli2);
        fileDao.tallennaViitteet(viitteet);
        List<Viite> luetutViitteet = fileDao.lueViitteetTiedostosta();

        assertEquals(luetutViitteet.get(1).getAuthor(), "author2");
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
        Artikkeli artikkeli = new Artikkeli("author", "title", "journal", 2, 1999);
        Artikkeli artikkeli2 = new Artikkeli("author2", "title2", "journal2", 2, 2999);
        viitteet.add(artikkeli);
        viitteet.add(artikkeli2);
        fileDao.tyhjennaTiedosto();
        //assertEquals(fileDao.tallennaViitteet().size(), 0);
    }
}
