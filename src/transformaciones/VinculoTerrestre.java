package transformaciones;

import elandriamodel.Criatura;

public class VinculoTerrestre extends CriaturaDecorator {

    public VinculoTerrestre(Criatura wrappee) {
        super(wrappee);
    }

    @Override
    public Integer getEnergia() {
        return Math.max(50, wrappee.getEnergia());
    }
    
    @Override
    public void entrenar() {
        wrappee.entrenar();  
    }

    @Override
    public void pacificar() {
        wrappee.pacificar();  
    }


}
