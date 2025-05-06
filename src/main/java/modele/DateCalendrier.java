package modele;

import java.util.Calendar;

public class DateCalendrier extends Date implements ConstantesCalendrier {
    private int chJourSem;
    private int chNumSem;

    public DateCalendrier() {
        super(2025);
        Calendar calend = Calendar.getInstance();
        chJour = calend.get(Calendar.DAY_OF_MONTH);
        chMois = calend.get(Calendar.MONTH) + 1;
        chAnnee = calend.get(Calendar.YEAR);
        chJourSem = calend.get(Calendar.DAY_OF_WEEK);
        chNumSem = calend.get(Calendar.WEEK_OF_YEAR);
        if (chJourSem == Calendar.SUNDAY) {
            chJourSem = 7;
        }
    }

    public DateCalendrier(int parJour, int parMois, int parAnnee) {
        super(parJour, parMois, parAnnee);
        Calendar calend = Calendar.getInstance();
        System.out.println(calend.get(Calendar.WEEK_OF_YEAR));
        calend.set(parAnnee, parMois - 1, parJour);
        chJourSem = calend.get(Calendar.DAY_OF_WEEK);
        chNumSem = calend.get(Calendar.WEEK_OF_YEAR);
        System.out.println(chNumSem);
        if (chJourSem == Calendar.SUNDAY) {
            chJourSem = 7;
        }
    }

    public DateCalendrier dateDuLendemain() {
        Date dateLendemain = super.dateDuLendemain();
        return new DateCalendrier(dateLendemain.chJour, dateLendemain.chMois, dateLendemain.chAnnee);
    }

    public DateCalendrier dateDeLaVeille() {
        Date dateVeille = super.dateDeLaVeille();
        return new DateCalendrier(dateVeille.chJour, dateVeille.chMois, dateVeille.chAnnee);
    }

    public int getchNumSem() {
        return chNumSem;
    }

    public String toString() {
        return JOURS_SEMAINE[chJourSem - 1] + " " +  chJour + " " + MOIS[chMois - 1] + " " +  chAnnee;
    }
}
