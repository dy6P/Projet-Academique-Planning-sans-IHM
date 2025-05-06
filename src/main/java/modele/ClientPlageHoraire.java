package modele;

public class ClientPlageHoraire {
    public static void main(String[] args) {
        Horaire horaire1 = new Horaire(13, 45);
        Horaire horaire2 = new Horaire(12, 2);
        Horaire horaire3 = new Horaire(17, 45);
        Horaire horaire4 = new Horaire(18, 2);
        try {
            PlageHoraire plagehoraire1 = new PlageHoraire(horaire2, horaire1);
            PlageHoraire plagehoraire2 = new PlageHoraire(horaire3, horaire4);
            System.out.println(plagehoraire1);
            System.out.println(plagehoraire2);
            System.out.println(plagehoraire1.estValide());
            System.out.println(plagehoraire2.estValide());
            System.out.println(plagehoraire1.compareTo(plagehoraire2));
        }
        catch (ExceptionPlageHoraire parExecption) {
            System.out.println(parExecption.getMessage());
        }
    }
}