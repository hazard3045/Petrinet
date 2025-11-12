import java.util.ArrayList;

public class TestCAV1 {
    
    public static void main(String[] args) {
        TestCAV1 test = new TestCAV1();
        test.testCAV1();
    }
    
    // Test CAV1 - Créer arc videur entre transitions
    public void testCAV1() {
        System.out.println("Test CAV1 - Créer arc videur entre transitions");
        try {
            Network network = new Network();
            Transition t1 = Transition.create_transition();
            Transition t2 = Transition.create_transition();
            
            // Tentative de création d'arc videur entre deux transitions
            network.add_edge_drainer(t1, t2);
            
            System.out.println("ATTENTION: Le code permet la création d'arcs videurs entre transitions");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
}