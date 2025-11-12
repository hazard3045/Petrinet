package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;  // pour @Test, @BeforeEach, @Order
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import bad4debug.Place;

@TestMethodOrder(OrderAnnotation.class)
public class PlaceTest {
    private Place p1;
    private Place p2; 

    @BeforeEach 
    void setUp() {
        p1 = new Place(); // default constructor
        p2 = new Place("P1",5); // constructor with tokens


    }

    @Test
    @Order(1)
    void testDefaultConstructor() {
        assertEquals(0, p1.getTokens(), "Default constructor should start with 0 tokens");
        assertNotNull(p1.getName(), "Auto-generated name should not be null");
        assertTrue(p1.getName().startsWith("P_"), "Auto-generated name should start with 'P_'");
    }

    @Test
    @Order(2)
    void testNamedConstructor() {
        assertEquals("P1", p2.getName(), "Constructor should keep the provided name");
        assertEquals(5, p2.getTokens(), "Constructor should keep the provided number of tokens");
    }

    @Test
    @Order(3)
    void testConstructorWithCount() {
        Place place = new Place(-3);
        assertEquals(3, place.getTokens(), "Tokens should use the absolute value");
        assertTrue(place.getName().startsWith("P_"), "Auto-generated name should start with 'P_'");
    }

    @Test
    @Order(4)
    void testGetTokens() {
        p2.addTokens(2);
        assertEquals(7, p2.getTokens(), "getTokens should return the current number of tokens");
    }

    @Test
    @Order(5)
    void testRemoveTokensEnough() {
        p2.removeTokens(3);
        assertEquals(2, p2.getTokens(), "removeTokens should subtract when enough tokens are available");
    }

    @Test
    @Order(6)
    void testRemoveTokensTooMany() {
        p2.removeTokens(99);
        assertEquals(0, p2.getTokens(), "removeTokens should set tokens to 0 when removing too many");
    }

    @Test
    @Order(7)
    void testRemoveTokensNonPositive() {
        p2.removeTokens(0);
        assertEquals(0, p2.getTokens(), "removeTokens should set tokens to 0 when input is non-positive");
    }

    @Test
    @Order(8)
    void testToString() {
        String expected = "Place: " + p2.getName() + " = " + p2.getTokens() + "\n";
        assertEquals(expected, p2.toString(), "toString should follow the 'Place: <name> = <tokens>' format");
    }
}