import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi listata artikkelit'

scenario 'käyttäjä voi listata artikkelit', {
    given 'lisäämis-toiminto on valittu', {
        testiDao = new FileDao("tyhjätestiviite.txt");
        io = new StubIO("1", "9", "lokki", "lintu", "9", "9", "9", "2015", "9", "9", "katu", "4", "2");
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'artikkeli on lisätty järjestelmään ja listaus-toiminto on valittu', {
        kl.kaynnista();
    }
    then 'artikkelin tiedot tulostuvat' , {
        io.getPrints().shouldHave("Author: lokki")
    }
    testiDao.tyhjennaTiedosto();
    
}