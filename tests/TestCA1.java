
import src.*;

public class TestCA1 {
    
    public static void main(String[] args) {
        TestCA1 test = new TestCA1();
        test.testCA1();
    }
    
    // Test CA1 - Créer arc avec poids négatif ou nul
    public void testCA1() {
        System.out.println("Test CA1 - Créer arc avec poids négatif ou nul");
        try {
            Network network = new Network();
            Place place = new Place(3);
            Transition transition = new Transition();
            
            // Tentative de création d'arc avec poids nul
            network.addEdge(place, transition, 0);
            
            System.out.println("ATTENTION: Le code permet la création d'arcs avec poids <= 0");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
        
        try {
            Network network = new Network();
            Place place = new Place(3);
            Transition transition = new Transition();
            
            // Tentative de création d'arc avec poids négatif
            network.addEdge(place, transition, -1);
            
            System.out.println("ATTENTION: Le code permet la création d'arcs avec poids négatif");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
}