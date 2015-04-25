import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi lisätä inproceedings-viitteen'

scenario 'käyttäjä voi lisätä inproceedings-viitteen', {
    given 'inproceedingsin lisäämis-toiminto on valittu', {
        io = new StubIO("1","3","Majuri", "Asento", "1999", "1", "http://www.olenhauska.fi", "Pubi", "Editori", "luettu 1.1.01", "10", "First", "29--42", "osoite", "Org", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'kaikki kentät on täytetty', {
        kl.kaynnista();
    }
    then 'inproceedings-viite on tallennettu' , {
        viitearkisto.getViitteet().size().shouldNotBe 0;
        io.getPrints().shouldHave("Inproceedings lisatty onnistuneesti")
        io.getPrints().shouldNotHave("Artikkeli lisatty onnistuneesti")
        testiDao.tyhjennaTiedosto();
    }
}

scenario 'käyttäjä voi lisätä inproceedings-viitteen', {
    given 'inproceedingsin lisäämis-toiminto on valittu', {
        io = new StubIO("1","3","Majuri", "Asento", "1999", "", "", "Pubi", "", "Kas inproc", "", "", "", "", "", "5", "4", "5");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'vain pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'inproceedings-viite on tallennettu' , {
        viitearkisto.getViitteet().size().shouldNotBe 0;
        io.getPrints().shouldHave("Inproceedings lisatty onnistuneesti")
        io.getPrints().shouldNotHave("Artikkeli lisatty onnistuneesti")
        testiDao.tyhjennaTiedosto();
    }
}