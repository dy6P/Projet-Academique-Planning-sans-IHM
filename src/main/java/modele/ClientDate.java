package modele;

public class ClientDate {
    public static void main(String[] args) {
        Date date1 = Date.lireDate();
        System.out.println(date1);
        Date date2 = Date.lireDate();
        System.out.println(date2);
        date1.compareTo(date2);
        System.out.println(date2.dateDuLendemain());
        System.out.println(date2.dateDeLaVeille());
    }
}

