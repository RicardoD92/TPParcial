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
    
    @Test
    public void testAfinidadCambiaAAireSinPerderOriginal() {
        Criatura base = new CriaturaDomesticada("Mizu", 80, Afinidad.AGUA);
        Criatura asc = new AscensoDelViento(base);

        assertEquals(Afinidad.AIRE, asc.getAfinidad());
        assertEquals(Afinidad.AGUA, ((Transformacion)asc).getOriginal().getAfinidad());
    }
    
    @Test
    public void testFuegoAumenta30() {
        Criatura base = new CriaturaDomesticada("Flam", 100, Afinidad.FUEGO);
        Criatura llama = new LlamaInterna(base);

        assertEquals(Integer.valueOf(130), llama.getEnergia());
        assertFalse(llama.esInestable());
    }

    @Test
    public void testNoFuegoVuelveInestable() {
        Criatura base = new CriaturaDomesticada("Nami", 90, Afinidad.AGUA);
        Criatura llama = new LlamaInterna(base);

        assertTrue(llama.esInestable());
    }
    
    @Test
    public void testEnergiaSeFuerzaAMinimo50() {
        Criatura base = new CriaturaDomesticada("Root", 20, Afinidad.TIERRA);
        Criatura vinculo = new VinculoTerrestre(base);

        assertEquals(Integer.valueOf(50), vinculo.getEnergia());
    }

    @Test
    public void testEnergiaMayor50NoCambia() {
        Criatura base = new CriaturaDomesticada("Gaia", 120, Afinidad.AIRE);
        Criatura vinculo = new VinculoTerrestre(base);

        assertEquals(Integer.valueOf(120), vinculo.getEnergia());
    }
    
    
}
