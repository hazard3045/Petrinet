

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
            Place place = new Place(3);
            Transition transition = new Transition();
            
            // Arc entrant nécessitant plus de jetons que disponibles
            network.addEdge(place, transition, 4);
            
            System.out.println("État initial - Place: " + place.getTokens() + " jetons, Arc poids: 4");
            
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