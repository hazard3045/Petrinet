import java.util.ArrayList;

Interface Petri_Network{
    fire_transitions(Transition);
    add_place(Place);
    rm_place(Place);
    add_transition(Transition);
    rm_transition(Transition);
    add_edge(Edge);
    rm_edge(Edge);
    change_edge(Edge,w,in,out);
    change_token(Place,int);
}

public class Network implements Petri_Network{
    private ArrayList<place> places;
    private ArrayList<Edge> edges;
    private ArrayList<Transition> transitions;
    private ArrayList<Transition> transitions_fireable;

    public Network(){
        this.places = places;
        this.edges = edges;
        this.transitions = transitions;
        this.transitions_fireable = transitions_fireable;
    }

}