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
     * Poistaa käyttäjän valitseman ID:n mukaisen viitteen.
     */
    void poistaViite();
}
