# Petrinet Java Project

This project implements a Petri net simulator in Java. A Petri net is a mathematical modeling language used for the description of distributed systems. The project provides classes to represent the main components of a Petri net, such as Places, Transitions, and Edges, and allows simulation of token flow through the network.

## Features
- **Places**: Hold tokens and represent conditions or resources.
- **Transitions**: Represent events that can occur, changing the distribution of tokens.
- **Edges**: Connect places and transitions, with support for special edge types (zero and drainer edges).
- **Network**: Manages the overall Petri net, including adding/removing places, transitions, and edges, and simulating the firing of transitions.

## Project Structure
- `Place.java`: Defines the Place class, which holds tokens and provides methods to add, remove, or empty tokens.
- `Transition.java`: Defines the Transition class, which can be fired if its input conditions are met.
- `Edge.java`: Base class for edges connecting places and transitions, with a weight property.
- `Edge_0.java`: Special edge type that is fireable only when the input place is empty.
- `Edge_drainer.java`: Special edge type that empties the input place when fired.
- `Vertex.java`: Base class for nodes in the network (places and transitions).
- `Network.java`: Main class managing the Petri net, including all places, transitions, and edges.
- `INetwork.java`: Interface defining the main operations for a Petri net network.

## How to Use
1. **Compile the project**: Ensure all `.java` files are in the same directory or appropriate package structure. Compile using:
   ```bash
   javac src/*.java
   ```
2. **Run the simulation**: Use the `Network` class's `main` method as an entry point. For example:
   ```bash
   java src.Network
   ```
3. **Modify the network**: You can add places, transitions, and edges programmatically using the provided methods in `Network.java`.

## Example
```java
Network net = new Network();
net.addPlace(3); // Add a place with 3 tokens
net.addTransition(); // Add a transition
Place p = net.places.get(0);
Transition t = net.transitions.get(0);
net.addEdge(p, t, 2); // Add an edge from place to transition with weight 2
net.updateTransitionFireable();
net.fireTransitions(t); // Fire the transition if possible
```

## Authors
- Thomas
- Omar

## License
This project is for educational purposes and does not include a specific license.
