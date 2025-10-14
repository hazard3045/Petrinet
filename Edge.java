

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
        this.input.rm_tokens(this.weight);
    }

    public void get_output(){
        this.output.add_tokens(this.weight);
    }

    public String toString(){
        String w = String.valueOf(this.weight);
        String 
        return res
    }
}