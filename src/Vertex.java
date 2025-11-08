package src;
import java.util.ArrayList;

public class Vertex {
    private ArrayList<Edge> connexions;

    public Vertex(){
        this.connexions = new ArrayList<Edge>();
    }

    public ArrayList<Edge> get_connexions(){
        return this.connexions;
    }

    public void add_connexion(Edge e){
        this.connexions.add(e);
    }

    public Edge already_has_edge_to(Vertex V){
        for (Edge E:this.connexions){
            if (E.is_output(V)){
                return E;
            }
        }
        return null;
    }



    public Edge already_has_edge_spec_to(Vertex V){
        for (Edge E:this.connexions){
            if (E.is_output(V) && (E instanceof Edge_0 || E instanceof Edge_drainer)){
                return E;
            }
        }
        return null;
    }
    
}