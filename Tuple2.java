import java.util.Objects;

public class Tuple2<T1, T2> {
    private final T1 first;
    private final T2 second;
    
    public Tuple2(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
    
    public T1 getFirst() {
        return first;
    }
    
    public T2 getSecond() {
        return second;
    }
    
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) obj;
        return Objects.equals(first, tuple2.first) && 
               Objects.equals(second, tuple2.second);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}