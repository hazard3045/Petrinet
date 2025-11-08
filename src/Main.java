package src;

public class Main {
    public static void main(String[] args) {
        System.out.println("Programme de test rapide pour Petrinet");

        boolean allOk = true;

        // Exemple de test pour la classe Petrinet (à adapter selon votre implémentation)
        // Supposons que Petrinet a un constructeur sans argument et une méthode getPlaceCount()
        try {
            Petrinet pn = new Petrinet();
            allOk &= test("Nombre de places initial", pn.getPlaceCount(), 0);
        } catch (Exception e) {
            System.out.println("Erreur lors du test de Petrinet : " + e.getMessage());
            allOk = false;
        }

        // Autres tests génériques
        allOk &= test("Addition", 2 + 2, 4);
        allOk &= test("Concaténation", "a" + "b", "ab");
        allOk &= test("Longueur tableau", new int[]{1, 2, 3}.length, 3);
        String maybeNull = null;
        allOk &= test("Vérification null", maybeNull == null, true);

        System.out.println(allOk ? "Tous les tests ont réussi." : "Au moins un test a échoué.");
        // exit avec code d'erreur si un test échoue (utile pour CI)
        System.exit(allOk ? 0 : 1);
    }

    private static boolean test(String name, Object actual, Object expected) {
        boolean pass = (actual == null) ? (expected == null) : actual.equals(expected);
        System.out.printf("%-25s : %s", name, pass ? "OK" : "FAIL");
        if (!pass) {
            System.out.printf(" (attendu=%s, obtenu=%s)", expected, actual);
        }
        System.out.println();
        return pass;
    }
}
