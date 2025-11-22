package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import elandriamodel.*;
import excepciones.EnergyOverflowException;

public class criaturatest {

    private Criatura salvaje;
    private Criatura domesticada;
    private Criatura ancestral;

    @Before
    public void setUp() {
        salvaje = new CriaturaSalvaje("Lobo", 80, Afinidad.FUEGO, false);
        domesticada = new CriaturaDomesticada("Perro", 50, Afinidad.AGUA);
        ancestral = new CriaturaAncestral("Dragon", 150, Afinidad.AIRE, false);
    }

    @Test
    public void testEntrenarDomesticadaSuma10() {
        domesticada.entrenar();
        assertEquals(Integer.valueOf(60), domesticada.getEnergia());
    }

    @Test(expected = EnergyOverflowException.class)
    public void testEntrenarSalvajePuedeDesbordar() {
        Criatura c = new CriaturaSalvaje("Fiera", 190, Afinidad.FUEGO, false);
        c.entrenar();
    }

    @Test
    public void testAncestralNuncaBajaDe100() {
        ancestral.restarEnergia(300);
        assertEquals(Integer.valueOf(100), ancestral.getEnergia());
    }

    @Test
    public void testPacificarSalvajeLaTranquiliza() {
        salvaje.setInestable(true);
        salvaje.pacificar();
        assertFalse(salvaje.esInestable());
    }
}
