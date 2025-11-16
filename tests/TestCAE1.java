
import src.*;

public class TestCAE1 {
    
    public static void main(String[] args) {
        TestCAE1 test = new TestCAE1();
        test.testCAE1();
    }
    
    // Test CAE1 - Créer arc zéro entre places
    public void testCAE1() {
        System.out.println("Test CAE1 - Créer arc zéro entre places");
        try {
            Network network = new Network();
            Place place1 = new Place(0);
            Place place2 = new Place(3);
            
            // Tentative de création d'arc zéro entre deux places
            network.addEdge_0(place1, place2);
            
            System.out.println("ATTENTION: Le code permet la création d'arcs zéro entre places");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
}