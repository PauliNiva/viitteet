
package dao;

import io.KayttoliittymaIO;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import viitehallinta.Artikkeli;


public class FileDaoTest {

    FileDao fileDao;
    List<Artikkeli> artikkelit;
    KayttoliittymaIO io;
    
    public FileDaoTest() {
        io = new KayttoliittymaIO();
        fileDao = new FileDao("testiviite.txt", io);
        artikkelit = new ArrayList<Artikkeli>();
    }

    @Test
    public void kirjoitaArtikkelitTest() {
        Artikkeli artikkeli = new Artikkeli("1", "author", "title", "journal", 1, 2, 1999, "pages", "publisher", "address");
        artikkelit.add(artikkeli);
        fileDao.kirjoitaArtikkelit(artikkelit);
        assertEquals(artikkelit.size(), fileDao.lueArtikkelit().size());
    }

}
