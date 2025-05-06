package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder( MethodOrderer.OrderAnnotation.class) public class TestHoraire  {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test@Order(1)
    void compareTo() {
        Horaire h1 = new Horaire(5, 30);
        Horaire h2 = new Horaire(7, 30);
        assertTrue(h2.compareTo(h1) > 0, "Test échoué pour a plus grand que b.");
        assertTrue(h1.compareTo(h2) < 0, "Test échoué pour a plus petit que b.");
        Assertions.assertEquals(0, h1.compareTo(h1), "Test échoué pour a égal à b.");
    }

    @org.junit.jupiter.api.Test@Order(2)
    void toMinute() {
        Horaire h1 = new Horaire(5, 30);
        Horaire h2 = new Horaire(7, 0);
        Assertions.assertEquals(330, h1.toMinutes(), "Test échoué pour la méthode toMinute.");
        Assertions.assertEquals(420, h2.toMinutes(), "Test échoué pour la méthode toMinute.");
    }
}