

public class Edge{
    private Integer weight;
    private Vertex output;
    private Vertex input;

    public Edge(int w,Vertex out,Vertex in){
        this.weight = w;
        this.output = out;
        this.input = in;
    }

    public Tuple2<Vertex,Integer> get_inputs(){
      
    }
}