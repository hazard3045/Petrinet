import java.util.ArrayList;
import src.*;

public class TestRM0 {
    
    public static void main(String[] args) {
        TestRM0 test = new TestRM0();
        test.testRM0();
    }
    
    // Test RM0 - Transition multiple cas nominal
    public void testRM0() {
        System.out.println("Test RM0 - Transition multiple cas nominal");
        try {
            Network network = new Network();
            
            // État initial: Transition T, place P1 avec 4 jetons, place P2 avec 2 jetons
            // Arc P1→T poids 2, arc P2→T poids 1
            Place place1 = Place.create_place(4);
            Place place2 = Place.create_place(2);
            Transition transition = Transition.create_transition();
            
            // Arcs entrants
            network.add_edge(place1, transition, 2);
            network.add_edge(place2, transition, 1);
            
            System.out.println("État initial - P1: " + place1.get_tokens() + " jetons, P2: " + place2.get_tokens() + " jetons");
            
            // Vérifier que la transition est tirable
            if (transition.is_fireable()) {
                // Tirer la transition
                transition.fire();
                
                System.out.println("Après tir - P1: " + place1.get_tokens() + " jetons, P2: " + place2.get_tokens() + " jetons");
                
                if (place1.get_tokens() == 2 && place2.get_tokens() == 1) {
                    System.out.println("PASS: P1 a 2 jetons, P2 a 1 jeton");
                } else {
                    System.out.println("FAIL: Résultat incorrect. P1 attendu: 2, obtenu: " + place1.get_tokens() + 
                                     ", P2 attendu: 1, obtenu: " + place2.get_tokens());
                }
            } else {
                System.out.println("FAIL: La transition n'est pas tirable");
            }
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors du test - " + e.getMessage());
        }
    }
}