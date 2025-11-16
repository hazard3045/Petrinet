
import src.*;

public class TestCreationReseau {
    
    public static void main(String[] args) {
        TestCreationReseau tests = new TestCreationReseau();
        
        System.out.println("=== Tests de manipulation des jetons ===");
        tests.testCAJ0();
        tests.testCAJ1();
        tests.testCAJ2();
        tests.testCAJ3();
        
        System.out.println("\n=== Tests de création d'arcs simples ===");
        tests.testCA0();
        tests.testCA1();
        tests.testCA2();
        tests.testCA3();
        
        System.out.println("\nTous les tests de création du réseau terminés.");
    }
    
    // Test CAJ0 - Ajouter jetons avec N négatif
    public void testCAJ0() {
        System.out.println("Test CAJ0 - Ajouter jetons avec N négatif");
        try {
            Place place = new Place(5);
            int initialTokens = place.getTokens();
            
            // Tentative d'ajout de jetons négatifs
            place.addTokens(-3);
            
            // Vérifier que les jetons ont été ajoutés même si négatifs (comportement actuel)
            // Le code actuel ne valide pas les valeurs négatives
            if (place.getTokens() == initialTokens - 3) {
                System.out.println("ATTENTION: Le code permet l'ajout de jetons négatifs!");
                System.out.println("Jetons avant: " + initialTokens + ", après: " + place.getTokens());
            }
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
    
    // Test CAJ1 - Ajouter jetons cas nominal
    public void testCAJ1() {
        System.out.println("Test CAJ1 - Ajouter jetons cas nominal");
        Place place = new Place(5);
        int initialTokens = place.getTokens();
        int tokensToAdd = 3;
        
        place.addTokens(tokensToAdd);
        
        if (place.getTokens() == initialTokens + tokensToAdd) {
            System.out.println("PASS: Jetons ajoutés correctement. " + 
                             initialTokens + " + " + tokensToAdd + " = " + place.getTokens());
        } else {
            System.out.println("FAIL: Nombre de jetons incorrect. Attendu: " + 
                             (initialTokens + tokensToAdd) + ", Obtenu: " + place.getTokens());
        }
    }
    
    // Test CAJ2 - Enlever plus de jetons que disponibles
    public void testCAJ2() {
        System.out.println("Test CAJ2 - Enlever plus de jetons que disponibles");
        Place place = new Place(3);
        int initialTokens = place.getTokens();
        int tokensToRemove = 5;
        
        try {
            place.rmTokens(tokensToRemove);
            
            // Le code actuel permet les jetons négatifs
            if (place.getTokens() < 0) {
                System.out.println("ATTENTION: Le code permet les jetons négatifs!");
                System.out.println("Jetons avant: " + initialTokens + ", après: " + place.getTokens());
            }
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
    
    // Test CAJ3 - Enlever jetons cas nominal
    public void testCAJ3() {
        System.out.println("Test CAJ3 - Enlever jetons cas nominal");
        Place place = new Place(5);
        int initialTokens = place.getTokens();
        int tokensToRemove = 2;
        
        place.rmTokens(tokensToRemove);
        
        if (place.getTokens() == initialTokens - tokensToRemove) {
            System.out.println("PASS: Jetons enlevés correctement. " + 
                             initialTokens + " - " + tokensToRemove + " = " + place.getTokens());
        } else {
            System.out.println("FAIL: Nombre de jetons incorrect. Attendu: " + 
                             (initialTokens - tokensToRemove) + ", Obtenu: " + place.getTokens());
        }
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
    
    // Test CA1 - Créer arc avec poids négatif ou nul
    public void testCA1() {
        System.out.println("Test CA1 - Créer arc avec poids négatif ou nul");
        try {
            Network network = new Network();
            Place place = new Place(3);
            Transition transition = new Transition();
            
            // Tentative de création d'arc avec poids nul
            network.addEdge(place, transition, 0);
            
            System.out.println("ATTENTION: Le code permet la création d'arcs avec poids <= 0");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
        
        try {
            Network network = new Network();
            Place place = new Place(3);
            Transition transition = new Transition();
            
            // Tentative de création d'arc avec poids négatif
            network.addEdge (place, transition, -1);
            
            System.out.println("ATTENTION: Le code permet la création d'arcs avec poids négatif");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
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
    
    // Test CA3 - Créer arc entre sommets de même type
    public void testCA3() {
        System.out.println("Test CA3 - Créer arc entre sommets de même type");
        try {
            Network network = new Network();
            Place place1 = new Place(3);
            Place place2 = new Place(2);
            
            // Tentative de création d'arc entre deux places
            network.addEdge(place1, place2, 2);
            
            System.out.println("ATTENTION: Le code permet la création d'arcs entre sommets de même type");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
        
        try {
            Network network = new Network();
            Transition t1 = new Transition();
            Transition t2 = new Transition();
            
            // Tentative de création d'arc entre deux transitions
            network.addEdge(t1, t2, 2);
            
            System.out.println("ATTENTION: Le code permet la création d'arcs entre transitions");
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
}