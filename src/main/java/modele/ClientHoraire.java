package modele;

public class ClientHoraire {
    public static void main(String[] args) {
        Horaire horaire1 = new Horaire(2, 2);
        System.out.println(horaire1.toMinutes());
        System.out.println(horaire1.getHeure());
        System.out.println(horaire1.getMinutes());
        horaire1.setHeure(5);
        horaire1.setMinutes(6);
        System.out.println(horaire1);
    }
}

