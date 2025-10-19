import java.util.ArrayList;

public class Transition extends Vertex{
    private boolean is_fireable;

    public Transition(){
        super();
        this.is_fireable = false;
    }

    public static Transition create_transition(){
        Transition t = new Transition();
        return t;
    }
    

    public void fire(){
        if (this.is_fireable){
            ArrayList<Edge> connexions = this.get_connexions();
            for (int i=0;i<connexions.size();i++){
                Edge edge = connexions.get(i);
                if(edge.is_output(this) ){
                    edge.mod_input();
                }
                else {
                    edge.mod_output();
                }
            }
        }
        else {
            // implémenter une levée d'exception pour prog sécuritaire
        }
    }

    public boolean is_fireable(){
        ArrayList<Edge> connexions = this.get_connexions();
        for (int i=0;i<connexions.size();i++){
            Edge edge = connexions.get(i);
            if (edge.is_output(this)){
                if (!edge.is_fireable()){
                    return false;
                }
            }
        }
        return true;
    }
}