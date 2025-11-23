package transformaciones;

import elandriamodel.Afinidad;
import elandriamodel.Criatura;

public class LlamaInterna extends CriaturaDecorator {

    public LlamaInterna(Criatura wrappee) {
        super(wrappee);

        if (wrappee.getAfinidad() == Afinidad.FUEGO) {
            wrappee.sumarEnergia(30);
        } else {
            wrappee.setInestable(true);
        }
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
