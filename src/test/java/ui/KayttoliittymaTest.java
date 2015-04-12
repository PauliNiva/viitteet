package ui;

import dao.FileDao;
import io.IO;
import io.KayttoliittymaIO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import viitehallinta.Viitearkisto;
import static org.mockito.Mockito.*;

public class KayttoliittymaTest {
    
    IO mockIo;
    FileDao testiDao;
    Viitearkisto mockViitearkisto;
    Kayttoliittyma kayttoliittyma;
    
    @Before
    public void setUp(){
        mockIo = mock(KayttoliittymaIO.class);
        testiDao = new FileDao("testiviite.txt");
        mockViitearkisto = mock(Viitearkisto.class);
        kayttoliittyma = new Kayttoliittyma(mockIo, mockViitearkisto);
        
    }
    
    @Test
    public void kaynnistaTest(){
        when(mockIo.lueRivi()).thenReturn("4");
        kayttoliittyma.kaynnista();
        
        verify(mockViitearkisto, times(1)).lueTiedosto();
       
    }
    
}
