package main;

import dao.FileDao;
import io.KayttoliittymaIO;
import ui.Kayttoliittyma;
import viitehallinta.Viitearkisto;

public class Kaynnistaja {

    public void kaynnista(String[] args) {
        KayttoliittymaIO kayttoliittymaIO = new KayttoliittymaIO();
        FileDao dao = new FileDao("viitteet.txt", kayttoliittymaIO);
        Viitearkisto viitearkisto = new Viitearkisto(dao);
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(kayttoliittymaIO, viitearkisto);
        kayttoliittyma.kaynnista();
    }
}
