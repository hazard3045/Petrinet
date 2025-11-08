package src;
public class Place extends Vertex {
    private int tokens;
    private boolean is_empty;

    public Place(Integer tokens){
        super();
        this.tokens = tokens;
        this.is_empty = (tokens == 0);
    }

    public void rm_tokens(int weight){
        this.tokens -= weight;
        if (this.tokens == 0){
            this.is_empty = true;
        }
    }

    public void add_tokens(int weight){
        this.tokens += weight;
        this.is_empty = (this.tokens == 0);
    }

    public Integer get_tokens(){
        return this.tokens;
    }

    public boolean isEmpty(){
        return this.is_empty;
    }

    public void empty(){
        this.tokens = 0;
        this.is_empty = true;
    }
}

