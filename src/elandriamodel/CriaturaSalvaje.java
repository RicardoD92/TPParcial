package elandriamodel;

import excepciones.EnergyOverflowException;

public class CriaturaSalvaje extends Criatura {

    public CriaturaSalvaje(String nombre, Integer energia, Afinidad afinidad, Boolean inestable) {
        super(nombre, energia, afinidad, inestable);
    }

    @Override
    public void entrenar() {
        // comportamiento impredecible: aumento variable; aquí +30 (puede ajustarse)
        sumarEnergia(30);
        // Si supera 200 -> unchecked (EnergyOverflowException)
        if (energia > 200) throw new EnergyOverflowException("CriaturaSalvaje overflow: " + nombre);
        // puede volverse inestable si se pasa de cierto umbral
        if (energia > 150) inestable = true;
    }

    @Override
    public void pacificar() {
        inestable = false;
        restarEnergia(10);
    }
}
