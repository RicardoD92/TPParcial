package transformaciones;

import elandriamodel.Criatura;

public class BendicionDelRio extends CriaturaDecorator {

    public BendicionDelRio(Criatura base) {
        super(base);
        // Duplica la energía pero nunca supera 180
        Integer actual = wrappee.getEnergia();
        Integer duplicada = Math.min(180, actual * 2);
        wrappee.sumarEnergia(duplicada - actual);
    }

    @Override public void entrenar() { wrappee.entrenar(); }
    @Override public void pacificar() { wrappee.pacificar(); }
}
