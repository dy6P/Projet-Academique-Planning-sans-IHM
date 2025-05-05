package Modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder( MethodOrderer.OrderAnnotation.class) public class TestPlageHoraire  {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test@Order(1)
    void duree() throws ExceptionPlageHoraire {
        try {
            PlageHoraire p1 = new PlageHoraire(new Horaire(5, 30), new Horaire(7, 30));
            Assertions.assertEquals(120, p1.duree(), "Test échoué pour la méthode durée.");
        }
        catch (ExceptionPlageHoraire parExecption) {
        System.out.println(parExecption.getMessage());}
    }

    @org.junit.jupiter.api.Test@Order(2)
    void compareToEgalite() {
        try {
            PlageHoraire p1 = new PlageHoraire(new Horaire(5, 30), new Horaire(7, 30));
            PlageHoraire p2 = new PlageHoraire(new Horaire(5, 30), new Horaire(7, 30));
            Assertions.assertEquals(0, p1.compareTo(p2), "Test échoué pour deux plages horaires à égalité.");
        }
        catch (ExceptionPlageHoraire parExecption) {
        System.out.println(parExecption.getMessage());}
    }

    @org.junit.jupiter.api.Test@Order(3)
    void compareToInclusion() {
        try {
            PlageHoraire p1 = new PlageHoraire(new Horaire(5, 30), new Horaire(7, 30));
            PlageHoraire p2 = new PlageHoraire(new Horaire(5, 30), new Horaire(7, 30));
            Assertions.assertEquals(0, p1.compareTo(p2), "Test échoué pour deux plages horaires à égalité.");
        } catch (ExceptionPlageHoraire parExecption) {
            System.out.println(parExecption.getMessage());}
    }
}
