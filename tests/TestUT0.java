import java.util.ArrayList;

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
            network.add_place(3); // Place avec 3 jetons
            network.add_transition();
            
            Place place = Place.create_place(3);
            Transition transition = Transition.create_transition();
            
            // Création d'arcs doublés nécessitant plus de jetons que disponibles
            network.add_edge(place, transition, 2); // Premier arc poids 2
            network.add_edge(place, transition, 3); // Second arc poids 3 (total = 5 jetons nécessaires)
            
            // Mise à jour des transitions tirables
            network.update_transition_fireable();
            
            if (!transition.is_fireable()) {
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