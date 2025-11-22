package elandriamodel;

import excepciones.EnergyOverflowException;

public abstract class Criatura {
    protected String nombre;
    protected Integer energia; // 0..200
    protected Afinidad afinidad;
    protected Boolean inestable;

    public Criatura(String nombre, Integer energia, Afinidad afinidad, Boolean inestable) {
        this.nombre = nombre;
        this.energia = energia == null ? 0 : energia;
        this.afinidad = afinidad;
        this.inestable = inestable == null ? false : inestable;
        validarRangos();
    }

    protected void validarRangos() {
        if (energia > 200) throw new EnergyOverflowException("Energía > 200: " + energia);
        if (energia < 0) energia = 0;
    }

    public String getNombre() { return nombre; }
    public Integer getEnergia() { return energia; }
    public Afinidad getAfinidad() { return afinidad; }
    public Boolean esInestable() { return inestable; }

    public abstract void entrenar();
    public abstract void pacificar();

    public void sumarEnergia(Integer cantidad) {
        if (cantidad == null) return;
        energia = energia + cantidad;
        if (energia > 200) throw new EnergyOverflowException("Energía > 200: " + energia);
    }

    public void restarEnergia(Integer cantidad) {
        if (cantidad == null) return;
        energia = Math.max(0, energia - cantidad);
    }

    public void setInestable(Boolean i) { this.inestable = i == null ? false : i; }

    public Criatura obtenerBase() { return this; }
}
