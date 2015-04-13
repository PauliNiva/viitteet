package viitehallinta;

import dao.*;
import io.*;
import ui.*;
import io.StubIO;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MainTest {
    dao dao;
    Viitearkisto viitearkisto;
    IO io;
    Kayttoliittyma kayttoliittyma;
    
    
    @Test
    public void mainTest() {
        dao = new FileDao("testiviite.txt", io);
        viitearkisto = new Viitearkisto(dao);
        io = mock(KayttoliittymaIO.class);
        kayttoliittyma = new Kayttoliittyma(io, viitearkisto);
        
        //Main.main(new String [] {"4"});
        when(io.lueRivi()).thenReturn("4");
        kayttoliittyma.kaynnista();
        
        verify(io, times(1)).lueRivi();
    }
}
