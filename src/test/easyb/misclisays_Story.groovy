import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi lisätä misc-viitteen'

scenario 'käyttäjä voi lisätä misc-viitteen', {
    given 'miscin lisäämis-toiminto on valittu', {
        io = new StubIO("1","4","Nauris", "Vihannes", "2013", "2", "", "http://www.vihannes.com", "0", "0");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'kaikki kentät on täytetty', {
        kl.kaynnista();
    }
    then 'misc-viite on tallennettu' , {
        viitearkisto.getViitteet().size().shouldNotBe 0;
        io.getPrints().shouldHave("Misc lisätty onnistuneesti")
        io.getPrints().shouldNotHave("Artikkeli lisätty onnistuneesti")
        testiDao.tyhjennaTiedosto();
    }
}

scenario 'käyttäjä voi lisätä misc-viitteen', {
    given 'miscin lisäämis-toiminto on valittu', {
        io = new StubIO("1", "4", "Nauris", "Vihannes", "2013", "", "", "", "0", "0");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'vain pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'misc-viite on tallennettu' , {
        viitearkisto.getViitteet().size().shouldNotBe 0;
        io.getPrints().shouldHave("Misc lisätty onnistuneesti")
        io.getPrints().shouldNotHave("Artikkeli lisätty onnistuneesti")
        testiDao.tyhjennaTiedosto();
    }
}