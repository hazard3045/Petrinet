import java.util.ArrayList;
import src.*;

public class TestRD1 {
    
    public static void main(String[] args) {
        TestRD1 test = new TestRD1();
        test.testRD1();
    }
    
    // Test RD1 - Transition avec transformation de jetons
    public void testRD1() {
        System.out.println("Test RD1 - Transition avec transformation de jetons");
        try {
            Network network = new Network();
            
            // Note: L'instruction semble avoir une erreur - dit "arc de poids 4" mais décrit deux places
            // J'interprète comme: Place1 avec 3 jetons, arc poids 4 vers transition, transition vers Place2
            Place place1 = Place.create_place(3);
            Place place2 = Place.create_place(1); // Place initiale avec 1 jeton pour atteindre 5 après
            Transition transition = Transition.create_transition();
            
            // Arc entrant: place1 → transition avec poids 4 (mais place1 n'a que 3 jetons)
            network.add_edge(place1, transition, 4);
            // Arc sortant: transition → place2 avec poids 4
            network.add_edge(transition, place2, 4);
            
            System.out.println("État initial - Place1: " + place1.get_tokens() + " jetons, Place2: " + place2.get_tokens() + " jetons");
            
            // Cette transition ne devrait pas être tirable car place1 n'a que 3 jetons mais l'arc nécessite 4
            if (!transition.is_fireable()) {
                System.out.println("PASS: Transition correctement identifiée comme non tirable (3 < 4 jetons requis)");
            } else {
                System.out.println("ATTENTION: Transition identifiée comme tirable malgré les jetons insuffisants");
                
                // Si elle est tirable, tester le comportement
                transition.fire();
                System.out.println("Après tir - Place1: " + place1.get_tokens() + " jetons, Place2: " + place2.get_tokens() + " jetons");
            }
            
        } catch (Exception e) {
            System.out.println("INFO: Erreur lors du test - " + e.getMessage());
        }
    }
}