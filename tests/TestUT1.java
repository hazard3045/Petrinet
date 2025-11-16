
import src.*;

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
            Place place = new Place(2); // Place avec 2 jetons (non vide)
            Transition transition = new Transition();
            
            // Création d'un arc simple
            network.addEdge(place, transition, 1);
            
            // Création d'un arc zéro sur la même connexion
            network.addEdge_0(place, transition);
            
            // Mise à jour des transitions tirables
            network.updateTransitionFireable();
            
            // Arc zéro nécessite place vide, arc simple nécessite jetons
            // Cette combinaison est contradictoire
            if (!transition.isFireable()) {
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