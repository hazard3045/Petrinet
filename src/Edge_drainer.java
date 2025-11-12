/**
 * Represents a drainer edge in a Petri net, connecting a Place (input) to a Transition (output).
 * This edge type is responsible for emptying the input Place when fired.
 * 
 * <p>Key behaviors:
 * <ul>
 *   <li>On firing, the input Place is emptied via {@link #modInput()}.</li>
 *   <li>{@link #isFireable()} returns true if the input Place contains more than one token.</li>
 *   <li>{@link #modOutput()} is a no-op for this edge type.</li>
 * </ul>
 * 
 * @see Edge
 * @see Place
 * @see Transition
 */
package src;
public class Edge_drainer extends Edge{
    private Transition output;
    private Place input;

    public Edge_drainer(Place in, Transition out){
        super(0,in,out);
        this.input = in;
        this.output = out;
    }
    
    @Override
    public void modInput(){
        this.input.empty();
    }

    @Override
    public void modOutput(){}

    @Override
    public boolean isFireable(){
        int tok = this.input.getTokens();
        if (tok > 1){
            return true;
        }
        else { 
            return false; 
        }
    }
}