package util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author esaharju
 */
public class UtilTest {
    
    @Test
    public void muotoileNumeroMerkkijonoksiTest() {
        String result = Util.muotoileNumeroMerkkijonoksi(10);
        assertEquals("10", result);
    }

    @Test
    public void muotoileNumeroMerkkijonoksiEpakelpoArvoTest() {
        String result = Util.muotoileNumeroMerkkijonoksi(Integer.MIN_VALUE);
        assertEquals("", result);
    }
}
