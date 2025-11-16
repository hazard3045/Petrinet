
import src.*;

public class TestUT0 {
    
    public static void main(String[] args) {
        TestUT0 test = new TestUT0();
        test.testUT0();
    }
    
    // Test UT0 - Transitions tirables avec arcs doublés insuffisants
    public void testUT0() {
        System.out.println("Test UT0 - Transitions tirables avec arcs doublés insuffisants");
        try {
            Network network = new Network();
            network.addPlace(3); // Place avec 3 jetons
            network.addTransition();
            
            Place place = new Place(3);
            Transition transition = new Transition();
            
            // Création d'arcs doublés nécessitant plus de jetons que disponibles
            network.addEdge(place, transition, 2); // Premier arc poids 2
            network.addEdge(place, transition, 3); // Second arc poids 3 (total = 5 jetons nécessaires)
            
            // Mise à jour des transitions tirables
            network.updateTransitionFireable();
            
            if (!transition.isFireable()) {
                System.out.println("PASS: Transition correctement identifiée comme non tirable");
                System.out.println("Jetons disponibles: 3, Jetons nécessaires: 5");
            } else {
                System.out.println("FAIL: Transition incorrectement identifiée comme tirable");
            }
            
        } catch (Exception e) {
            System.out.println("INFO: Erreur lors du test - " + e.getMessage());
        }
    }
}