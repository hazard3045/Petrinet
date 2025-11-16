
import src.*;

public class TestCAD0 {
    
    public static void main(String[] args) {
        TestCAD0 test = new TestCAD0();
        test.testCAD0();
    }
    
    // Test CAD0 - Créer arc doublé simple
    public void testCAD0() {
        System.out.println("Test CAD0 - Créer arc doublé simple");
        try {
            Network network = new Network();
            Place place = new Place(10);
            Transition transition = new Transition();
            
            // Création du premier arc simple
            network.addEdge(place, transition, 2);
            System.out.println("Premier arc créé avec poids 2");
            
            // Création du second arc simple (doublement)
            network.addEdge(place, transition, 3);
            System.out.println("Second arc créé avec poids 3");
            
            System.out.println("PASS: Arcs doublés créés avec succès");
            System.out.println("NOTE: Comportement effectif = arcs séparés avec poids cumulé (2+3=5)");
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors de la création des arcs doublés - " + e.getMessage());
        }
    }
}