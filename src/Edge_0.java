/**
 * Represents an edge of type 0 in a Petri net, connecting a Place (input) to a Transition (output).
 * This edge type is fireable only when the input Place is empty.
 * 
 * <p>
 * The {@code Edge_0} class extends the {@link Edge} class and overrides its methods to define
 * the specific behavior for this edge type.
 * </p>
 *
 * @see Edge
 * @see Place
 * @see Transition
 */
package src;
public class Edge_0 extends Edge{
    private Transition output;
    private Place input;

    public Edge_0 (Place in, Transition out){
        super(0,in,out);
        this.input = in;
        this.output = out;
    }

    @Override
    public boolean isFireable(){
        return this.input.isEmpty();
    }

    @Override
    public void modInput(){}

    @Override
    public void modOutput(){}

}