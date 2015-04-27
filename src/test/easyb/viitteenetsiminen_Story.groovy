import io.*;
import dao.*;
import ui.*;
import viitehallinta.*;

description 'Kayttaja voi etsia viitteen'

scenario 'kayttaja voi etsia viitteen authorin perusteella', {
    given 'etsimis-toiminto on valittu', {
        io = new StubIO("1", "2", "lokki", "lintu", "2015", "9", "notes", "Pubi", "address", "10", "7", "3", "0", "5", "lokki", "0");        
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'hakusana on annettu', {
        kl.kaynnista();
    }
    then 'hakusana antaa tuloksen' , {
        io.getPrints().shouldHave("Author: lokki");
        testiDao.tyhjennaTiedosto();
    }
}

scenario 'kayttaja voi etsia viitteen yearin perusteella', {
    given 'etsimis-toiminto on valittu', {
        io = new StubIO("1", "2", "lokki", "lintu", "2015", "9", "notes", "Pubi", "address", "10", "7", "3", "0", "5", "2015", "0");        
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'hakusana on annettu', {
        kl.kaynnista();
    }
    then 'hakusana antaa tuloksen' , {
        io.getPrints().shouldHave("Author: lokki");
        testiDao.tyhjennaTiedosto();
    }
}

scenario 'kayttaja voi etsia viitteen titlen perusteella', {
    given 'etsimis-toiminto on valittu', {
        io = new StubIO("1", "2", "lokki", "lintu", "2015", "9", "notes", "Pubi", "address", "10", "7", "3", "0", "5", "2015", "0");        
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'hakusana on annettu', {
        kl.kaynnista();
    }
    then 'hakusana antaa tuloksen' , {
        io.getPrints().shouldHave("Author: lokki");
        testiDao.tyhjennaTiedosto();
    }
}

scenario 'kayttaja etsii viitetta, jota ei ole', {
    given 'etsimis-toiminto on valittu', {
        io = new StubIO("1", "2", "lokki", "lintu", "2015", "9", "notes", "Pubi", "address", "10", "7", "3", "0", "5", "ankka", "0");        
        testiDao = new FileDao(io);
        viitearkisto = new Viitearkisto(testiDao);
        kl = new Kayttoliittyma(io, viitearkisto);

    }
    when 'hakusana on annettu', {
        kl.kaynnista();
    }
    then 'hakusanalla ei loydy tulosta' , {
        io.getPrints().shouldHave("Haku ei tuottanut");
        testiDao.tyhjennaTiedosto();
    }
}