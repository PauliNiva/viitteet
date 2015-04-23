import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi luoda BibTex-tiedoston'

scenario 'käyttäjä voi luoda BibTex-tiedoston artikkeli-viitteestä', {
    given 'bibtex-toiminto on valittu', {
        io = new StubIO("1", "1", "lokki", "lintu", "9", "9", "9", "2015", "9", "9", "katu", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'bibtex-tiedosto on tallennettu' , {
        io.getPrints().shouldHave("Viitteet lisatty bibViitteet.bib tiedostoon");
        io.getPrints().shouldHave("Artikkeli lisatty onnistuneesti");
        io.getPrints().shouldNotHave("Kirja lisatty onnistuneesti");
        testiDao.tyhjennaTiedosto();
    }
}
scenario 'käyttäjä voi luoda BibTex-tiedoston kirja-viitteestä', {
    given 'bibtex-toiminto on valittu', {
        io = new StubIO("1", "2", "lokki", "lintu", "2015", "9", "katu", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'bibtex-tiedosto on tallennettu' , {
        io.getPrints().shouldHave("Viitteet lisatty bibViitteet.bib tiedostoon");
        io.getPrints().shouldHave("Kirja lisatty onnistuneesti");
        io.getPrints().shouldNotHave("Artikkeli lisatty onnistuneesti");
        testiDao.tyhjennaTiedosto();
    }
}
