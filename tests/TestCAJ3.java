import src.*;

public class TestCAJ3 {
    
    public static void main(String[] args) {
        TestCAJ3 test = new TestCAJ3();
        test.testCAJ3();
    }
    
    // Test CAJ3 - Enlever jetons cas nominal
    public void testCAJ3() {
        System.out.println("Test CAJ3 - Enlever jetons cas nominal");
        Place place = Place.create_place(5);
        int initialTokens = place.get_tokens();
        int tokensToRemove = 2;
        
        place.rm_tokens(tokensToRemove);
        
        if (place.get_tokens() == initialTokens - tokensToRemove) {
            System.out.println("PASS: Jetons enlevés correctement. " + 
                             initialTokens + " - " + tokensToRemove + " = " + place.get_tokens());
        } else {
            System.out.println("FAIL: Nombre de jetons incorrect. Attendu: " + 
                             (initialTokens - tokensToRemove) + ", Obtenu: " + place.get_tokens());
        }
    }
}