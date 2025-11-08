package src;
import java.util.ArrayList;

/**
 * Represents an edge in a Petri net, connecting two vertices (input and output) with a specific weight.
 * The edge can modify tokens in places when fired and provides utility methods for Petri net operations.
 *
 * <p>
 * An edge typically connects a Place and a Transition, or vice versa, and is responsible for
 * transferring tokens according to its weight.
 * </p>
 *
 * Fields:
 * <ul>
 *   <li>weight - The number of tokens to transfer when the edge is fired.</li>
 *   <li>output - The output vertex (could be a Place or Transition).</li>
 *   <li>input - The input vertex (could be a Place or Transition).</li>
 * </ul>
 *
 * Methods:
 * <ul>
 *   <li>{@link #modInput()} - Removes tokens from the input place according to the edge's weight.</li>
 *   <li>{@link #modOutput()} - Adds tokens to the output place according to the edge's weight.</li>
 *   <li>{@link #isFireable()} - Checks if the edge can be fired (i.e., if the input place has enough tokens).</li>
 *   <li>{@link #isOutput(Vertex)} - Checks if a given vertex is the output of this edge.</li>
 *   <li>{@link #getWeight()} - Returns the weight of the edge.</li>
 *   <li>{@link #selfDestruct()} - Removes this edge from the input and output vertices' connection lists.</li>
 * </ul>
 */
public class Edge{
    private Integer weight;
    private Vertex output;
    private Vertex input;

    public Edge(int w,Vertex in,Vertex out){
        this.weight = w;
        this.input = in;
        this.output = out;
    }

    public void modInput(){
        if (this.input instanceof Place){
            Place in = (Place) this.input; 
            in.rmTokens(this.weight);
        }
    }

    public void modOutput(){
        if (this.output instanceof Place){
            Place out = (Place) this.output; 
            out.addTokens(this.weight);
        }
    }

    public boolean isFireable(){
        if (this.input instanceof Place){
            Place in = (Place) this.input;
            Integer tokens = in.getTokens();
            if (tokens >= this.weight){
                return true;
            }
            else { return false;}
        }
        else { return true; }
    }

    public boolean isOutput(Vertex v) {
        return v==this.output;
    }

    public Integer getWeight(){
        return this.weight;
    }

    public void selfDestruct(){
        // Remove this edge from the input and output vertices' connection lists
        ArrayList<Edge> conn_in = this.input.getConnexions();
        for (int i=0;i<conn_in.size();i++){
            Edge e = conn_in.get(i);
            if (e==this){
                conn_in.remove(i);
            }
        }
        ArrayList<Edge> conn_out = this.output.getConnexions();
        for (int i=0;i<conn_out.size();i++){
            Edge e = conn_out.get(i);
            if (e==this){
                conn_out.remove(i);
            }
        }
    }

    

    // public String toString(){
    //     String w = String.valueOf(this.weight);
    //     String in = this.input.toString();
    //     String out = this.output.toString();
    //     return "Cet arc a un poids de "+w+"et est relié à "+in+" et "+out;
    // }
}