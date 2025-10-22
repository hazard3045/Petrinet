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
        this.rm_edge(e);
        this.add_edge(in, out, w);
    }

    public void change_edge_0(Edge e, Vertex in, Vertex out) {
        this.rm_edge(e);
        this.add_edge_0(in, out);
    }

    public void change_edge_drainer(Edge e, Vertex in, Vertex out) {
        this.rm_edge(e);
        this.add_edge_drainer(in, out);
    }

    public void change_token(Place p, Integer nb) {
        p.set_tokens(nb);
        
    }

    public void rm_edge(Edge T) {
        T.self_destruct();
        ArrayList<Edge> conn = this.edges;
        conn.remove(T);

    }

    public void rm_place(Place p) {
        ArrayList<Edge> conn = new ArrayList<Edge>(p.get_connexions());
        for (Edge e:conn){
            this.rm_edge(e);
        }
        this.places.remove(p);
    }

    public void rm_transition(Transition T) {
        ArrayList<Edge> conn = new ArrayList<Edge>(T.get_connexions());
        for (Edge e:conn){
            this.rm_edge(e);
        }
        this.transitions.remove(T);
    }

    public void print_fireable_transitions() {
        System.out.println("Fireable transitions:");
        for (Transition T:this.transitions_fireable){
            System.out.println(T.toString());
        } 
    }

    public void update_transition_fireable(){
        this.transitions_fireable.clear();
        for (Transition T:this.transitions){
            if (T.is_fireable()){
                this.transitions_fireable.add(T);
            }
        }
    }

    public void fire_transitions(Transition T){
        if (this.transitions_fireable.contains(T)){
            T.fire();
        }
    }

    public static void main(String[] args) {
        
    }
    

    
}