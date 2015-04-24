import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi lisätä misc-viitteen'

scenario 'käyttäjä voi lisätä misc-viitteen', {
    given 'miscin lisäämis-toiminto on valittu', {
        io = new StubIO("1","4","Nauris", "Vihannes", "http://www.vihannes.com", "2", "2013", "", "5", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'misc-viite on tallennettu' , {
        viitearkisto.getViitteet().size().shouldNotBe 0;
        io.getPrints().shouldHave("Misc lisatty onnistuneesti")
        io.getPrints().shouldNotHave("Artikkeli lisatty onnistuneesti")
        testiDao.tyhjennaTiedosto();
    }

}