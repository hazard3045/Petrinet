import src.*;

public class TestCA0 {
    
    public static void main(String[] args) {
        TestCA0 test = new TestCA0();
        test.testCA0();
    }
    
    // Test CA0 - Créer arc avec poids positif
    public void testCA0() {
        System.out.println("Test CA0 - Créer arc avec poids positif");
        try {
            Network network = new Network();
            network.addPlace(3);
            network.addTransition();
            
            // Récupération des éléments (méthode simplifiée pour les tests)
            Place place = new Place(3);
            Transition transition = new Transition();
            
            // Création d'un arc avec poids positif
            network.addEdge(place, transition, 2);
            
            System.out.println("PASS: Arc créé avec succès entre place et transition");
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors de la création de l'arc - " + e.getMessage());
        }
    }
}