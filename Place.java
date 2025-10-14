public class Place extends Vertex {
    private int tokens;
    private boolean is_empty;

    public rm_tokens(int weight){
        tokens -= weight;
    }

    public add_tokens(int weight){
        tokens += weight;
    }

    public empty(){
        tokens = 0;
    }
}
