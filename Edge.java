
public class Edge{
    private Integer weight;
    private Vertex output;
    private Vertex input;

    public Edge(int w,Vertex out,Vertex in){
        this.weight = w;
        this.output = out;
        this.input = in;
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

    

    // public String toString(){
    //     String w = String.valueOf(this.weight);
    //     String in = this.input.toString();
    //     String out = this.output.toString();
    //     return "Cet arc a un poids de "+w+"et est relié à "+in+" et "+out;
    // }
}