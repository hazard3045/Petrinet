public class Transition extends Vertex{
    private boolean is_fireable;

    public Transition(boolean is_fireable){
        super();
        this.is_fireable = is_fireable;
    }
    

    public void fire(){
        if (this.is_fireable){
            for (int i=0;i<this.get_connexions().size();i++){
                if(this.get_connexions().get(i).get_output() == this ){
                    this.get_connexions().get(i).mod_input();
                }
                else {
                    this.get_connexions().get(i).mod_output();
                }
            }
        }
        else {
            // implémenter une levée d'exception pour prog sécuritaire
        }
    }

    public boolean is_fireable(){
        for (int i=0;i<this.get_connexions().size();i++){
            if (this.get_connexions().get(i).get_output() == this){
                if (!this.get_connexions().get(i).is_fireable()){
                    return false;
                }
            }
        }
        return true;
    }
}