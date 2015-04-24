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
scenario 'käyttäjä voi luoda BibTex-tiedoston misc-viitteestä', {
    given 'bibtex-toiminto on valittu', {
        io = new StubIO("1","4","Nauris", "Vihannes", "http://www.vihannes.com", "2", "2013", "luettu 3.6.2014", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'bibtex-tiedosto on tallennettu' , {
        io.getPrints().shouldHave("Viitteet lisatty bibViitteet.bib tiedostoon");
        io.getPrints().shouldHave("Misc lisatty onnistuneesti");
        io.getPrints().shouldNotHave("Artikkeli lisatty onnistuneesti");
        testiDao.tyhjennaTiedosto();
    }
}
scenario 'käyttäjä voi luoda BibTex-tiedoston inproceedins-viitteestä', {
    given 'bibtex-toiminto on valittu', {
        io = new StubIO("1","3","Majuri", "Asento", "http://www.olenhauska.fi", "1", "1999", "luettu 1.1.01", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'bibtex-tiedosto on tallennettu' , {
        io.getPrints().shouldHave("Viitteet lisatty bibViitteet.bib tiedostoon");
        io.getPrints().shouldHave("Inproceedings lisatty onnistuneesti");
        io.getPrints().shouldNotHave("Artikkeli lisatty onnistuneesti");
        testiDao.tyhjennaTiedosto();
    }
}
