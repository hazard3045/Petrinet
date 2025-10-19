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
    
}