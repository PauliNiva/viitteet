import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi lisätä artikkeliviitteen'

scenario 'käyttäjä voi lisätä viitteen', {
    given 'lisäämis-toiminto on valittu', {
        testiDao = new FileDao("tyhjätestiviite.txt");
        io = new StubIO("1", "9", "lokki", "lintu", "9", "9", "9", "2015", "9", "9", "katu", "4");
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'pakolliset kentät on täytetty', {
        kl.kaynnista();
    }
    then 'artikkeliviite on tallennettu' , {
        viitearkisto.getArtikkelit().size().shouldNotBe 0;
        testiDao.tyhjennaTiedosto();
        
    }
    testiDao.tyhjennaTiedosto();
    
}

//
//scenario 'käyttäjä ei voi lisätä viitettä jos jokin kenttä on tyhjä' {
//    given 'lisäämis-toiminto on valittu'
//    when 'kaikkia kenttiä ei ole täytetty'
//    then 'artikkeliviitettä ei tallenneta'
//}
//
//scenario 'käyttäjä ei voi lisätä viitettä jos jossain kentässä on virheellinen tieto' {
//    given 'lisäämis-toiminto on valittu'
//    when 'vuosi-kenttään syötetty merkkijono'
//    then 'artikkeliviitettä ei tallenneta'
//}
//
//scenario 'käyttäjä ei voi lisätä viitettä jos viite on jo tiedostossa' {
//    given 'lisäämis-toiminto on valittu'
//    when 'pakolliset kentät täytetty'
//    then 'artikkeliviitettä ei tallenneta'
//}