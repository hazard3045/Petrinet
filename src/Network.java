package src;
import java.util.ArrayList;

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

    public void add_edge(Vertex A,Vertex B,Integer w) {
        if (A.already_has_edge_spec_to(B) != null){
            System.err.println("Ces deux sommets ont déja un arc de type zéro ou videur entre eux dans ce sens");
        }
        else {
            Edge existing_edge = A.already_has_edge_to(B);
            if (existing_edge != null){
                this.change_edge(existing_edge, w + existing_edge.get_weight(), A, B);
            }
            else{
                Edge e = new Edge (w,A,B);
                this.edges.add(e);
                A.add_connexion(e);
                B.add_connexion(e);
            }
        }
    }

    public void add_edge_0(Vertex A,Vertex B) {
        if (A.already_has_edge_to(B) != null){
            System.err.println("Ces deux sommets ont déja un arc entre eux dans ce sens");
        }
        else {
            if(A instanceof Place && B instanceof Transition){
                Edge_0 e = new Edge_0 ((Place) A,(Transition) B);
                this.edges.add(e);
                A.add_connexion(e);
                B.add_connexion(e);
            }
            else {
                System.err.println("Les sommets n'ont pas les bons types");
            }
        }
    }

    public void add_edge_drainer(Vertex A,Vertex B) {
        if (A.already_has_edge_to(B) != null){
            System.err.println("Ces deux sommets ont déja un arc entre eux dans ce sens");
        }
        else {
            if(A instanceof Place && B instanceof Transition){
                Edge_drainer e = new Edge_drainer((Place) A,(Transition) B);
                this.edges.add(e);
                A.add_connexion(e);
                B.add_connexion(e);
            }
            else {
                System.err.println("Les sommets n'ont pas les bons types");
            }
        }
    }

    public void add_place(Integer nb) {
        Place place = new Place(nb);
        this.places.add(place);
    }

    public void add_transition() {
        Transition transition = new Transition();
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

    public void add_tokens(Place p, Integer nb){
        p.add_tokens(nb);
    }

    public void rm_tokens(Place p, Integer nb){
        p.rm_tokens(nb);
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
        net.add_place(3);
        net.add_place(5);
        net.add_transition();

        Place p1 = net.places.get(0);
        Place p2 = net.places.get(1);
        Transition t1 = net.transitions.get(0);

        net.add_edge(p1, t1, 2); // p1 --(2)--> t1
        net.add_edge(t1, p2, 1); // t1 --(1)--> p2

        System.out.println("Avant tir : p1=" + p1.get_tokens() + ", p2=" + p2.get_tokens());
        net.update_transition_fireable();
        System.out.println("Transitions tirables : " + net.transitions_fireable.contains(t1));
        net.fire_transitions(t1);
        System.out.println("Après tir : p1=" + p1.get_tokens() + ", p2=" + p2.get_tokens());

        // Test edge 0
        Network net0 = new Network();
        net0.add_place(0);
        net0.add_transition();
        Place p0 = net0.places.get(0);
        Transition t0 = net0.transitions.get(0);
        net0.add_edge_0(p0, t0);
        net0.update_transition_fireable();
        System.out.println("Edge 0 tirable : " + net0.transitions_fireable.contains(t0));
        net0.fire_transitions(t0);
        System.out.println("Après tir edge 0 : p0=" + p0.get_tokens());

        // Test edge drainer
        Network netD = new Network();
        netD.add_place(4);
        netD.add_transition();
        Place pd = netD.places.get(0);
        Transition td = netD.transitions.get(0);
        netD.add_edge_drainer(pd, td);
        netD.update_transition_fireable();
        System.out.println("Edge drainer tirable : " + netD.transitions_fireable.contains(td));
        netD.fire_transitions(td);
        System.out.println("Après tir drainer : pd=" + pd.get_tokens());
    }
    
}