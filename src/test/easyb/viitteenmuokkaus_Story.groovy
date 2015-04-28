import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Kayttaja voi muokata viittetta'

scenario 'kayttaja voi muokata artikkeli viitetta', {
    given 'muokkaamis-toiminto on valittu', {
        io = new StubIO("1", "1", "pulu", "lintu", "2000", "",
            "", "", "linnut", "3", "", "0", "6", "pulu2000lintu", \
            "lokki", "lintu", "2013", "", "", "", "Lintuset", "7", "", "0");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'muokattu viite on annettu', {
        kl.kaynnista();
    }
    then 'muokkaus on onnistunut' , {
        io.getPrints().shouldHave("Artikkeli lisätty onnistuneesti");
        viitearkisto.getViitteet().size().shouldBe 1;
        testiDao.tyhjennaTiedosto();
    }
}

scenario 'kayttaja voi muokata kirja viitetta', {
    given 'muokkaamis-toiminto on valittu', {
        io = new StubIO("1", "2", "make", "kirja", "2013", "", "", "otava", "", 
            "", "", "edi","0", "6", "make2013kirja", "lokki", "lintu", "2015","",
            "", "Pubi", "", "", "", "", "0");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'muokattu viite on annettu', {
        kl.kaynnista();
    }
    then 'muokkaus on onnistunut' , {
        io.getPrints().shouldHave("Kirja lisätty onnistuneesti");
        viitearkisto.getViitteet().size().shouldBe 1;
        testiDao.tyhjennaTiedosto();
    }
}

scenario 'kayttaja voi muokata misc viitetta', {
    given 'muokkaamis-toiminto on valittu', {
        io = new StubIO("1", "4", "tyyppi", "virhe", "92", "", "", "", "0",
            "6", "tyyppi92virhe", "toinen", "virhe", "", "", "", "", "0");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'muokattu viite on annettu', {
        kl.kaynnista();
    }
    then 'muokkaus on onnistunut' , {
        io.getPrints().shouldHave("Misc lisätty onnistuneesti");
        viitearkisto.getViitteet().size().shouldBe 1;
        testiDao.tyhjennaTiedosto();
    }
}

scenario 'kayttaja voi muokata inproceedings viitetta', {
    given 'muokkaamis-toiminto on valittu', {
        io = new StubIO("1", "3", "porkkana", "mahtavuus", "2014", "", "", "", "",
            "otsake", "", "", "3--23", "", "", "0", "6", "porkkana2014mahtavuus", 
            "Nauris", "Vihannes", "2013", "2", "http://www.vihannes.com",
            "Pubi", "Edi", "Otsake", "7", "First", "", "Addr", "Org", "0");
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'muokattu viite on annettu', {
        kl.kaynnista();
    }
    then 'muokkaus on onnistunut' , {
        io.getPrints().shouldHave("Inproceedings lisätty onnistuneesti");
        viitearkisto.getViitteet().size().shouldBe 1;
        testiDao.tyhjennaTiedosto();
    }
}