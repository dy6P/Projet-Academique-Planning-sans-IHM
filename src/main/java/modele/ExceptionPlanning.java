package modele;

public class ExceptionPlanning extends Exception implements ConstantesErreur {
    private int chCodeErreur;

    public ExceptionPlanning(int parCodeErreur) {
        chCodeErreur = parCodeErreur;
    }

    public int getChCodeErreur() {
        return chCodeErreur;
    }

    public String toString() {
        return ERREURS_PLANNING[chCodeErreur];
    }
}
