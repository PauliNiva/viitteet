package viitehallinta;

/**
 * Viitetyyppi luokkien kenttien tiedot sisältävä rakenne.
 */
public class Kentta {
    private String nimi;
    private String tietotyyppi;
    private boolean pakollisuus;
    
    /**
     * Konstruktori pakollisilla kentillä
     * @param nimi kentän nimi
     * @param tietotyyppi tietotyyppi - merkkijono tai kokonaisluku
     * @param pakollisuus onko kenttä pakollinen viitetyypille
     */
    public Kentta(String nimi, String tietotyyppi, boolean pakollisuus) {
        this.nimi = nimi;
        this.tietotyyppi = tietotyyppi;
        this.pakollisuus = pakollisuus;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getTietotyyppi() {
        return tietotyyppi;
    }

    public void setTietotyyppi(String tietotyyppi) {
        this.tietotyyppi = tietotyyppi;
    }

    public boolean pakollinen() {
        return pakollisuus;
    }

    public void setPakollisuus(boolean pakollisuus) {
        this.pakollisuus = pakollisuus;
    }
    
    
}
