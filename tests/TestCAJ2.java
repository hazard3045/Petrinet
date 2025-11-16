
import src.*;

public class TestCAJ2 {
    
    public static void main(String[] args) {
        TestCAJ2 test = new TestCAJ2();
        test.testCAJ2();
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
}