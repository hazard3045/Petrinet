public class Place extends Vertex {
    private int tokens;
    private boolean is_empty;
    public Place(int tokens){
        super();
        this.tokens = tokens;
    }
    public void rm_tokens(int weight){
        this.tokens -= weight;
    }

    public void add_tokens(int weight){
        this.tokens += weight;
    }

    public void empty(){
        this.tokens = 0;
    }
}

