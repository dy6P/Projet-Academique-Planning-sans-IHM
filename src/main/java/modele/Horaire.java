package modele;

public class Horaire {
    private int chHeure;
    private int chMinutes;

    public Horaire(int parHeure, int parMinutes) {
        chHeure = parHeure;
        chMinutes = parMinutes;
    }

    /**
     * compareTo() retourne
     * - un entier négatif si l’horaire this est antérieur à parHoraire
     * - un entier positif si l’horaire this est postérieur à parHoraire
     * - 0 si this et parHoraire sont les mêmes horaires
     * @param parHoraire l’horaire comparé à this
     * @return un entier résultat de la comparaison
     */
    public int compareTo(Horaire parHoraire) {
        return this.toMinutes() - parHoraire.toMinutes();
    }

    public int toMinutes() {
        return chHeure * 60 + chMinutes;
    }

    public int getHeure() {
        return chHeure;
    }

    public int getMinutes() {
        return chMinutes;
    }

    public void setHeure(int parHeure) {
        chHeure = parHeure;
    }

    public void setMinutes(int parMinutes) {
        chMinutes = parMinutes;
    }

    public String toString() {
        return chHeure + "h" + chMinutes;
    }
}
