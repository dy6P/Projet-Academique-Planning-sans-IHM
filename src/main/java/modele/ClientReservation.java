package modele;

public class ClientReservation {
    public static void main(String[] args) {
        try {
            DateCalendrier date1 = new DateCalendrier(12, 4, 2022);
            Horaire horaire1 = new Horaire(12, 30);
            Horaire horaire2 = new Horaire(13, 0);
            PlageHoraire plageHoraire1 = new PlageHoraire(horaire1, horaire2);
            String intitule1 = "Manger";
            Reservation reservation1 = new Reservation(date1, plageHoraire1, intitule1);
            DateCalendrier date2 = new DateCalendrier(13, 4, 2022);
            Horaire horaire3 = new Horaire(14, 0);
            Horaire horaire4 = new Horaire(23, 0);
            PlageHoraire plageHoraire2 = new PlageHoraire(horaire3, horaire4);
            String intitule2 = "Dormir";
            Reservation reservation2 = new Reservation(date2, plageHoraire2, intitule2);
            System.out.println(reservation2.estValide());
            System.out.println(reservation1);
            System.out.println(reservation2);
            System.out.println(reservation1.compareTo(reservation2));
        }
        catch (ExceptionPlageHoraire | ExceptionReservation parExecption) {
            System.out.println(parExecption.getMessage());
        }
    }
}
