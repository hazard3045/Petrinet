import java.util.ArrayList;
import src.*;

public class TestRD3 {
    
    public static void main(String[] args) {
        TestRD3 test = new TestRD3();
        test.testRD3();
    }
    
    // Test RD3 - Transition avec jetons insuffisants
    public void testRD3() {
        System.out.println("Test RD3 - Transition avec jetons insuffisants");
        try {
            Network network = new Network();
            
            // État initial: Place avec 3 jetons, arc de poids 4, transition
            Place place = Place.create_place(3);
            Transition transition = Transition.create_transition();
            
            // Arc entrant nécessitant plus de jetons que disponibles
            network.add_edge(place, transition, 4);
            
            System.out.println("État initial - Place: " + place.get_tokens() + " jetons, Arc poids: 4");
            
            // Vérifier que la transition n'est pas tirable
            if (!transition.is_fireable()) {
                System.out.println("PASS: Transition correctement identifiée comme non tirable");
                
                // Tentative de tir
                try {
                    transition.fire();
                    System.out.println("ATTENTION: La transition a pu être tirée malgré les jetons insuffisants");
                    System.out.println("Après tir - Place: " + place.get_tokens() + " jetons");
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