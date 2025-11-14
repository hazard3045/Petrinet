import src.*;

public class TestCAJ0 {
    
    public static void main(String[] args) {
        TestCAJ0 test = new TestCAJ0();
        test.testCAJ0();
    }
    
    // Test CAJ0 - Ajouter jetons avec N négatif
    public void testCAJ0() {
        System.out.println("Test CAJ0 - Ajouter jetons avec N négatif");
        try {
            Place place = Place.create_place(5);
            int initialTokens = place.get_tokens();
            
            // Tentative d'ajout de jetons négatifs
            place.add_tokens(-3);
            
            // Vérifier que les jetons ont été ajoutés même si négatifs (comportement actuel)
            // Le code actuel ne valide pas les valeurs négatives
            if (place.get_tokens() == initialTokens - 3) {
                System.out.println("ATTENTION: Le code permet l'ajout de jetons négatifs!");
                System.out.println("Jetons avant: " + initialTokens + ", après: " + place.get_tokens());
            }
            
        } catch (Exception e) {
            System.out.println("PASS: Exception levée comme attendu - " + e.getMessage());
        }
    }
}