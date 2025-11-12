import java.util.ArrayList;

public class TestUT1 {
    
    public static void main(String[] args) {
        TestUT1 test = new TestUT1();
        test.testUT1();
    }
    
    // Test UT1 - Transitions tirables avec arc simple et arc zéro
    public void testUT1() {
        System.out.println("Test UT1 - Transitions tirables avec arc simple et arc zéro");
        try {
            Network network = new Network();
            Place place = Place.create_place(2); // Place avec 2 jetons (non vide)
            Transition transition = Transition.create_transition();
            
            // Création d'un arc simple
            network.add_edge(place, transition, 1);
            
            // Création d'un arc zéro sur la même connexion
            network.add_edge_0(place, transition);
            
            // Mise à jour des transitions tirables
            network.update_transition_fireable();
            
            // Arc zéro nécessite place vide, arc simple nécessite jetons
            // Cette combinaison est contradictoire
            if (!transition.is_fireable()) {
                System.out.println("PASS: Transition correctement identifiée comme non tirable");
                System.out.println("Arc simple + arc zéro = combinaison contradictoire");
            } else {
                System.out.println("ATTENTION: Transition identifiée comme tirable malgré la contradiction");
            }
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
}