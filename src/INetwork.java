package src;
public interface INetwork{
    void updateTransitionFireable();
    void fireTransitions(Transition T);
    void addPlace(Integer nb);
    void rmPlace(Place p);
    void addTransition();
    void rmTransition(Transition T);
    void addEdge(Vertex A,Vertex B,Integer w);
    void addEdge_0(Vertex A,Vertex B);
    void addEdgeDrainer(Vertex A,Vertex B);
    void rmEdge(Edge T);
    void changeEdge(Edge e,Integer w,Vertex in,Vertex out);
    void addTokens(Place p,Integer nb);
    void rmTokens(Place p,Integer nb);
}