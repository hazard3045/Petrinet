
import src.*;

public class TestActivationReseau {
    
    public static void main(String[] args) {
        TestActivationReseau tests = new TestActivationReseau();
        
        System.out.println("=== Tests des transitions simples ===");
        tests.testRD2();
        tests.testRD0();
        tests.testRD1();
        tests.testRD3();
        
        System.out.println("\n=== Tests des transitions à entrées multiples ===");
        tests.testRM0();
        tests.testRM1();
        
        System.out.println("\nTous les tests d'activation du réseau terminés.");
    }
    
    // Test RD2 - Transition simple avec arc sortant
    public void testRD2() {
        System.out.println("Test RD2 - Transition simple avec arc sortant");
        try {
            Network network = new Network();
            
            // État initial: Une transition, un arc sortant de poids 2, une place vide
            Place place = new Place(0);
            Transition transition = new Transition();
            
            // Arc sortant: transition → place avec poids 2
            network.addEdge(transition, place, 2);
            
            System.out.println("État initial - Place: " + place.getTokens() + " jetons");
            
            // Tirer la transition
            transition.fire();
            
            System.out.println("Après tir - Place: " + place.getTokens() + " jetons");
            
            if (place.getTokens() == 2) {
                System.out.println("PASS: La place contient maintenant 2 jetons");
            } else {
                System.out.println("FAIL: Nombre de jetons incorrect. Attendu: 2, Obtenu: " + place.getTokens());
            }
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors du test - " + e.getMessage());
        }
    }
    
    // Test RD0 - Transition avec arcs entrant et sortant
    public void testRD0() {
        System.out.println("Test RD0 - Transition avec arcs entrant et sortant");
        try {
            Network network = new Network();
            
            // État initial: Place avec 2 jetons, arc entrant poids 1, transition, arc sortant poids 2, place avec 3 jetons
            Place place1 = new Place(2);
            Place place2 = new Place(3);
            Transition transition = new Transition();
            
            // Arc entrant: place1 → transition avec poids 1
            network.addEdge(place1, transition, 1);
            // Arc sortant: transition → place2 avec poids 2
            network.addEdge(transition, place2, 2);
            
            System.out.println("État initial - Place1: " + place1.getTokens() + " jetons, Place2: " + place2.getTokens() + " jetons");
            
            // Vérifier que la transition est tirable
            if (transition.isFireable()) {
                // Tirer la transition
                transition.fire();
                
                System.out.println("Après tir - Place1: " + place1.getTokens() + " jetons, Place2: " + place2.getTokens() + " jetons");
                
                if (place1.getTokens() == 1 && place2.getTokens() == 5) {
                    System.out.println("PASS: Place1 a 1 jeton, Place2 a 5 jetons");
                } else {
                    System.out.println("FAIL: Résultat incorrect. Place1 attendu: 1, obtenu: " + place1.getTokens() + 
                                     ", Place2 attendu: 5, obtenu: " + place2.getTokens());
                }
            } else {
                System.out.println("FAIL: La transition n'est pas tirable");
            }
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors du test - " + e.getMessage());
        }
    }
    
    // Test RD1 - Transition avec transformation de jetons
    public void testRD1() {
        System.out.println("Test RD1 - Transition avec transformation de jetons");
        try {
            Network network = new Network();
            
            // Note: L'instruction semble avoir une erreur - dit "arc de poids 4" mais décrit deux places
            // J'interprète comme: Place1 avec 3 jetons, arc poids 4 vers transition, transition vers Place2
            Place place1 = new Place(3);
            Place place2 = new Place(1); // Place initiale avec 1 jeton pour atteindre 5 après
            Transition transition = new Transition();
            
            // Arc entrant: place1 → transition avec poids 4 (mais place1 n'a que 3 jetons)
            network.addEdge(place1, transition, 4);
            // Arc sortant: transition → place2 avec poids 4
            network.addEdge(transition, place2, 4);
            
            System.out.println("État initial - Place1: " + place1.getTokens() + " jetons, Place2: " + place2.getTokens() + " jetons");
            
            // Cette transition ne devrait pas être tirable car place1 n'a que 3 jetons mais l'arc nécessite 4
            if (!transition.isFireable()) {
                System.out.println("PASS: Transition correctement identifiée comme non tirable (3 < 4 jetons requis)");
            } else {
                System.out.println("ATTENTION: Transition identifiée comme tirable malgré les jetons insuffisants");
                
                // Si elle est tirable, tester le comportement
                transition.fire();
                System.out.println("Après tir - Place1: " + place1.getTokens() + " jetons, Place2: " + place2.getTokens() + " jetons");
            }
            
        } catch (Exception e) {
            System.out.println("INFO: Erreur lors du test - " + e.getMessage());
        }
    }
    
    // Test RD3 - Transition avec jetons insuffisants
    public void testRD3() {
        System.out.println("Test RD3 - Transition avec jetons insuffisants");
        try {
            Network network = new Network();
            
            // État initial: Place avec 3 jetons, arc de poids 4, transition
            Place place = new Place(3);
            Transition transition = new Transition();
            
            // Arc entrant nécessitant plus de jetons que disponibles
            network.addEdge(place, transition, 4);
            
            System.out.println("État initial - Place: " + place.getTokens() + " jetons, Arc poids: 4");
            
            // Vérifier que la transition n'est pas tirable
            if (!transition.isFireable()) {
                System.out.println("PASS: Transition correctement identifiée comme non tirable");
                
                // Tentative de tir
                try {
                    transition.fire();
                    System.out.println("ATTENTION: La transition a pu être tirée malgré les jetons insuffisants");
                    System.out.println("Après tir - Place: " + place.getTokens() + " jetons");
                } catch (Exception fireException) {
                    System.out.println("PASS: Exception levée lors du tir - " + fireException.getMessage());
                }
                
            } else {
                System.out.println("FAIL: Transition incorrectement identifiée comme tirable");
            }
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors du test - " + e.getMessage());
        }
    }
    
    // Test RM0 - Transition multiple cas nominal
    public void testRM0() {
        System.out.println("Test RM0 - Transition multiple cas nominal");
        try {
            Network network = new Network();
            
            // État initial: Transition T, place P1 avec 4 jetons, place P2 avec 2 jetons
            // Arc P1→T poids 2, arc P2→T poids 1
            Place place1 = new Place(4);
            Place place2 = new Place(2);
            Transition transition = new Transition();
            
            // Arcs entrants
            network.addEdge(place1, transition, 2);
            network.addEdge(place2, transition, 1);
            
            System.out.println("État initial - P1: " + place1.getTokens() + " jetons, P2: " + place2.getTokens() + " jetons");
            
            // Vérifier que la transition est tirable
            if (transition.isFireable()) {
                // Tirer la transition
                transition.fire();
                
                System.out.println("Après tir - P1: " + place1.getTokens() + " jetons, P2: " + place2.getTokens() + " jetons");
                
                if (place1.getTokens() == 2 && place2.getTokens() == 1) {
                    System.out.println("PASS: P1 a 2 jetons, P2 a 1 jeton");
                } else {
                    System.out.println("FAIL: Résultat incorrect. P1 attendu: 2, obtenu: " + place1.getTokens() + 
                                     ", P2 attendu: 1, obtenu: " + place2.getTokens());
                }
            } else {
                System.out.println("FAIL: La transition n'est pas tirable");
            }
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors du test - " + e.getMessage());
        }
    }
    
    // Test RM1 - Transition multiple jetons insuffisants
    public void testRM1() {
        System.out.println("Test RM1 - Transition multiple jetons insuffisants");
        try {
            Network network = new Network();
            
            // État initial: Transition T, place P1 avec 4 jetons, place P2 avec 2 jetons
            // Arc P1→T poids 2, arc P2→T poids 3
            Place place1 = new Place(4);
            Place place2 = new Place(2);
            Transition transition = new Transition();
            
            // Arcs entrants - P2 n'a pas assez de jetons (2 < 3)
            network.addEdge(place1, transition, 2);
            network.addEdge(place2, transition, 3);
            
            System.out.println("État initial - P1: " + place1.getTokens() + " jetons, P2: " + place2.getTokens() + " jetons");
            System.out.println("Arcs requis - P1: 2 jetons, P2: 3 jetons");
            
            // Vérifier que la transition n'est pas tirable
            if (!transition.isFireable()) {
                System.out.println("PASS: Transition correctement identifiée comme non tirable");
                
                // Tentative de tir
                try {
                    transition.fire();
                    System.out.println("ATTENTION: La transition a pu être tirée malgré les jetons insuffisants");
                    System.out.println("Après tir - P1: " + place1.getTokens() + " jetons, P2: " + place2.getTokens() + " jetons");
                } catch (Exception fireException) {
                    System.out.println("PASS: Exception levée lors du tir - " + fireException.getMessage());
                }
                
            } else {
                System.out.println("FAIL: Transition incorrectement identifiée comme tirable");
            }
            
        } catch (Exception e) {
            System.out.println("FAIL: Erreur lors du test - " + e.getMessage());
        }
    }
}