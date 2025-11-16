
import src.*;

public class TestCAJ3 {
    
    public static void main(String[] args) {
        TestCAJ3 test = new TestCAJ3();
        test.testCAJ3();
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
}