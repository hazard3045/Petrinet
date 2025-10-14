

public class Edge{
    private Integer weight;
    private Vertex output;
    private Vertex input;

    public Edge(int w,Vertex out,Vertex in){
        this.weight = w;
        this.output = out;
        this.input = in;
    }

    public void get_input(){
        if (this.input instanceof Place){
            Place in = (Place) this.input; 
            in.rm_tokens(this.weight);
        }
    }

    public void get_output(){
        if (this.output instanceof Place){
            Place out = (Place) this.output; 
            out.rm_tokens(this.weight);
        }
    }

    // public String toString(){
    //     String w = String.valueOf(this.weight);
    //     String in = this.input.toString();
    //     String out = this.output.toString();
    //     return "Cet arc a un poids de "+w+"et est relié à "+in+" et "+out;
    // }
}