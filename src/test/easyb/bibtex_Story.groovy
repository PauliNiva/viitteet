import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi luoda BibTex-tiedoston'

scenario 'käyttäjä voi luoda BibTex-tiedoston artikkeli-viitteestä', {
    given 'bibtex-toiminto on valittu', {
        io = new StubIO("1", "1", "9", "lokki", "lintu", "9", "9", "9", "2015", "9", "9", "katu", "3", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'bibtex-tiedosto on tallennettu' , {
        io.getPrints().shouldHave("Viitteet lisätty bibViitteet.bib tiedostoon");
        io.getPrints().shouldHave("Artikkeli lisätty onnistuneesti");
        io.getPrints().shouldNotHave("Kirja lisätty onnistuneesti");
        testiDao.tyhjennaTiedosto();
    }
}
scenario 'käyttäjä voi luoda BibTex-tiedoston kirja-viitteestä', {
    given 'bibtex-toiminto on valittu', {
        io = new StubIO("1", "2", "9", "lokki", "lintu", "2015", "9", "katu", "3", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'bibtex-tiedosto on tallennettu' , {
        io.getPrints().shouldHave("Viitteet lisätty bibViitteet.bib tiedostoon");
        io.getPrints().shouldHave("Kirja lisätty onnistuneesti");
        io.getPrints().shouldNotHave("Artikkeli lisätty onnistuneesti");
        testiDao.tyhjennaTiedosto();
    }
}
