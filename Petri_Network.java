public interface Petri_Network{
    void update_transition_fireable();
    void fire_transitions(Transition T);
    void add_place(Place p);
    void rm_place(Place p);
    void add_transition(Transition T);
    void rm_transition(Transition T);
    void add_edge(Edge T);
    void rm_edge(Edge T);
    void change_edge(Edge e,Integer w,Vertex in,Vertex out);
    void change_token(Place p,Integer nb);
}