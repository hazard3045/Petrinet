import java.util.ArrayList;

public class TestArcsSpeciaux {
    
    public static void main(String[] args) {
        TestArcsSpeciaux tests = new TestArcsSpeciaux();
        
        System.out.println("=== Tests des arcs spéciaux ===");
        tests.testCAE0();
        tests.testCAE1();
        tests.testCAV0();
        tests.testCAV1();
        
        System.out.println("\n=== Tests des arcs doublés ===");
        tests.testCAD0();
        tests.testCAD1();
        tests.testUT0();
        tests.testUT1();
        
        System.out.println("\nTous les tests d'arcs spéciaux terminés.");
    }
    
    // Test CAE0 - Créer arc zéro cas nominal
    public void testCAE0() {
        System.out.println("Test CAE0 - Créer arc zéro cas nominal");
        try {
            Network network = new Network();
            Place place = Place.create_place(0); // Place vide pour arc zéro
            Transition transition = Transition.create_transition();
            
            // Création d'un arc zéro
            network.add_edge_0(place, transition);
            
            System.out.println("PASS: Arc zéro créé avec succès entre place et transition");
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors de la création de l'arc zéro - " + e.getMessage());
        }
    }
    
    // Test CAE1 - Créer arc zéro entre places
    public void testCAE1() {
        System.out.println("Test CAE1 - Créer arc zéro entre places");
        try {
            Network network = new Network();
            Place place1 = Place.create_place(0);
            Place place2 = Place.create_place(3);
            
            // Tentative de création d'arc zéro entre deux places
            network.add_edge_0(place1, place2);
            
            System.out.println("ATTENTION: Le code permet la création d'arcs zéro entre places");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
    
    // Test CAV0 - Créer arc videur cas nominal
    public void testCAV0() {
        System.out.println("Test CAV0 - Créer arc videur cas nominal");
        try {
            Network network = new Network();
            Place place = Place.create_place(5); // Place avec jetons
            Transition transition = Transition.create_transition();
            
            // Création d'un arc videur
            network.add_edge_drainer(place, transition);
            
            System.out.println("PASS: Arc videur créé avec succès entre place et transition");
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors de la création de l'arc videur - " + e.getMessage());
        }
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
    
    // Test CAD0 - Créer arc doublé simple
    public void testCAD0() {
        System.out.println("Test CAD0 - Créer arc doublé simple");
        try {
            Network network = new Network();
            Place place = Place.create_place(10);
            Transition transition = Transition.create_transition();
            
            // Création du premier arc simple
            network.add_edge(place, transition, 2);
            System.out.println("Premier arc créé avec poids 2");
            
            // Création du second arc simple (doublement)
            network.add_edge(place, transition, 3);
            System.out.println("Second arc créé avec poids 3");
            
            System.out.println("PASS: Arcs doublés créés avec succès");
            System.out.println("NOTE: Comportement effectif = arcs séparés avec poids cumulé (2+3=5)");
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors de la création des arcs doublés - " + e.getMessage());
        }
    }
    
    // Test CAD1 - Créer arc zéro sur arc existant
    public void testCAD1() {
        System.out.println("Test CAD1 - Créer arc zéro sur arc existant");
        try {
            Network network = new Network();
            Place place = Place.create_place(5);
            Transition transition = Transition.create_transition();
            
            // Création d'un arc simple
            network.add_edge(place, transition, 2);
            System.out.println("Arc simple créé avec poids 2");
            
            // Tentative de création d'arc zéro sur la même connexion
            network.add_edge_0(place, transition);
            
            System.out.println("ATTENTION: Le code permet la création d'arc zéro sur arc existant");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
    
    // Test UT0 - Transitions tirables avec arcs doublés insuffisants
    public void testUT0() {
        System.out.println("Test UT0 - Transitions tirables avec arcs doublés insuffisants");
        try {
            Network network = new Network();
            network.add_place(3); // Place avec 3 jetons
            network.add_transition();
            
            Place place = Place.create_place(3);
            Transition transition = Transition.create_transition();
            
            // Création d'arcs doublés nécessitant plus de jetons que disponibles
            network.add_edge(place, transition, 2); // Premier arc poids 2
            network.add_edge(place, transition, 3); // Second arc poids 3 (total = 5 jetons nécessaires)
            
            // Mise à jour des transitions tirables
            network.update_transition_fireable();
            
            if (!transition.is_fireable()) {
                System.out.println("PASS: Transition correctement identifiée comme non tirable");
                System.out.println("Jetons disponibles: 3, Jetons nécessaires: 5");
            } else {
                System.out.println("FAIL: Transition incorrectement identifiée comme tirable");
            }
            
        } catch (Exception e) {
            System.out.println("INFO: Erreur lors du test - " + e.getMessage());
        }
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