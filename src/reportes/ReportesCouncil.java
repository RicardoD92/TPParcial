package reportes;

import java.util.*;
import elandriamodel.*;
import maestros.MaestrosElemental;
import transformaciones.CriaturaDecorator;

public class ReportesCouncil {

	private List<MaestrosElemental> maestros;

    public ReportesCouncil() {
        this.maestros = new ArrayList<>();
    }

    public void agregarMaestro(MaestrosElemental m) {
        if (m != null) {
            maestros.add(m);
        }
    }

   
     // 1. Criatura con mayor energía total.
    
    public Optional<Criatura> criaturaMayorEnergia() {
        return maestros.stream()
                .flatMap(m -> m.getCriaturas().stream())
                .max(Comparator.comparing(Criatura::getEnergia));
    }

    
     //2Maestro con más criaturas transformadas.
     
    public Optional<MaestrosElemental> maestroConMasTransformadas() {
        return maestros.stream()
                .max(Comparator.comparing(m -> m.cantidadTransformadas()));
    }

    
      //3. Cantidad de criaturas por afinidad elemental.
     
    public HashMap<Afinidad, Integer> cantidadPorAfinidad() {
        HashMap<Afinidad, Integer> mapa = new HashMap<>();

        // Inicializo el mapa
        for (Afinidad a : Afinidad.values()) {
            mapa.put(a, 0);
        }

        // 4  -Recorremos todas las criaturas de todos los maestros
        for (MaestrosElemental m : maestros) {
            for (Criatura c : m.getCriaturas()) {
                Afinidad af = c.getAfinidad();
                mapa.put(af, mapa.get(af) + 1);
            }
        }

        return mapa;
    }
}
