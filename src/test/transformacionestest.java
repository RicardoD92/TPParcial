package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import elandriamodel.*;
import transformaciones.*;

public class transformacionestest {

    private Criatura c;

    @Before
    public void setUp() {
        c = new CriaturaDomesticada("Naiad", 40, Afinidad.AGUA);
    }

    @Test
    public void testBendicionDelRioDuplicaSinSuperar180() {
        c = new BendicionDelRio(c);
        assertEquals(Integer.valueOf(80), c.getEnergia());
    }

    @Test
    public void testLlamaInternaEnAfinidadIncorrectaVuelveInestable() {
        c = new LlamaInterna(c);
        assertTrue(c.esInestable());
    }

    @Test
    public void testAscensoDelVientoCambiaAfinidad() {
        c = new AscensoDelViento(c);
        assertEquals(Afinidad.AIRE, c.getAfinidad());
    }
}
