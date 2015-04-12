import viitehallinta.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Käyttäjä voi lisätä artikkeliviitteen'

scenario 'käyttäjä voi lisätä viitteen', {
    given 'lisäämis-toiminto on valittu', {
//        dao = new FileDao();        //groovy antaa nää tällein, ei oo virhe
//        io = new KayttoliittymaIO();
//        viitearkisto = new Viitearkisto(dao);
//        kl = new Kayttoliittyma(io, viitearkisto);
    }
    when 'pakolliset kentät on täytetty', {
//        kl.kaynnista();
    }
    then 'artikkeliviite on tallennettu' , {
        
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