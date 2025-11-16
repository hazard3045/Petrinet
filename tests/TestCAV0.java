
import src.*;

public class TestCAV0 {
    
    public static void main(String[] args) {
        TestCAV0 test = new TestCAV0();
        test.testCAV0();
    }
    
    // Test CAV0 - Créer arc videur cas nominal
    public void testCAV0() {
        System.out.println("Test CAV0 - Créer arc videur cas nominal");
        try {
            Network network = new Network();
            Place place = new Place(5); // Place avec jetons
            Transition transition = new Transition();
            
            // Création d'un arc videur
            network.addEdgeDrainer(place, transition);
            
            System.out.println("PASS: Arc videur créé avec succès entre place et transition");
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors de la création de l'arc videur - " + e.getMessage());
        }
    }
}