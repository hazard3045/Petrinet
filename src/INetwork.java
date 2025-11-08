package src;
public interface INetwork{
    void update_transition_fireable();
    void fire_transitions(Transition T);
    void add_place(Integer nb);
    void rm_place(Place p);
    void add_transition();
    void rm_transition(Transition T);
    void add_edge(Vertex A,Vertex B,Integer w);
    void add_edge_0(Vertex A,Vertex B);
    void add_edge_drainer(Vertex A,Vertex B);
    void rm_edge(Edge T);
    void change_edge(Edge e,Integer w,Vertex in,Vertex out);
    void add_tokens(Place p,Integer nb);
    void rm_tokens(Place p,Integer nb);
}