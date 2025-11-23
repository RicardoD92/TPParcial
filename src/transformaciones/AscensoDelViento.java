package transformaciones;

import elandriamodel.*;

public class AscensoDelViento extends CriaturaDecorator {
	

    public AscensoDelViento(Criatura wrappee) {
        super(wrappee);
    }

    @Override
    public Afinidad getAfinidad() {
        return Afinidad.AIRE;
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


