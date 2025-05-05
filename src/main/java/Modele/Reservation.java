package Modele;

public class Reservation implements Comparable<Reservation> {
    private DateCalendrier chDateCalendrier;
    private PlageHoraire chPlageHoraire;
    private String chIntitule;

    public Reservation(DateCalendrier parDate, PlageHoraire parPlageHoraire, String parIntitule) throws ExceptionReservation {
        chDateCalendrier = parDate;
        chPlageHoraire = parPlageHoraire;
        chIntitule = parIntitule;
        if (! estValide()) {
            throw new ExceptionReservation("Réservation invalide.");
        }
    }

    public int compareTo(Reservation parReservation) {
        if (chDateCalendrier.compareTo(parReservation.chDateCalendrier) == 0) {
            return chPlageHoraire.compareTo(parReservation.chPlageHoraire);
        }
        return chDateCalendrier.compareTo(parReservation.chDateCalendrier);
    }

    public boolean estValide() {
        return chDateCalendrier.estValide() && chPlageHoraire.estValide() && chIntitule != null;
    }

    public DateCalendrier getDateCalendrier() { return chDateCalendrier; }

    public PlageHoraire getPlageHoraire() { return chPlageHoraire; }

    public String getIntitule() { return chIntitule; }

    public void setDate(DateCalendrier parDate) { chDateCalendrier = parDate; }

    public void setPlageHoraire(PlageHoraire parPlageHoraire) { chPlageHoraire = parPlageHoraire; }

    public void setIntitule(String parIntitule) { chIntitule = parIntitule; }

    public String toString() {
        return chIntitule + " - " + chDateCalendrier + " - " + chPlageHoraire;
    }
}
