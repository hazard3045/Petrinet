package src;
import java.util.ArrayList;

public class Edge{
    private Integer weight;
    private Vertex output;
    private Vertex input;

    public Edge(int w,Vertex in,Vertex out){
        this.weight = w;
        this.input = in;
        this.output = out;
    }

    public void mod_input(){
        if (this.input instanceof Place){
            Place in = (Place) this.input; 
            in.rm_tokens(this.weight);
        }
    }

    public void mod_output(){
        if (this.output instanceof Place){
            Place out = (Place) this.output; 
            out.add_tokens(this.weight);
        }
    }

    public boolean is_fireable(){
        if (this.input instanceof Place){
            Place in = (Place) this.input;
            Integer tokens = in.get_tokens();
            if (tokens >= this.weight){
                return true;
            }
            else { return false;}
        }
        else { return true; }
    }

    public boolean is_output(Vertex v) {
        return v==this.output;
    }

    public Integer get_weight(){
        return this.weight;
    }

    public void self_destruct(){
        ArrayList<Edge> conn_in = this.input.get_connexions();
        for (int i=0;i<conn_in.size();i++){
            Edge e = conn_in.get(i);
            if (e==this){
                conn_in.remove(i);
            }
        }
        ArrayList<Edge> conn_out = this.output.get_connexions();
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