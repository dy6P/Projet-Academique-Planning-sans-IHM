package modele;

import java.util.Arrays;

public class Planning {
    private Reservation[] chReservations;
    private final int TAILLE;
    private int chEffectif;

    public Planning(int parTaille) {
        chReservations = new Reservation[parTaille];
        TAILLE = parTaille;
    }

    public void triSelection () {
        int min;
        for (int i = 0; i <= chEffectif; i++) {
            min = plusAncienneReservation(i, chEffectif);
            Reservation stock = chReservations[min];
            chReservations[min] = chReservations[i];
            chReservations[i] = stock;
        }
    }

    public void triInsertion () {
        int min;
        int sup;
        for (int i = 0; i <= chEffectif; i++) {
            sup = i + 1;
            min = plusAncienneReservation(i, sup);
            Reservation stock = chReservations[min];
            chReservations[min] = chReservations[i];
            chReservations[i] = stock;
        }
    }

    public void ajout(Reservation parReservation) throws ExceptionPlanning {
        if (! parReservation.estValide()) {
            throw new ExceptionPlanning(0);
        }
        for (int i=0; i < chEffectif; i++) {
            if (chReservations[i].compareTo(parReservation) == 0) {
                throw new ExceptionPlanning(2);
            }
        }
        if (chEffectif >= TAILLE) {
            throw new ExceptionPlanning(1);
        }
        chReservations[chEffectif++] = parReservation;
    }

    public int plusAncienneReservation (int parDebut, int parFin) {
        if (parDebut > chEffectif || parDebut < 0 || parFin >= TAILLE) {
            return 0;
        }
        int plusAncienne = 0;
        for (int i = parDebut; i < parFin; i++) {
            if (chReservations[i] != null && chReservations[i].compareTo(chReservations[plusAncienne]) == -1) {
                plusAncienne = i;
            }
        }
        return plusAncienne;
    }

    public Reservation getChReservation(Date parDate) {
        for (int i = 0; i < chEffectif; i++) {
            if (chReservations[i].getDateCalendrier().compareTo(parDate) == 0) {
                return chReservations[i];
            }
        }
        return null;
    }

    public Reservation [] getChReservations(Date parDate) {
        Reservation [] reservations = new Reservation[chEffectif];
        for (int i = 0; i < chEffectif; i++) {
            if (chReservations[i].getDateCalendrier().compareTo(parDate) == 0) {
                reservations[i] = chReservations[i];
            }
        }
        return reservations;
    }

    public Reservation [] getChReservations() {
        return chReservations;
    }

    public String toString(Reservation [] parReservations) {
        return "Réservations : " + Arrays.toString(parReservations);
    }

    public String toString() {
        return "Réservations : " + Arrays.toString(chReservations);
    }
}
