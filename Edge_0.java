public class Edge_0 extends Edge{
    private Transition output;
    private Place input;

    public Edge_0 (Place in, Transition out){
        super(0,in,out);
        this.input = in;
        this.output = out;
    }

    @Override
    public boolean is_fireable(){
        return this.input.get_is_empty();
    }

    @Override
    public void mod_input(){}

    @Override
    public void mod_output(){}

}