package Modele;

public class PlageHoraire implements Comparable<PlageHoraire> {
    private final static int DUREE_MIN = 30;
    private Horaire chHoraireDebut;
    private Horaire chHoraireFin;

    public PlageHoraire(Horaire parHoraireDebut, Horaire parHoraireFin) throws ExceptionPlageHoraire {
        chHoraireDebut = parHoraireDebut;
        chHoraireFin = parHoraireFin;
        if (! estValide()) {
            throw new ExceptionPlageHoraire("Plage horaire inférieure à 30 minutes.");
        }
    }

    public int duree() {
        return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes();
    }

    public int compareTo(PlageHoraire parPlageHoraire) {
        if (parPlageHoraire.chHoraireFin.toMinutes() < chHoraireDebut.toMinutes()) {
            return 1;
        }
        else if (parPlageHoraire.chHoraireDebut.toMinutes() > chHoraireFin.toMinutes()) {
            return -1;
        }
        return 0;
    }

    public boolean estValide() {
        return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes() >= DUREE_MIN;
    }

    public Horaire getHoraireDebut() { return chHoraireDebut; }

    public Horaire getHoraireFin() { return chHoraireFin; }

    public void setHoraireDebut(Horaire parHoraireDebut) { chHoraireDebut = parHoraireDebut; }

    public void setChHoraireFin(Horaire parHoraireFin) { chHoraireFin = parHoraireFin; }

    public String toString() {
        return chHoraireDebut + " - " + chHoraireFin + ", durée : " + duree()/60 + "h" + duree()%60 + "min";
    }
}
