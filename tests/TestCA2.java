
import src.*;

public class TestCA2 {
    
    public static void main(String[] args) {
        TestCA2 test = new TestCA2();
        test.testCA2();
    }
    
    // Test CA2 - Créer arc avec sommet inexistant
    public void testCA2() {
        System.out.println("Test CA2 - Créer arc avec sommet inexistant");
        try {
            Network network = new Network();
            Place place = new Place(3);
            
            // Tentative de création d'arc avec transition null
            network.addEdge(place, null, 2);
            
            System.out.println("FAIL: Le code devrait lever une exception avec sommet null");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
}