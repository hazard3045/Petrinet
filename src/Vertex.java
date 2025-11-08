/**
 * Represents a vertex in a graph or Petri net structure.
 * Each vertex maintains a list of outgoing edges (connexions) to other vertices.
 *
 * Provides methods to add connections, retrieve connections, and check for existing edges to specific vertices.
 */
package src;
import java.util.ArrayList;

public class Vertex {
    private ArrayList<Edge> connexions;

    public Vertex(){
        this.connexions = new ArrayList<Edge>();
    }

    public ArrayList<Edge> getConnexions(){
        return this.connexions;
    }

    public void addConnexion(Edge e){
        this.connexions.add(e);
    }

    public Edge alreadyHasEdgeTo(Vertex V){
        // Check for an existing edge to the given vertex
        for (Edge E:this.connexions){
            if (E.isOutput(V)){
                return E;
            }
        }
        return null;
    }




    public Edge alreadyHasEdgeSpecTo(Vertex V){
        // Check for existing edges of specific types (Edge_0 or Edge_drainer) to the given vertex
        for (Edge E:this.connexions){
            if (E.isOutput(V) && (E instanceof Edge_0 || E instanceof Edge_drainer)){
                return E;
            }
        }
        return null;
    }
    
}