import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi poistaa viitteen'

scenario 'käyttäjä voi poistaa viitteen', {
    given 'poista-toiminto on valittu', {
        io = new StubIO("1", "1", "9", "lokki", "lintu", "9", "9", "9", "2015", "9", "9", "katu", "3", "3", "9", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'viite on poistettu' , {
        viitearkisto.getViitteet().size().shouldBe 0;
        testiDao.tyhjennaTiedosto();
    }

}
