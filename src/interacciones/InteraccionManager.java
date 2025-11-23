package interacciones;

import elandriamodel.Criatura;
import elandriamodel.CriaturaAncestral;

public class InteraccionManager {

    public static void interactuar(Criatura a, Criatura b) {
        if (a == null || b == null) return;

        boolean aAnc = a instanceof CriaturaAncestral;
        boolean bAnc = b instanceof CriaturaAncestral;

        if (aAnc && !bAnc) {
            a.sumarEnergia(20);
            b.restarEnergia(15);
            if (b.getEnergia() == 0) b.setInestable(true);
            return;
        }
        if (bAnc && !aAnc) {
            b.sumarEnergia(20);
            a.restarEnergia(15);
            if (a.getEnergia() == 0) a.setInestable(true);
            return;
        }

        // misma afinidad -> ambas +10
        if (a.getAfinidad() == b.getAfinidad()) {
            a.sumarEnergia(10);
            b.sumarEnergia(10);
            return;
        }

        // opuestas -> se vuelven inestables
        if (a.getAfinidad().esOpuesta(b.getAfinidad())) {
            a.setInestable(true);
            b.setInestable(true);
            return;
        }

        // caso neutro
        a.sumarEnergia(5);
        b.sumarEnergia(5);
    }
}
