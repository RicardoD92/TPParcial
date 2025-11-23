package elandriamodel;

public class CriaturaDomesticada extends Criatura {

    public CriaturaDomesticada(String nombre, Integer energia, Afinidad afinidad) {
        super(nombre, energia, afinidad, false);
    }





	@Override
    public void entrenar() {
        sumarEnergia(10);
    }

    @Override
    public void pacificar() {
        // nunca se vuelve inestable; no hace nada
    }
}
