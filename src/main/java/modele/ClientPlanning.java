package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientPlanning {
    public static void main(String[] args) {
        try {
            Planning p1 = new Planning(4); // mettre le bon nombre de réservations pour que le tri marche

            DateCalendrier d1 = new DateCalendrier(1, 1, 2025);
            DateCalendrier d2 = new DateCalendrier(1, 1, 2024);
            DateCalendrier d3 = new DateCalendrier(1, 12, 2024);

            Horaire h1 = new Horaire(21, 30);
            Horaire h2 = new Horaire(23, 59);
            Horaire h3 = new Horaire(19, 30);
            Horaire h4 = new Horaire(20, 52);
            Horaire h5 = new Horaire(15, 30);
            Horaire h6 = new Horaire(16, 52);

            PlageHoraire ph1 = new PlageHoraire(h1, h2);
            PlageHoraire ph2 = new PlageHoraire(h3, h4);
            PlageHoraire ph3 = new PlageHoraire(h5, h6);

            Reservation r1 = new Reservation(d1, ph1, "Nouvel An");
            Reservation r2 = new Reservation(d2, ph2, "Nouvel An");
            Reservation r3 = new Reservation(d2, ph3, "Nouvel An");
            Reservation r4 = new Reservation(d3, ph3, "Nouvel An");

            p1.ajout(r1);
            System.out.println(p1);
            p1.ajout(r2);
            System.out.println(p1);
            p1.ajout(r4);
            System.out.println(p1);
            p1.ajout(r3);
            System.out.println(p1);

            Reservation[] tab = p1.getChReservations();
            Arrays.sort(p1.getChReservations());
            System.out.println(Arrays.toString(tab));

            Scanner scanner = new Scanner(new File("data" + File.separator + "planning.txt")).useDelimiter(",");
            while (scanner.hasNext()) {
                String intitule = scanner.next();
                int jour = scanner.nextInt();
                int mois = scanner.nextInt();
                int annee = scanner.nextInt();
                int HDh = scanner.nextInt();
                int HDm = scanner.nextInt();
                int HFh = scanner.nextInt();
                int HFm = scanner.nextInt();
                Reservation r = new Reservation(new DateCalendrier(jour, mois, annee), new PlageHoraire(new Horaire(HDh, HDm), new Horaire(HFh, HFm)), intitule);
                System.out.println(r);
            }
        }
        catch (ExceptionPlageHoraire | ExceptionReservation | FileNotFoundException |
               NoSuchElementException | IllegalStateException parException) {
            System.out.println(parException.getMessage());
        }
        catch (ExceptionPlanning parException) {
            System.out.println("Code d'erreur " + parException.getChCodeErreur() + " : " + parException);
        }
    }
}
