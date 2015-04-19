package ui;

public interface UI {

    /**
     * Käynnistää UI:n ja pitää ohjelman käynnissä kunnes käyttäjä valitsee
     * valikosta lopetuksen.
     */
    void kaynnista();

    /**
     * Näyttää valikon konsolissa.
     */
    void naytaValikkoJaPyydaValinta();

    /**
     * //TODO!! todennäköiseti poistaa viitteen viitearkiston metodia apuna
     * käyttäen.
     *
     * @return varmaankin poistettavan viitteen jonkinlainen tunniste.
     */
    void poistaViite();
}
