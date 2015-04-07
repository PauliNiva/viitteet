package io;

import java.util.List;
import viitehallinta.Viite;

public interface IOtallennus {
    boolean kirjoita(List<Viite> viitteet);
    List <Viite> lue();
}
