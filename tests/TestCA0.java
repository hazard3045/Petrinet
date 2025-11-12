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
            network.add_place(3);
            network.add_transition();
            
            // Récupération des éléments (méthode simplifiée pour les tests)
            Place place = Place.create_place(3);
            Transition transition = Transition.create_transition();
            
            // Création d'un arc avec poids positif
            network.add_edge(place, transition, 2);
            
            System.out.println("PASS: Arc créé avec succès entre place et transition");
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors de la création de l'arc - " + e.getMessage());
        }
    }
}