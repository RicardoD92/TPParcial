package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import elandriamodel.*;
import interacciones.InteraccionManager;

public class interaccionestest {

    private Criatura a;
    private Criatura b;

    @Before
    public void setUp() {
        a = new CriaturaDomesticada("Ave", 50, Afinidad.AIRE);
        b = new CriaturaDomesticada("Topo", 60, Afinidad.TIERRA);
    }

    @Test
    public void testAfinidadesOpuestasInestabilizan() {
        InteraccionManager.interactuar(a, b);
        assertTrue(a.esInestable());
        assertTrue(b.esInestable());
    }

    @Test
    public void testCriaturaAncestralDomina() {
        Criatura anc = new CriaturaAncestral("Fenrir", 150, Afinidad.FUEGO, false);

        InteraccionManager.interactuar(anc, b);

        assertEquals(Integer.valueOf(170), anc.getEnergia());
        assertEquals(Integer.valueOf(45), b.getEnergia());
    }

    @Test
    public void testAfinidadIgualSuma10() {
        Criatura c1 = new CriaturaDomesticada("Pez1", 30, Afinidad.AGUA);
        Criatura c2 = new CriaturaDomesticada("Pez2", 40, Afinidad.AGUA);

        InteraccionManager.interactuar(c1, c2);

        assertEquals(Integer.valueOf(40), c1.getEnergia());
        assertEquals(Integer.valueOf(50), c2.getEnergia());
    }
}
