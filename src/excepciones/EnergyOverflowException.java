package excepciones;

public class EnergyOverflowException extends RuntimeException {
    public EnergyOverflowException(String msg) {
        super(msg);
    }
}
