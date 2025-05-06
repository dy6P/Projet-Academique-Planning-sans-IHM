package modele;

public class ExceptionReservation extends Exception implements ConstantesErreur {

    public ExceptionReservation(String parMessageErreur) {
        super(parMessageErreur);
    }
}
