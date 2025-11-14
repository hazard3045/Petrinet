import java.util.ArrayList;
import src.*;

public class TestRD2 {
    
    public static void main(String[] args) {
        TestRD2 test = new TestRD2();
        test.testRD2();
    }
    
    // Test RD2 - Transition simple avec arc sortant
    public void testRD2() {
        System.out.println("Test RD2 - Transition simple avec arc sortant");
        try {
            Network network = new Network();
            
            // État initial: Une transition, un arc sortant de poids 2, une place vide
            Place place = Place.create_place(0);
            Transition transition = Transition.create_transition();
            
            // Arc sortant: transition → place avec poids 2
            network.add_edge(transition, place, 2);
            
            System.out.println("État initial - Place: " + place.get_tokens() + " jetons");
            
            // Tirer la transition
            transition.fire();
            
            System.out.println("Après tir - Place: " + place.get_tokens() + " jetons");
            
            if (place.get_tokens() == 2) {
                System.out.println("PASS: La place contient maintenant 2 jetons");
            } else {
                System.out.println("FAIL: Nombre de jetons incorrect. Attendu: 2, Obtenu: " + place.get_tokens());
            }
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors du test - " + e.getMessage());
        }
    }
}