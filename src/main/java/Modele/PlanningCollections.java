package Modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class PlanningCollections {
    private ArrayList <Reservation> chListe;
    private TreeSet <Reservation> chSet;
    private TreeMap <Integer, TreeSet <Reservation>> chTreeMap;

    public PlanningCollections() {
        chListe = new ArrayList <> ();
        chSet = new TreeSet <> ();
        chTreeMap = new TreeMap <> ();
    }

    public void ajout(Reservation parReservation) {
        chListe.add(parReservation);
        chSet.add(parReservation);
        int numSem = parReservation.getDateCalendrier().getchNumSem();
        if (chTreeMap.containsKey(numSem)) {
            chTreeMap.get(numSem).add(parReservation);
        }
        else {
            TreeSet <Reservation> valeurs = new TreeSet <> ();
            valeurs.add(parReservation);
            chTreeMap.put(numSem, valeurs);
        }
    }

    public String toString() {
        return "Taille de la liste : " + chListe.size() + "\nContenu de la liste : " + chListe + "\nTaille du set : " + chSet.size() + "\nContenu du set : " + chSet + "\nTaille du dictionnaire : " + chTreeMap.size() + "\nContenu du dictionnaire : " + chTreeMap ;
    }

    public TreeSet <Reservation> getReservations(DateCalendrier parDateCalendrier) {
        TreeSet <Reservation> retour = new TreeSet <> ();
        Iterator <Reservation> iterateur = chSet.iterator();
        while (iterateur.hasNext()) {
            Reservation actuelle = iterateur.next();
            if (actuelle.getDateCalendrier().compareTo(parDateCalendrier) == 0) {
                retour.add(actuelle);
            }
        }
        return retour;
    }

    public TreeSet <Reservation> getReservations(String parString) {
        TreeSet <Reservation> retour = new TreeSet <> ();
        Iterator <Reservation> iterateur = chSet.iterator();
        while (iterateur.hasNext()) {
            Reservation actuelle = iterateur.next();
            if (actuelle.getIntitule().equals(parString)) {
                retour.add(actuelle);
            }
        }
        return retour;
    }
}
