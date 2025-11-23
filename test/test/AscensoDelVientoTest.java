package test;

import static org.junit.Assert.*;
import org.junit.Test;

import elandriamodel.*;
import transformaciones.*;

public class AscensoDelVientoTest {

    @Test
    public void testCambiaAfinidadAAire() {
        Criatura base = new CriaturaDomesticada("Mizu", 80, Afinidad.AGUA);
        Criatura asc = new AscensoDelViento(base);

        assertEquals(Afinidad.AIRE, asc.getAfinidad());
        assertEquals(Afinidad.AGUA, asc.obtenerBase().getAfinidad());
    }

    @Test
    public void testNoModificaEnergia() {
        Criatura base = new CriaturaDomesticada("Terra", 120, Afinidad.TIERRA);
        Criatura asc = new AscensoDelViento(base);

        assertEquals(Integer.valueOf(120), asc.getEnergia());
    }
}
