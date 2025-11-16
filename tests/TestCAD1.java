
import src.*;

public class TestCAD1 {
    
    public static void main(String[] args) {
        TestCAD1 test = new TestCAD1();
        test.testCAD1();
    }
    
    // Test CAD1 - Créer arc zéro sur arc existant
    public void testCAD1() {
        System.out.println("Test CAD1 - Créer arc zéro sur arc existant");
        try {
            Network network = new Network();
            Place place = new Place(5);
            Transition transition = new Transition();
            
            // Création d'un arc simple
            network.addEdge(place, transition, 2);
            System.out.println("Arc simple créé avec poids 2");
            
            // Tentative de création d'arc zéro sur la même connexion
            network.addEdge_0(place, transition);
            
            System.out.println("ATTENTION: Le code permet la création d'arc zéro sur arc existant");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
}