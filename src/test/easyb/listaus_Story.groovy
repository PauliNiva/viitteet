import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi listata artikkelit'

scenario 'käyttäjä voi listata artikkelit', {
    given 'lisäämis-toiminto on valittu', {
        io = new StubIO("1", "1", "lokki", "lintu", "2015", "9", "notes", "21--24", "Lintuset", "7", "2", "5", "2", "5");
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