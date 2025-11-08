package src;
import java.util.ArrayList;

/**
 * Represents a transition in a Petri net, extending the Vertex class.
 * A Transition can be "fireable" if certain conditions are met, and can "fire" to modify the state of connected edges.
 *
 * <p>
 * Key responsibilities:
 * <ul>
 *   <li>Determines if the transition is fireable based on its input edges.</li>
 *   <li>Fires the transition, updating the state of connected edges accordingly.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Usage:
 * <ul>
 *   <li>Call {@link #isFireable()} to check if the transition can fire.</li>
 *   <li>Call {@link #fire()} to execute the transition if it is fireable.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Note: The actual logic for edge modification and fireability is delegated to the {@code Edge} class.
 * </p>
 */
public class Transition extends Vertex{
    private boolean is_fireable;

    public Transition(){
        super();
        this.is_fireable = false;
    }

    public void fire(){
        // Fire the transition if it is fireable, modifying connected places accordingly
        if (this.is_fireable){
            ArrayList<Edge> connexions = this.getConnexions();
            for (int i=0;i<connexions.size();i++){
                Edge edge = connexions.get(i);
                if(edge.isOutput(this) ){
                    edge.modInput();
                }
                else {
                    edge.modOutput();
                }
            }
        }
        else {
            System.err.println("Transition non tirable");
        }
    }

    public boolean isFireable(){
        // Check all input edges to determine if the transition is fireable
        ArrayList<Edge> connexions = this.getConnexions();
        for (int i=0;i<connexions.size();i++){
            Edge edge = connexions.get(i);
            if (edge.isOutput(this)){
                if (!edge.isFireable()){
                    this.is_fireable = false;
                    return false;
                }
            }
        }
        this.is_fireable = true;
        return true;
    }
}