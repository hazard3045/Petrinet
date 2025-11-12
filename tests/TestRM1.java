import java.util.ArrayList;

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
            Place place1 = Place.create_place(4);
            Place place2 = Place.create_place(2);
            Transition transition = Transition.create_transition();
            
            // Arcs entrants - P2 n'a pas assez de jetons (2 < 3)
            network.add_edge(place1, transition, 2);
            network.add_edge(place2, transition, 3);
            
            System.out.println("État initial - P1: " + place1.get_tokens() + " jetons, P2: " + place2.get_tokens() + " jetons");
            System.out.println("Arcs requis - P1: 2 jetons, P2: 3 jetons");
            
            // Vérifier que la transition n'est pas tirable
            if (!transition.is_fireable()) {
                System.out.println("PASS: Transition correctement identifiée comme non tirable");
                
                // Tentative de tir
                try {
                    transition.fire();
                    System.out.println("ATTENTION: La transition a pu être tirée malgré les jetons insuffisants");
                    System.out.println("Après tir - P1: " + place1.get_tokens() + " jetons, P2: " + place2.get_tokens() + " jetons");
                } catch (Exception fireException) {
                    System.out.println("PASS: Exception levée lors du tir - " + fireException.getMessage());
                }
                
            } else {
                System.out.println("FAIL: Transition incorrectement identifiée comme tirable");
            }
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors du test - " + e.getMessage());
        }
    }
}