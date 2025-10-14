public class Transition extends Vertex{
    private boolean is_fireable;

    public Transition(boolean is_fireable){
        super();
        this.is_fireable = is_fireable;
    }
    

    public void fire(){
    }

    public boolean is_fireable(){
        return is_fireable;
    }
}