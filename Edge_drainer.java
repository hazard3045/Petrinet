public class Edge_drainer extends Edge{
    private Transition output;
    private Place input;

    public Edge_drainer(Place in, Transition out){
        super(0,in,out);
        this.input = in;
        this.output = out;
    }

    public static Edge_drainer create_edge(Vertex out,Vertex in){
        Edge_drainer e = new Edge_drainer ((Place) in,(Transition) out);
        return e;
    }

    @Override
    public void mod_input(){
        this.input.empty();
    }

    @Override
    public void mod_output(){}

    @Override
    public boolean is_fireable(){
        int tok = this.input.get_tokens();
        if (tok > 1){
            return true;
        }
        else { 
            return false; 
        }
    }
}