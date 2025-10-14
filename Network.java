Interface Petri_Network(){
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