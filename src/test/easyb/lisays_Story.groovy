import viitehallinta.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi lisätä artikkeliviitteen'

scenario 'käyttäjä voi lisätä viitteen', {
    given 'lisäämis-toiminto on valittu', {
        testiDao = new FileDao("tyhjatestiviite.txt");
        io = new StubIO("1", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4");
        viitearkisto = new Viitearkisto(testiDao);
        kayttoliittyma = new Kayttoliittyma(io, viitearkisto);
        
    }
    when 'pakolliset kentät on täytetty', {
                kl.kaynnista();
    }
    then 'artikkeliviite on tallennettu' , {
        io.getPrints.shouldHave("Artikkeli lisätty onnistuneesti")
    }
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