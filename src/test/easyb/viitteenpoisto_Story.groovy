import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi poistaa viitteen'

scenario 'käyttäjä voi poistaa viitteen', {
    given 'poista-toiminto on valittu', {
        io = new StubIO("1", "1", "lokki", "lintu", "2015", "9", "notes", "21--24", "Lintuset", "7", "2", "0", "3", "lokki2015lintu", "0");
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
