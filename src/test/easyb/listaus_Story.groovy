import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi listata artikkelit'

scenario 'käyttäjä voi listata artikkelit', {
    given 'lisäämis-toiminto on valittu', {
        io = new StubIO("2", "4");
        testiDao = new FileDao("tyhjatestiviite.txt", io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'artikkeli on lisätty järjestelmään ja listaus-toiminto on valittu', {
        kl.kaynnista();
    }
    then 'artikkelin tiedot tulostuvat' , {
        io.getPrints().shouldHave("Author: lokki")
        testiDao.tyhjennaTiedosto();
    }

    
}