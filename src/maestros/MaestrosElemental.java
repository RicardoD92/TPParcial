package maestros;

import elandriamodel.Criatura;
import elandriamodel.Afinidad;
import excepciones.InsufficientMasteryException;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class MaestrosElemental {

    private String nombre;
    private Integer nivelMaestria; // 1..50
    private Afinidad afinidad;
    private Map<String, Criatura> criaturas;

    public MaestrosElemental(String nombre, Integer nivelMaestria, Afinidad afinidad) {
        this.nombre = nombre;
        this.nivelMaestria = nivelMaestria == null ? 1 : nivelMaestria;
        this.afinidad = afinidad;
        this.criaturas = new HashMap<>();
    }

    public String getNombre() { return nombre; }
    public Integer getNivelMaestria() { return nivelMaestria; }
    public Afinidad getAfinidad() { return afinidad; }

    public void agregarCriatura(Criatura c) {
        if (c == null) return;
        criaturas.put(c.getNombre(), c);
    }

    public Criatura obtenerCriatura(String nombre) {
        return criaturas.get(nombre);
    }

    public Collection<Criatura> getCriaturas() {
        return criaturas.values();
    }

    public Map<String, Criatura> getMapaCriaturas() {
        return criaturas;
    }

    // Entrenar una criatura; lanza checked si el maestro no tiene suficiente maestría
    public void entrenarCriatura(String nombreCriatura) throws InsufficientMasteryException {
        Criatura c = criaturas.get(nombreCriatura);
        if (c == null) return;
        // Regla simple: si nivelMaestria < 5 -> no puede entrenar (ajustable)
        if (nivelMaestria < 5) {
            throw new InsufficientMasteryException("Maestría insuficiente para entrenar: " + nombreCriatura);
        }
        c.entrenar();
    }

    public void pacificarCriatura(String nombreCriatura) {
        Criatura c = criaturas.get(nombreCriatura);
        if (c != null) c.pacificar();
    }

    // Reemplaza la criatura por una versión transformada (decorator)
    public void transformarCriatura(String nombreCriatura, Criatura nuevaVersion) {
        if (nombreCriatura == null || nuevaVersion == null) return;
        criaturas.put(nombreCriatura, nuevaVersion);
    }

    // utilidad para reportes: cantidad de transformadas (instancias de transformaciones.CriaturaDecorator)
    public int cantidadTransformadas() {
        int count = 0;
        for (Criatura c : criaturas.values()) {
            if (c instanceof transformaciones.CriaturaDecorator) count++;
        }
        return count;
    }
}
