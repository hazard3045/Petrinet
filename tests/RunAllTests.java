
import src.*;

/**
 * Lanceur principal pour tous les tests du réseau de Petri
 * Exécute tous les tests selon les spécifications des sections 7.2 et 7.3
 */
public class RunAllTests {
    
    public static void main(String[] args) {
        System.out.println("====================================================================");
        System.out.println("EXÉCUTION DE TOUS LES TESTS DU RÉSEAU DE PETRI");
        System.out.println("====================================================================");
        
        try {
            // Tests de création du réseau (Section 7.2)
            System.out.println("\n" + "=".repeat(60));
            System.out.println("SECTION 7.2 - CRÉATION DU RÉSEAU DE PETRI");
            System.out.println("=".repeat(60));
            
            System.out.println("\n--- Tests de manipulation des jetons et création d'arcs ---");
            TestCreationReseau.main(new String[0]);
            
            System.out.println("\n--- Tests des arcs spéciaux et doublés ---");
            TestArcsSpeciaux.main(new String[0]);
            
            // Tests d'activation du réseau (Section 7.3)
            System.out.println("\n" + "=".repeat(60));
            System.out.println("SECTION 7.3 - ACTIVATION DU RÉSEAU DE PETRI");
            System.out.println("=".repeat(60));
            
            System.out.println("\n--- Tests des transitions simples et multiples ---");
            TestActivationReseau.main(new String[0]);
            
        } catch (Exception e) {
            System.out.println("ERREUR lors de l'exécution des tests: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("EXÉCUTION TERMINÉE");
        System.out.println("=".repeat(60));
        System.out.println("\nRAPPORT:");
        System.out.println("- Tests de jetons (CAJ0-CAJ3): Vérification des manipulations de jetons");
        System.out.println("- Tests d'arcs simples (CA0-CA3): Validation de la création d'arcs");
        System.out.println("- Tests d'arcs spéciaux (CAE0-CAE1, CAV0-CAV1): Arcs zéro et videurs");
        System.out.println("- Tests d'arcs doublés (CAD0-CAD1, UT0-UT1): Gestion des arcs multiples");
        System.out.println("- Tests de transitions (RD0-RD3): Tir de transitions simples");
        System.out.println("- Tests de transitions multiples (RM0-RM1): Entrées multiples");
        System.out.println("\nConsultez la sortie ci-dessus pour les résultats détaillés de chaque test.");
    }
}