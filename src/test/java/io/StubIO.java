package io;

import java.util.ArrayList;

/**
 * Stub joka toteuttaa IO-rajapinnan. Testaamiseen.
 */
public class StubIO implements IO {

    private String[] lines;
    private int i;
    private ArrayList<String> prints;

    public StubIO(String... values) {
        this.lines = values;
        prints = new ArrayList<String>();
    }

    public ArrayList<String> getPrints() {
        return prints;
    }

    @Override
    public String lueRivi() {
        if (i < lines.length) {
            return lines[i++];
        }
        return "";
    }

    @Override
    public void tulostaIlmanRivinvaihtoa(String rivi) {
        System.out.print(rivi);
        prints.add(rivi);
    }

    @Override
    public void tulostaRivi(String rivi) {
        System.out.println(rivi);
        prints.add(rivi);
    }
}
