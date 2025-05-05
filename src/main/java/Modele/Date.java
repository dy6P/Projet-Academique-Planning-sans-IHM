package Modele;

import java.util.Scanner;

public class Date implements Comparable <Date> {
    protected int chJour;
    protected int chMois;
    protected int chAnnee;

    public Date(int parJour, int parMois, int parAnnee) {
        chJour = parJour;
        chMois = parMois;
        chAnnee = parAnnee;
    }

    public Date(int parAnnee) {
        chJour = 1;
        chMois = 1;
        chAnnee = parAnnee;
    }

    public static boolean estAnneeBiss(int parAn) {
        return parAn >= 1583 && (parAn%4 == 0 && parAn%100 != 0 ^ parAn%400 == 0);
    }

    public static int dernierJourMois(int parAnnee, int parMois) {
        switch (parMois) {
            case 2:
                if (Date.estAnneeBiss(parAnnee)) {
                    return 29;
                }
                else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return 31;
    }

    public static Date lireDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez la date de votre choix.");
        while (true) {
            System.out.print("Entrez le jour : ");
            int parJour = scanner.nextInt();
            System.out.print("Entrez le mois : ");
            int parMois = scanner.nextInt();
            System.out.print("Entrez l'année : ");
            int parAnnee = scanner.nextInt();
            Date date = new Date(parJour, parMois, parAnnee);
            if (date.estValide()) {
                System.out.println("La date est valide.");
                return date;
            }
            System.out.println("La date n'est pas valide.");
        }
    }

    public int compareTo(Date parDate) {
        int date1 = chAnnee * 10000 + chMois * 100 + chJour;
        int date2 = parDate.chAnnee * 10000 + parDate.chMois * 100 + parDate.chJour;
        int difference = date1 - date2;
        if (difference > 0){
            return 1;
        }
        else if (difference < 0){
            return -1;
        }
        return 0;
    }

    public Date dateDuLendemain() {
        int jour = chJour;
        int mois = chMois;
        int annee = chAnnee;
        if (jour >= dernierJourMois(annee, mois) && mois >= 12) {
            jour = 1;
            mois = 1;
            annee++;
        }
        else if (jour >= dernierJourMois(annee, mois)) {
            jour = 1;
            mois++;
        }
        else {
            jour++;
        }
        return new Date(jour, mois, annee);
    }

    public Date dateDeLaVeille() {
        int jour = chJour;
        int mois = chMois;
        int annee = chAnnee;
        if (jour == 1 && mois == 1) {
            annee--;
            mois = 12;
            jour = dernierJourMois(annee, mois);
        }
        else if (jour == 1) {
            mois--;
            jour = dernierJourMois(annee, mois);
        }
        else {
            jour--;
        }
        return new Date(jour, mois, annee);
    }

    public boolean estValide() {
        if (chJour > 0 && chMois > 0 && chMois < 13) {
            int dernierJourMois = dernierJourMois(chJour, chMois);
            return chJour <= dernierJourMois;
        }
        return false;
    }

    public int getJour() {
        return chJour;
    }

    public int getMois() {
        return chMois;
    }

    public int getAnnee() {
        return chAnnee;
    }

    public void setJour(int parJour) {
        chJour = parJour;
    }

    public void setMois(int parMois) { chMois = parMois; }

    public void setAnnee(int parAnnee) { chAnnee = parAnnee; }

    public String toString() {
        return chJour + "/" + chMois + "/" + chAnnee;
    }
}