import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi luoda BibTex-tiedoston'

scenario 'käyttäjä voi luoda BibTex-tiedoston artikkeli-viitteestä', {
    given 'bibtex-toiminto on valittu', {
        io = new StubIO("1", "1", "lokki", "lintu", "2015", "9", "notes", "21--24", "Lintuset", "7", "2", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'kaikki kentät on täytetty', {
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
        io = new StubIO("1", "2", "lokki", "lintu", "2015", "9", "notes", "Pubi", "address", "10", "7", "3", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'kaikki kentät on täytetty', {
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
        io = new StubIO("1","4","Nauris", "Vihannes", "2013", "2", "Julkkis", "We", "Edi", "BTitle", "100", "First", "20--24", "osoite", "Org", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'kaikki kentät on täytetty', {
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
        io = new StubIO("1","3","Majuri", "Asento", "1999", "1", "http://www.olenhauska.fi", "Pubi", "Editori", "luettu 1.1.01", "10", "First", "29--42", "osoite", "Org", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'kaikki kentät on täytetty', {
        kl.kaynnista();
    }
    then 'bibtex-tiedosto on tallennettu' , {
        io.getPrints().shouldHave("Viitteet lisatty bibViitteet.bib tiedostoon");
        io.getPrints().shouldHave("Inproceedings lisatty onnistuneesti");
        io.getPrints().shouldNotHave("Artikkeli lisatty onnistuneesti");
        testiDao.tyhjennaTiedosto();
    }
}
