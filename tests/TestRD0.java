
import src.*;

public class TestRD0 {
    
    public static void main(String[] args) {
        TestRD0 test = new TestRD0();
        test.testRD0();
    }
    
    // Test RD0 - Transition avec arcs entrant et sortant
    public void testRD0() {
        System.out.println("Test RD0 - Transition avec arcs entrant et sortant");
        try {
            Network network = new Network();
            
            // État initial: Place avec 2 jetons, arc entrant poids 1, transition, arc sortant poids 2, place avec 3 jetons
            Place place1 = new Place(2);
            Place place2 = new Place(3);
            Transition transition = new Transition();
            
            // Arc entrant: place1 → transition avec poids 1
            network.addEdge(place1, transition, 1);
            // Arc sortant: transition → place2 avec poids 2
            network.addEdge(transition, place2, 2);
            
            System.out.println("État initial - Place1: " + place1.getTokens() + " jetons, Place2: " + place2.getTokens() + " jetons");
            
            // Vérifier que la transition est tirable
            if (transition.isFireable()) {
                // Tirer la transition
                transition.fire();
                
                System.out.println("Après tir - Place1: " + place1.getTokens() + " jetons, Place2: " + place2.getTokens() + " jetons");
                
                if (place1.getTokens() == 1 && place2.getTokens() == 5) {
                    System.out.println("PASS: Place1 a 1 jeton, Place2 a 5 jetons");
                } else {
                    System.out.println("FAIL: Résultat incorrect. Place1 attendu: 1, obtenu: " + place1.getTokens() + 
                                     ", Place2 attendu: 5, obtenu: " + place2.getTokens());
                }
            } else {
                System.out.println("FAIL: La transition n'est pas tirable");
            }
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors du test - " + e.getMessage());
        }
    }
}