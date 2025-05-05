package Modele;

public class ClientPlanningCollections {
    public static void main(String[] args) {
        try {
            PlanningCollections pc1 = new PlanningCollections();
            pc1.ajout(new Reservation(new DateCalendrier(1, 1, 2025), new PlageHoraire(new Horaire(10, 45), new Horaire(11, 45)), "11"));
            pc1.ajout(new Reservation(new DateCalendrier(3, 1, 2025), new PlageHoraire(new Horaire(10, 45), new Horaire(11, 45)), "22"));
            pc1.ajout(new Reservation(new DateCalendrier(15, 1, 2025), new PlageHoraire(new Horaire(10, 45), new Horaire(11, 45)), "33"));
            pc1.ajout(new Reservation(new DateCalendrier(1, 11, 2025), new PlageHoraire(new Horaire(10, 45), new Horaire(11, 45)), "44"));
            System.out.println(pc1);
            /*System.out.println(pc1.getReservations(new DateCalendrier(1, 2, 2025)));
            System.out.println(pc1.getReservations(new DateCalendrier(1, 1, 2025)));
            System.out.println(pc1.getReservations("YES"));
            System.out.println(pc1.getReservations("WOAW"));*/
        }
        catch (ExceptionPlageHoraire | ExceptionReservation parException) {
            System.out.println(parException.getMessage());
        }
    }
}
