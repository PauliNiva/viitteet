import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi lisätä kirjaviitteen'

scenario 'käyttäjä voi lisätä kirjaviitteen', {
    given 'kirjanlisäämis-toiminto on valittu', {
        io = new StubIO("1", "2", "9", "lokki", "lintu", "2015", "9", "katu", "5", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'kirjaviite on tallennettu' , {
        viitearkisto.getViitteet().size().shouldNotBe 0;
        testiDao.tyhjennaTiedosto();
    }

}
