import src.*;

public class TestCAJ1 {
    
    public static void main(String[] args) {
        TestCAJ1 test = new TestCAJ1();
        test.testCAJ1();
    }
    
    // Test CAJ1 - Ajouter jetons cas nominal
    public void testCAJ1() {
        System.out.println("Test CAJ1 - Ajouter jetons cas nominal");
        Place place = Place.create_place(5);
        int initialTokens = place.get_tokens();
        int tokensToAdd = 3;
        
        place.add_tokens(tokensToAdd);
        
        if (place.get_tokens() == initialTokens + tokensToAdd) {
            System.out.println("PASS: Jetons ajoutés correctement. " + 
                             initialTokens + " + " + tokensToAdd + " = " + place.get_tokens());
        } else {
            System.out.println("FAIL: Nombre de jetons incorrect. Attendu: " + 
                             (initialTokens + tokensToAdd) + ", Obtenu: " + place.get_tokens());
        }
    }
}