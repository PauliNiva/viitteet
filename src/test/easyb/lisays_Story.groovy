import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi lisätä artikkeliviitteen'

scenario 'käyttäjä voi lisätä viitteen', {
    given 'lisäämis-toiminto on valittu', {
        testiDao = new FileDao("tyhjatestiviite.txt");
        io = new StubIO("1", "9", "lokki", "lintu", "9", "9", "9", "2015", "9", "9", "katu", "4");
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'artikkeliviite on tallennettu' , {
        viitearkisto.getArtikkelit().size().shouldNotBe 0;
    }

}
