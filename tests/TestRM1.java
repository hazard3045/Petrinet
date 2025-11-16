
import src.*;

public class TestRM1 {
    
    public static void main(String[] args) {
        TestRM1 test = new TestRM1();
        test.testRM1();
    }
    
    // Test RM1 - Transition multiple jetons insuffisants
    public void testRM1() {
        System.out.println("Test RM1 - Transition multiple jetons insuffisants");
        try {
            Network network = new Network();
            
            // État initial: Transition T, place P1 avec 4 jetons, place P2 avec 2 jetons
            // Arc P1→T poids 2, arc P2→T poids 3
            Place place1 = new Place(4);
            Place place2 = new Place(2);
            Transition transition = new Transition();
            
            // Arcs entrants - P2 n'a pas assez de jetons (2 < 3)
            network.addEdge(place1, transition, 2);
            network.addEdge(place2, transition, 3);
            
            System.out.println("État initial - P1: " + place1.getTokens() + " jetons, P2: " + place2.getTokens() + " jetons");
            System.out.println("Arcs requis - P1: 2 jetons, P2: 3 jetons");
            
            // Vérifier que la transition n'est pas tirable
            if (!transition.isFireable()) {
                System.out.println("PASS: Transition correctement identifiée comme non tirable");
                
            } else {
                System.out.println("FAIL: Transition incorrectement identifiée comme tirable");
            }
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors du test - " + e.getMessage());
        }
    }
}