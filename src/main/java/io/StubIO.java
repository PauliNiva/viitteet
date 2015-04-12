package io;

import io.IO;
import java.util.ArrayList;

public class StubIO implements IO {

    private String[] lines;
    private int i;
    private ArrayList<String> prints;

    public StubIO(String... values) {
        this.lines = values;
        prints = new ArrayList<String>();
    }

    public void print(String toPrint) {
        prints.add(toPrint);
    }

    public int readInt(String prompt) {
        print(prompt);
        return Integer.parseInt(lines[i++]);
    }

    public ArrayList<String> getPrints() {
        return prints;
    }

    public String readLine(String prompt) {
        print(prompt);
        if (i < lines.length) {
            return lines[i++];
        }
        return "";
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
