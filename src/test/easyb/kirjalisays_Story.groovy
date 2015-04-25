import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi lisätä kirjaviitteen'

scenario 'käyttäjä voi lisätä kirjaviitteen', {
    given 'kirjanlisäämis-toiminto on valittu', {
        io = new StubIO("1", "2", "lokki", "lintu", "2015", "9", "notes", "Pubi", "address", "10", "7", "3", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'kaikki kentät on täytetty', {
        kl.kaynnista();
    }
    then 'kirjaviite on tallennettu' , {
        viitearkisto.getViitteet().size().shouldNotBe 0;
        testiDao.tyhjennaTiedosto();
    }
}

scenario 'käyttäjä voi lisätä kirjaviitteen', {
    given 'kirjanlisäämis-toiminto on valittu', {
        io = new StubIO("1", "2", "lokki", "lintu", "2015", "", "", "Pubi", "", "", "", "", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'vain pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'kirjaviite on tallennettu' , {
        viitearkisto.getViitteet().size().shouldNotBe 0;
        testiDao.tyhjennaTiedosto();
    }
}
