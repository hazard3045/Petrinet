import src.*;

public class TestCA3 {
    
    public static void main(String[] args) {
        TestCA3 test = new TestCA3();
        test.testCA3();
    }
    
    // Test CA3 - Créer arc entre sommets de même type
    public void testCA3() {
        System.out.println("Test CA3 - Créer arc entre sommets de même type");
        try {
            Network network = new Network();
            Place place1 = Place.create_place(3);
            Place place2 = Place.create_place(2);
            
            // Tentative de création d'arc entre deux places
            network.add_edge(place1, place2, 2);
            
            System.out.println("ATTENTION: Le code permet la création d'arcs entre sommets de même type");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
        
        try {
            Network network = new Network();
            Transition t1 = Transition.create_transition();
            Transition t2 = Transition.create_transition();
            
            // Tentative de création d'arc entre deux transitions
            network.add_edge(t1, t2, 2);
            
            System.out.println("ATTENTION: Le code permet la création d'arcs entre transitions");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
}