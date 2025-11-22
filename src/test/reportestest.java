package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import reportes.ReportesCouncil;
import maestros.MaestrosElemental;
import elandriamodel.*;
import transformaciones.*;

public class reportestest {

    private ReportesCouncil rc;
    private MaestrosElemental m1;
    private MaestrosElemental m2;

    @Before
    public void setUp() {
        rc = new ReportesCouncil();

        m1 = new MaestrosElemental("Ares", 10, Afinidad.FUEGO);
        m2 = new MaestrosElemental("Hera", 10, Afinidad.AGUA);

        m1.agregarCriatura(new CriaturaDomesticada("Uno", 30, Afinidad.FUEGO));
        m1.agregarCriatura(new LlamaInterna(new CriaturaDomesticada("Dos", 40, Afinidad.FUEGO)));

        m2.agregarCriatura(new CriaturaDomesticada("Tres", 20, Afinidad.AGUA));

        rc.agregarMaestro(m1);
        rc.agregarMaestro(m2);
    }

    @Test
    public void testMayorEnergia() {
        assertEquals("Dos", rc.criaturaMayorEnergia().get().getNombre());
    }

    @Test
    public void testMaestroConMasTransformadas() {
        assertEquals("Ares", rc.maestroConMasTransformadas().get().getNombre());
    }

    @Test
    public void testCantidadPorAfinidad() {
        var mapa = rc.cantidadPorAfinidad();

        assertEquals(Integer.valueOf(2), mapa.get(Afinidad.FUEGO));
        assertEquals(Integer.valueOf(1), mapa.get(Afinidad.AGUA));
    }
}
