import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi luoda BibTex-tiedoston'

scenario 'käyttäjä voi luoda BibTex-tiedoston artikkeli-viitteestä', {
    given 'bibtex-toiminto on valittu', {
        io = new StubIO("1", "1", "lokki", "lintu", "2015", "9", "notes", "21--24", "Lintuset", "7", "2", "0", "4", "0");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'kaikki kentät on täytetty', {
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
        io = new StubIO("1", "2", "lokki", "lintu", "2015", "9", "notes", "Pubi", "address", "10", "7", "3", "0", "4", "0");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'kaikki kentät on täytetty', {
        kl.kaynnista();
    }
    then 'bibtex-tiedosto on tallennettu' , {
        io.getPrints().shouldHave("Viitteet lisätty bibViitteet.bib tiedostoon");
        io.getPrints().shouldHave("Kirja lisätty onnistuneesti");
        io.getPrints().shouldNotHave("Artikkeli lisätty onnistuneesti");
        testiDao.tyhjennaTiedosto();
    }
}
scenario 'käyttäjä voi luoda BibTex-tiedoston misc-viitteestä', {
    given 'bibtex-toiminto on valittu', {
        io = new StubIO("1","4","Nauris", "Vihannes", "2013", "2", "Julkkis", "We", "Edi", "BTitle", "100", "First", "20--24", "osoite", "Org", "0", "4", "0");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'kaikki kentät on täytetty', {
        kl.kaynnista();
    }
    then 'bibtex-tiedosto on tallennettu' , {
        io.getPrints().shouldHave("Viitteet lisätty bibViitteet.bib tiedostoon");
        io.getPrints().shouldHave("Misc lisätty onnistuneesti");
        io.getPrints().shouldNotHave("Artikkeli lisätty onnistuneesti");
        testiDao.tyhjennaTiedosto();
    }
}
scenario 'käyttäjä voi luoda BibTex-tiedoston inproceedins-viitteestä', {
    given 'bibtex-toiminto on valittu', {
        io = new StubIO("1","3","Majuri", "Asento", "1999", "1", "http://www.olenhauska.fi", "Pubi", "Editori", "luettu 1.1.01", "10", "First", "29--42", "osoite", "Org", "0", "4", "0");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'kaikki kentät on täytetty', {
        kl.kaynnista();
    }
    then 'bibtex-tiedosto on tallennettu' , {
        io.getPrints().shouldHave("Viitteet lisätty bibViitteet.bib tiedostoon");
        io.getPrints().shouldHave("Inproceedings lisätty onnistuneesti");
        io.getPrints().shouldNotHave("Artikkeli lisätty onnistuneesti");
        testiDao.tyhjennaTiedosto();
    }
}
