import java.util.ArrayList;
import src.*;

public class TestCAE0 {
    
    public static void main(String[] args) {
        TestCAE0 test = new TestCAE0();
        test.testCAE0();
    }
    
    // Test CAE0 - Créer arc zéro cas nominal
    public void testCAE0() {
        System.out.println("Test CAE0 - Créer arc zéro cas nominal");
        try {
            Network network = new Network();
            Place place = Place.create_place(0); // Place vide pour arc zéro
            Transition transition = Transition.create_transition();
            
            // Création d'un arc zéro
            network.add_edge_0(place, transition);
            
            System.out.println("PASS: Arc zéro créé avec succès entre place et transition");
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors de la création de l'arc zéro - " + e.getMessage());
        }
    }
}