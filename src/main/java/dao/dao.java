package dao;

import java.util.List;
import viitehallinta.Viite;

public interface dao {
    void lisaaViite(Viite viite);
    List <Viite> listaaViitteet();
    boolean poistaViite(Viite viite);
}
