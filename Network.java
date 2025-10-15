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

    public void add_edge(Edge T) {
        // TODO Auto-generated method stub
        
    }

    public void add_place(Place p) {
        // TODO Auto-generated method stub
        
    }

    public void add_transition(Transition T) {
        // TODO Auto-generated method stub
        
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

    
}