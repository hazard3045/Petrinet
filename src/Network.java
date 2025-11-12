package src;
import java.util.ArrayList;

/**
 * The {@code Network} class represents a Petri net structure, managing places, transitions, and edges.
 * It provides methods to add and remove places, transitions, and different types of edges (normal, zero, drainer),
 * as well as to manipulate tokens and fire transitions according to Petri net semantics.
 * <p>
 * The class maintains lists of all places, transitions, edges, and currently fireable transitions.
 * It supports updating the set of fireable transitions and firing them if possible.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     Network net = new Network();
 *     net.addPlace(3);
 *     net.addTransition();
 *     Place p = net.places.get(0);
 *     Transition t = net.transitions.get(0);
 *     net.addEdge(p, t, 2);
 *     net.updateTransitionFireable();
 *     net.fireTransitions(t);
 * </pre>
 * </p>
 *
 * <p>
 * This class assumes the existence of supporting classes/interfaces:
 * <ul>
 *   <li>{@code INetwork}</li>
 *   <li>{@code Place}</li>
 *   <li>{@code Transition}</li>
 *   <li>{@code Edge}, {@code Edge_0}, {@code Edge_drainer}</li>
 *   <li>{@code Vertex}</li>
 * </ul>
 * </p>
 *
 * @author thomas,omar
 */

public class Network implements INetwork{
    private ArrayList<Place> places;
    private ArrayList<Edge> edges;
    private ArrayList<Transition> transitions;
    private ArrayList<Transition> transitions_fireable;

    public Network(){
        this.places = new ArrayList<Place>();
        this.edges = new ArrayList<Edge>();
        this.transitions = new ArrayList<Transition>();
        this.transitions_fireable = new ArrayList<Transition>();
    }

    public void addEdge(Vertex A,Vertex B,Integer w) {
        // Check for existing edges of type 0 or drainer
        if (A.alreadyHasEdgeSpecTo(B) != null){
            System.err.println("Ces deux sommets ont déja un arc de type zéro ou videur entre eux dans ce sens");
        }
        else {
            // Check for existing normal edges, if found, update weight
            Edge existing_edge = A.alreadyHasEdgeTo(B);
            if (existing_edge != null){
                this.changeEdge(existing_edge, w + existing_edge.getWeight(), A, B);
            }
            else{
                Edge e = new Edge (w,A,B);
                this.edges.add(e);
                A.addConnexion(e);
                B.addConnexion(e);
            }
        }
    }

    public void addEdge_0(Vertex A,Vertex B) {
        // Check for existing edges, an edge 0 cannot coexist with other edges between the same vertices
        if (A.alreadyHasEdgeTo(B) != null){
            System.err.println("Ces deux sommets ont déja un arc entre eux dans ce sens");
        }
        else {
            if(A instanceof Place && B instanceof Transition){
                Edge_0 e = new Edge_0 ((Place) A,(Transition) B);
                this.edges.add(e);
                A.addConnexion(e);
                B.addConnexion(e);
            }
            else {
                System.err.println("Les sommets n'ont pas les bons types");
            }
        }
    }

    public void addEdgeDrainer(Vertex A,Vertex B) {
        // Check for existing edges, an edge drainer cannot coexist with other edges between the same vertices
        if (A.alreadyHasEdgeTo(B) != null){
            System.err.println("Ces deux sommets ont déja un arc entre eux dans ce sens");
        }
        else {
            if(A instanceof Place && B instanceof Transition){
                Edge_drainer e = new Edge_drainer((Place) A,(Transition) B);
                this.edges.add(e);
                A.addConnexion(e);
                B.addConnexion(e);
            }
            else {
                System.err.println("Les sommets n'ont pas les bons types");
            }
        }
    }

    public void addPlace(Integer nb) {
        Place place = new Place(nb);
        this.places.add(place);
    }

    public void addTransition() {
        Transition transition = new Transition();
        this.transitions.add(transition);
    }

    public void changeEdge(Edge e, Integer w, Vertex in, Vertex out) {
        this.rmEdge(e);
        this.addEdge(in, out, w);
    }

    public void changeEdge_0(Edge e, Vertex in, Vertex out) {
        this.rmEdge(e);
        this.addEdge_0(in, out);
    }

    public void changeEdgeDrainer(Edge e, Vertex in, Vertex out) {
        this.rmEdge(e);
        this.addEdgeDrainer(in, out);
    }

    public void addTokens(Place p, Integer nb){
        p.addTokens(nb);
    }

    public void rmTokens(Place p, Integer nb){
        p.rmTokens(nb);
    }

    public void rmEdge(Edge T) {
        T.selfDestruct();
        ArrayList<Edge> conn = this.edges;
        conn.remove(T);

    }

    public void rmPlace(Place p) {
        ArrayList<Edge> conn = new ArrayList<Edge>(p.getConnexions());
        for (Edge e:conn){
            this.rmEdge(e);
        }
        this.places.remove(p);
    }

    public void rmTransition(Transition T) {
        ArrayList<Edge> conn = new ArrayList<Edge>(T.getConnexions());
        for (Edge e:conn){
            this.rmEdge(e);
        }
        this.transitions.remove(T);
    }

    public void printFireableTransitions() {
        System.out.println("Fireable transitions:");
        for (Transition T:this.transitions_fireable){
            System.out.println(T.toString());
        } 
    }

    public void updateTransitionFireable(){
        this.transitions_fireable.clear();
        for (Transition T:this.transitions){
            if (T.isFireable()){
                this.transitions_fireable.add(T);
            }
        }
    }

    public void fireTransitions(Transition T){
        if (this.transitions_fireable.contains(T)){
            T.fire();
        }
    }

    public static void main(String[] args){
        // Network net = new Network();

        // // Ajout de 2 places avec 3 et 5 jetons
        // net.add_place(3);
        // net.add_place(5);

        // // Ajout de 1 transition
        // net.add_transition();

        // // Récupération des objets pour manipuler
        // Place p1 = net.places.get(0);
        // Place p2 = net.places.get(1);
        // Transition t1 = net.transitions.get(0);

        // // Ajout d'arcs entre les places et la transition
        // net.add_edge(p1, t1, 2); // p1 --(2)--> t1
        // net.add_edge(t1, p2, 1); // t1 --(1)--> p2

        // // Affichage des jetons avant tir
        // System.out.println("Avant tir :");
        // System.out.println("Place 1 tokens: " + p1.get_tokens());
        // System.out.println("Place 2 tokens: " + p2.get_tokens());

        // // Mise à jour et affichage des transitions tirables
        // net.update_transition_fireable();
        // net.print_fireable_transitions();

        // // Tir de la transition si possible
        // if (!net.transitions_fireable.isEmpty()) {
        //     net.fire_transitions(t1);
        // }
        // else {
        //     System.out.println("Aucune transition tirable.");
        // }

        // // Affichage des jetons après tir
        // System.out.println("Après tir :");
        // System.out.println("Place 1 tokens: " + p1.get_tokens());
        // System.out.println("Place 2 tokens: " + p2.get_tokens());
        
            // Test basique
        Network net = new Network();
        net.addPlace(3);
        net.addPlace(5);
        net.addTransition();

        Place p1 = net.places.get(0);
        Place p2 = net.places.get(1);
        Transition t1 = net.transitions.get(0);

        net.addEdge(p1, t1, 2); // p1 --(2)--> t1
        net.addEdge(t1, p2, 1); // t1 --(1)--> p2

        System.out.println("Avant tir : p1=" + p1.getTokens() + ", p2=" + p2.getTokens());
        net.updateTransitionFireable();
        System.out.println("Transitions tirables : " + net.transitions_fireable.contains(t1));
        net.fireTransitions(t1);
        System.out.println("Après tir : p1=" + p1.getTokens() + ", p2=" + p2.getTokens());

        // Test edge 0
        Network net0 = new Network();
        net0.addPlace(0);
        net0.addTransition();
        Place p0 = net0.places.get(0);
        Transition t0 = net0.transitions.get(0);
        net0.addEdge_0(p0, t0);
        net0.updateTransitionFireable();
        System.out.println("Edge 0 tirable : " + net0.transitions_fireable.contains(t0));
        net0.fireTransitions(t0);
        System.out.println("Après tir edge 0 : p0=" + p0.getTokens());

        // Test edge drainer
        Network netD = new Network();
        netD.addPlace(4);
        netD.addTransition();
        Place pd = netD.places.get(0);
        Transition td = netD.transitions.get(0);
        netD.addEdgeDrainer(pd, td);
        netD.updateTransitionFireable();
        System.out.println("Edge drainer tirable : " + netD.transitions_fireable.contains(td));
        netD.fireTransitions(td);
        System.out.println("Après tir drainer : pd=" + pd.getTokens());
    }
    
}