package elandriamodel;

public enum Afinidad {
    AGUA, FUEGO, AIRE, TIERRA;

    public boolean esOpuesta(Afinidad otra) {
        if (this == AGUA && otra == FUEGO) return true;
        if (this == FUEGO && otra == AGUA) return true;
        if (this == AIRE && otra == TIERRA) return true;
        if (this == TIERRA && otra == AIRE) return true;
        return false;
    }
}
