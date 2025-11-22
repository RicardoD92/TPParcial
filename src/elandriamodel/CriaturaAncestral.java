package elandriamodel;

import excepciones.EnergyOverflowException;

public class CriaturaAncestral extends Criatura {

    public CriaturaAncestral(String nombre, Integer energia, Afinidad afinidad, Boolean inestable) {
        super(nombre, energia, afinidad, inestable);
        if (this.energia < 100) this.energia = 100;
    }

    @Override
    public void entrenar() {
        sumarEnergia(20);
        if (energia > 200) throw new EnergyOverflowException("CriaturaAncestral overflow: " + nombre);
        if (energia > 180) inestable = true;
    }

    @Override
    public void pacificar() {
        inestable = false;
        if (energia < 100) energia = 100;
    }

    @Override
    public void restarEnergia(Integer cantidad) {
        if (cantidad == null) return;
        energia = Math.max(100, energia - cantidad);
    }
}
