package viitehallinta;

import java.io.Serializable;
import java.util.List;

/**
 * Luokka miscviite-olioille, jonka konstruktori on kuormitettu. Perii
 * Viite-luokan ja toteuttaa Serializable rajapinnan.
 */
public class Misc extends Viite implements Serializable {

    private static final long serialVersionUID = 4L;
    private String howpublished;

    /**
     * Konstruktori ilman kenttiä.
     */
    public Misc() {
    }

    public String getHowPublished() {
        return this.howpublished;
    }

    public void setHowPublished(String howpublished) {
        this.howpublished = howpublished;
    }

    static public List<Kentta> haeKentat() {
        List<Kentta> kentat = Viite.haeKentat();
        for (Kentta kentta : kentat) {
            kentta.setPakollisuus(false);
        }
        kentat.add(new Kentta("How published", "merkkijono", false));

        return kentat;
    }
}
