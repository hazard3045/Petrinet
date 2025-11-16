import src.*;

public class TestCAJ1 {
    
    public static void main(String[] args) {
        TestCAJ1 test = new TestCAJ1();
        test.testCAJ1();
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
}