public class Place extends Vertex {
    private int tokens;
    private boolean is_empty;

    public Place(Integer tokens){
        super();
        this.tokens = tokens;
    }

    public static Place create_place(Integer tokens){
        Place p = new Place(tokens);
        return p;
    }

    public void set_tokens(int tokens){
        this.tokens = tokens;
        if (this.tokens == 0){
            this.is_empty = true;
        }
        else {
            this.is_empty = false;
        }
    }

    public void rm_tokens(int weight){
        this.tokens -= weight;
        if (this.tokens == 0){
            this.is_empty = true;
        }
    }

    public void add_tokens(int weight){
        this.tokens += weight;
    }

    public Integer get_tokens(){
        return this.tokens;
    }

    public boolean get_is_empty(){
        return this.is_empty;
    }

    public void empty(){
        this.tokens = 0;
        this.is_empty = true;
    }
}

