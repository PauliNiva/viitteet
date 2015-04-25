import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi lisätä artikkeliviitteen'

scenario 'käyttäjä voi lisätä viitteen', {
    given 'lisäämis-toiminto on valittu', {
        io = new StubIO("1", "1", "lokki", "lintu", "2015", "9", "notes", "21--24", "Lintuset", "7", "2", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'kaikki kentät on täytetty', {
        kl.kaynnista();
    }
    then 'artikkeliviite on tallennettu' , {
        viitearkisto.getViitteet().size().shouldNotBe 0;
        testiDao.tyhjennaTiedosto();
    }
}

scenario 'käyttäjä voi lisätä viitteen', {
    given 'lisäämis-toiminto on valittu', {
        io = new StubIO("1", "1", "lokki", "lintu", "2015", "", "", "", "Lintuset", "7", "", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'vain pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'artikkeliviite on tallennettu' , {
        viitearkisto.getViitteet().size().shouldNotBe 0;
        testiDao.tyhjennaTiedosto();
    }
}
