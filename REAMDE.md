# Petri Network Implementation

Implementation of a Petri Network in Java for modeling and simulating discrete event systems.

## Project Structure

- `Vertex.java` - Base class for places and transitions
- `Place.java` - Represents places in the Petri net
- `Transition.java` - Represents transitions in the Petri net
- `Edge.java` - Base class for arcs connecting vertices
- `Edge_0.java` - Zero arcs (inhibitor arcs)
- `Edge_drainer.java` - Drainer arcs (consume all tokens)
- `Network.java` - Main Petri network implementation
- `Petri_Network.java` - High-level network interface
- `Tuple2.java` - Utility class for pairs

## Running Tests

To compile and run the test suite:

```bash
# Compile all Java files
javac *.java

# Compile test files
javac -cp . tests/*.java

# Run all tests
java -cp .:tests RunAllTests
```

## Test Results Summary

The test suite includes comprehensive tests for:

### Token Manipulation (CAJ0-CAJ3)
- **Issues Found**: Allows negative token values
- **Working**: Basic token addition/removal

### Arc Creation (CA0-CA3)
- **Issues Found**: Allows zero/negative weights, same-type vertex connections
- **Working**: Basic arc creation with validation

### Special Arcs (CAE0-CAE1, CAV0-CAV1)
- **Working**: Zero arcs and drainer arcs function correctly

### Transition Firing (RD0-RD3, RM0-RM1)
- **Issues Found**: Token counts not updated after firing, insufficient token validation
- **Working**: Transition firability detection

## Known Issues

1. **Token Management**: Negative tokens allowed
2. **Arc Validation**: Insufficient weight and vertex type validation
3. **Transition Firing**: Token updates not applied correctly
4. **Safety Checks**: Missing validation for Petri net invariants

## Usage

Basic usage example:

```java
// Create network
Network network = new Network();

// Add places and transitions
Place p1 = new Place(5); // Place with 5 tokens
Transition t1 = new Transition();

// Create arcs
Edge arc = new Edge(p1, t1, 2); // Arc with weight 2
```