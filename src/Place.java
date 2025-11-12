package src;
/**
 * Represents a Place in a Petri net, which holds a certain number of tokens.
 * Extends the Vertex class.
 *
 * <p>
 * A Place can add or remove tokens, check if it is empty, and be emptied.
 * The state of emptiness is tracked by the {@code is_empty} field.
 * </p>
 *

 */
public class Place extends Vertex {
    private int tokens;
    private boolean is_empty;

    public Place(Integer tokens){
        super();
        this.tokens = tokens;
        this.is_empty = (tokens == 0);
    }

    public void rmTokens(int weight){
        this.tokens -= weight;
        if (this.tokens == 0){
            this.is_empty = true;
        }
    }

    public void addTokens(int weight){
        this.tokens += weight;
        this.is_empty = (this.tokens == 0);
    }

    public Integer getTokens(){
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

