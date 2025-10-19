import java.util.ArrayList;

public class Network implements Petri_Network{
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

    public void add_edge(Vertex A,Vertex B,Integer w) {
        Edge e = Edge.create_edge(w, B, A);
        this.edges.add(e);
        A.add_connexion(e);
        B.add_connexion(e);
    }

    public void add_edge_0(Vertex A,Vertex B) {
        Edge_0 e = Edge_0.create_edge(B, A);
        this.edges.add(e);
        A.add_connexion(e);
        B.add_connexion(e);
    }

    public void add_edge_drainer(Vertex A,Vertex B) {
        Edge_drainer e = Edge_drainer.create_edge(B, A);
        this.edges.add(e);
        A.add_connexion(e);
        B.add_connexion(e);
    }

    public void add_place(Integer nb) {
        Place place = Place.create_place(nb);
        this.places.add(place);
    }

    public void add_transition() {
        Transition transition = Transition.create_transition();
        this.transitions.add(transition);
    }

    public void change_edge(Edge e, Integer w, Vertex in, Vertex out) {
        // TODO Auto-generated method stub
        
    }

    public void change_token(Place p, Integer nb) {
        // TODO Auto-generated method stub
        
    }
  
    public void fire_transitions(Transition T) {
        // TODO Auto-generated method stub
        
    }

    public void rm_edge(Edge T) {
        // TODO Auto-generated method stub
        
    }

    public void rm_place(Place p) {
        // TODO Auto-generated method stub
        
    }

    public void rm_transition(Transition T) {
        // TODO Auto-generated method stub
        
    }


    public void update_transition_fireable(){
    }

    public void fire_transitions(){}

    public static void main(String[] args){
        Network network = new Network();

        // Adding places
        network.add_place(5);
        network.add_place(10);

        // Adding transitions
        network.add_transition();
        network.add_transition();

        // Creating vertices for edges
        Place place1 = network.places.get(0);
        Place place2 = network.places.get(1);
        Transition transition1 = network.transitions.get(0);
        Transition transition2 = network.transitions.get(1);

        // Adding edges
        network.add_edge(place1, transition1, 3);
        network.add_edge(transition1, place2, 2);
        network.add_edge_0(place2, transition2);
        network.add_edge_drainer(place2, transition1);

        // Print to verify
        System.out.println("Places: " + network.places.size());
        System.out.println("Transitions: " + network.transitions.size());
        System.out.println("Edges: " + network.edges.size());
    }

    
}