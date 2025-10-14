public class Place extends Vertex {
    private int tokens;
    private boolean is_empty;

    public void rm_tokens(int weight){
        tokens -= weight;
    }

    public void add_tokens(int weight){
        tokens += weight;
    }

    public void empty(){
        tokens = 0;
    }
}
