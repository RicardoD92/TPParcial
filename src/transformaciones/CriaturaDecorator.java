package transformaciones;

import elandriamodel.Criatura;
import elandriamodel.Afinidad;

public abstract class CriaturaDecorator extends Criatura {

    protected Criatura wrappee;

    public CriaturaDecorator(Criatura wrappee) {
        super(wrappee.getNombre(), wrappee.getEnergia(), wrappee.getAfinidad(), wrappee.esInestable());
        this.wrappee = wrappee;
    }

    @Override public String getNombre() { return wrappee.getNombre(); }
    @Override public Integer getEnergia() { return wrappee.getEnergia(); }
    @Override public Afinidad getAfinidad() { return wrappee.getAfinidad(); }
    @Override public Boolean esInestable() { return wrappee.esInestable(); }

    @Override public void sumarEnergia(Integer c) { wrappee.sumarEnergia(c); }
    @Override public void restarEnergia(Integer c) { wrappee.restarEnergia(c); }
    @Override public void setInestable(Boolean i) { wrappee.setInestable(i); }

    @Override public Criatura obtenerBase() { return wrappee.obtenerBase(); }
}
